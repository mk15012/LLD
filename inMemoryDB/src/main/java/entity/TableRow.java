package entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.Map;

@Data
public class TableRow {

    private int rowId;
    private Map<TableColumn, Object> columns;
    private Timestamp createdOn;
    private Timestamp lastModifiedOn;

    public TableRow(int rowId, Map<TableColumn, Object> columns) {
        this.columns = columns;
        this.rowId = rowId;
        this.createdOn = new Timestamp(System.currentTimeMillis());
        this.lastModifiedOn = new Timestamp(System.currentTimeMillis());
    }
}
