package model;

import lombok.Data;

import java.util.concurrent.ThreadLocalRandom;

@Data
public class Board {

    private int size;
    private Cell[][] cells;

    public Board(int size, int numberOfSnakes, int numberOfLadders) {
        this.size = size;
        this.cells = new Cell[size][size];

        initializeCells();
        addSnakesLadders(numberOfSnakes, numberOfLadders);
    }


    private void initializeCells() {
        for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                Cell cell = new Cell();
                cells[i][j] = cell;
            }
        }
    }


    private void addSnakesLadders(int numberOfSnakes, int numberOfLadders) {
        while (numberOfSnakes > 0) {
            int snakeHead = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            int snakeTail = ThreadLocalRandom.current().nextInt(1, size * size - 1);

            if (snakeHead <= snakeTail) {
                continue;
            }

            Jump jump = new Jump(snakeHead, snakeTail);
            cells[snakeHead / size][snakeHead % size] = new Cell(jump);
            numberOfSnakes--;
        }

        while (numberOfLadders > 0) {
            int ladderHead = ThreadLocalRandom.current().nextInt(1, size * size - 1);
            int ladderTail = ThreadLocalRandom.current().nextInt(1, size * size - 1);

            if (ladderHead >= ladderTail) {
                continue;
            }

            Jump jump = new Jump(ladderHead, ladderTail);
            cells[ladderHead / size][ladderHead % size] = new Cell(jump);
            numberOfLadders--;
        }
    }
}
