package manager;

import dao.TableDao;
import entity.TableColumn;
import entity.TableRow;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DbMangerImpl {

    private TableDao tableDao;

    public boolean createTable(String tableName, List<TableColumn> columnList) throws Exception {
        return tableDao.createTable(tableName, columnList);
    }

    public boolean deteleTable(String tableName) throws Exception {
        return tableDao.deteleTable(tableName);
    }

    public boolean insertEntry(String tableName, List<Object> values) throws Exception {
        return tableDao.insertEntry(tableName, values);
    }

    public boolean removeEntry(String tableName, int rowId) throws Exception {
        return tableDao.removeEntry(tableName, rowId);

    }

    public boolean updateEntry(String tableName, int rowId, List<Object> values) throws Exception {
        return tableDao.updateEntry(tableName, rowId, values);

    }

    public List<String> getAllTableNames() throws Exception {
        return tableDao.getAllTableNames();
    }

    public List<TableRow> getAllRowsOfTable(String tableName) throws Exception {
        return tableDao.getAllRowsOfTable(tableName);
    }
}
