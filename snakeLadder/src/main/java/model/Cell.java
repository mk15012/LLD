package model;

import lombok.Data;

@Data
public class Cell {

    private Jump jump;

    public Cell() {
    }

    public Cell(Jump jump) {
        this.jump = jump;
    }
}
