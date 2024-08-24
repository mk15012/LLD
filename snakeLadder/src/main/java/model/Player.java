package model;

import lombok.Data;

@Data
public class Player {

    private String id;
    private int currentPosition;

    public Player(String id, int currentPosition) {
        this.id = id;
        this.currentPosition = currentPosition;
    }
}
