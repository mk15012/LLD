package entity;

import lombok.Data;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Data
public class Table {

    private static int nextRowId;
    private String name;
    private List<TableColumn> columnList;
    private List<TableRow> rowList;
    private Timestamp createdOn;
    private Timestamp lastModifiedOn;

    public Table(String name, List<TableColumn> columnList) {
        this.name = name;
        nextRowId = 0;
        this.columnList = columnList;
        this.rowList = new ArrayList<>();
        this.createdOn = new Timestamp(System.currentTimeMillis());
    }

    public int getNextRowId() {
        return nextRowId;
    }
}
