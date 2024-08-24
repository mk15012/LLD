package dao;

import entity.TableColumn;
import entity.TableRow;

import java.util.List;

public interface TableDao {

    boolean createTable(String tableName, List<TableColumn> columnList) throws Exception;

    boolean deteleTable(String tableName) throws Exception;

    boolean insertEntry(String tableName, List<Object> values) throws Exception;

    boolean removeEntry(String tableName, int rowId) throws Exception;

    boolean updateEntry(String tableName, int rowId, List<Object> values) throws Exception;

    List<String> getAllTableNames() throws Exception;

    List<TableRow> getAllRowsOfTable(String tableName) throws Exception;
}
