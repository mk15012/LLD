package dao;

import entity.Table;
import entity.TableColumn;
import entity.TableRow;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class TableDaoImpl implements TableDao {

    private final Map<String, Table> tableMap;

    public TableDaoImpl() {
        this.tableMap = new HashMap<>();
    }

    @Override
    public boolean createTable(String tableName, List<TableColumn> columnList) throws Exception {
        if (checkIfTableExists(tableName)) {
            throw new Exception("Table already exists");
        }

        Table table = new Table(tableName, columnList);
        tableMap.put(tableName, table);
        return true;
    }

    @Override
    public boolean deteleTable(String tableName) throws Exception {
        if (!checkIfTableExists(tableName)) {
            throw new Exception("Table " + tableName + " doesn't exist");
        }

        tableMap.remove(tableName);
        return true;
    }

    @Override
    public boolean insertEntry(String tableName, List<Object> values) throws Exception {
        if (!checkIfTableExists(tableName)) {
            throw new Exception("Table doesn't exist");
        }

        insertRow(tableName, values);
        return true;
    }

    @Override
    public boolean removeEntry(String tableName, int rowId) throws Exception {
        if (!checkIfTableExists(tableName)) {
            throw new Exception("Table doesn't exist");
        }

        return deleteRow(tableName, rowId);
    }

    @Override
    public boolean updateEntry(String tableName, int rowId, List<Object> values) throws Exception {
        if (!checkIfTableExists(tableName)) {
            throw new Exception("Table doesn't exist");
        }

        return updateRow(tableName, rowId, values);
    }

    @Override
    public List<String> getAllTableNames() throws Exception {
        return new ArrayList<>(tableMap.keySet());
    }

    @Override
    public List<TableRow> getAllRowsOfTable(String tableName) throws Exception {
        if (!checkIfTableExists(tableName)) {
            throw new Exception("Table doesn't exist");
        }

        return tableMap.get(tableName).getRowList();
    }

    private boolean checkIfTableExists(String tableName) {
        return tableMap.containsKey(tableName);
    }

    public boolean insertRow(String tableName, List<Object> values) throws Exception {
        validateRow(tableName, values);

        Table table = tableMap.get(tableName);
        int nextRowId = table.getNextRowId() + 1;
        Map<TableColumn, Object> valuesMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            valuesMap.put(table.getColumnList().get(i), values.get(i));
        }

        TableRow newRow = new TableRow(nextRowId, valuesMap);
        tableMap.get(tableName).getRowList().add(newRow);
        return true;
    }

    public boolean updateRow(String tableName, int rowId, List<Object> values) throws Exception {
        validateRow(tableName, values);

        Table table = tableMap.get(tableName);
        Map<TableColumn, Object> valuesMap = new HashMap<>();
        for (int i = 0; i < values.size(); i++) {
            valuesMap.put(table.getColumnList().get(i), values.get(i));
        }

        TableRow exisitingRow = tableMap.get(tableName).getRowList().stream().filter(row -> row.getRowId() == rowId).findAny().orElse(null);
        if(Objects.isNull(exisitingRow)) {
            throw new Exception("No such row exists");
        }

        exisitingRow.setColumns(valuesMap);
        return true;
    }

    public boolean deleteRow(String tableName, int rowId) {

        Table table = tableMap.get(tableName);
        TableRow rowTobeDeleted = table.getRowList().stream().filter(row -> row.getRowId() == rowId).findAny().orElse(null);
        if (Objects.isNull(rowTobeDeleted)) {
            return false;
        }

        tableMap.get(tableName).getRowList().remove(rowTobeDeleted);
        return true;
    }

    private void validateRow(String tableName, List<Object> values) throws Exception {
        Table table = tableMap.get(tableName);
        if (values.size() != table.getColumnList().size()) {
            throw new Exception("Number of items in row doesn't match number of headers in the table");
        }

        for (int i = 0; i < values.size(); i++) {
            TableColumn tableColumn = tableMap.get(tableName).getColumnList().get(i);
            Object value = values.get(i);

            switch (tableColumn.getConstraint()) {
                case NONE:
                    break;
                case STRING_LENGTH_20:
                    String inputString = String.valueOf(value);
                    if (inputString.length() > 20) {
                        throw new Exception("String Value at column: " + i + " violates constraint " + tableColumn.getConstraint().name() + " for value " + value);
                    }
                    break;
                case INT_RANGE_1024:
                    int inputValue = (int) value;
                    if (inputValue > 1024 || inputValue < -1024) {
                        throw new Exception("Integer Value at column: " + i + " violates constraint " + tableColumn.getConstraint().name() + " for value " + value);
                    }
                    break;
                default:
                    break;
            }

        }
    }


}
