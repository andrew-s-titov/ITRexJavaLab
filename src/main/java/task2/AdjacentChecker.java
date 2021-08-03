package task2;

import java.util.Queue;

public class AdjacentChecker {
    public static void putAllAdjacentToQueue(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        checkLeft(field, startCell, cellsQueue);
        checkRight(field, startCell, cellsQueue);
        checkUp(field, startCell, cellsQueue);
        checkDown(field, startCell, cellsQueue);
        checkFloorDown(field, startCell, cellsQueue);
    }

    private static void checkLeft(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        if (startCell.getColumn() != 0) {
            Cell affected = field[startCell.getLevel()][startCell.getLine()][startCell.getColumn() - 1];
            putAdjacentToQueue(affected, startCell, cellsQueue);
        }
    }

    private static void checkRight(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        if (startCell.getColumn() != field[startCell.getLevel()][startCell.getLine()].length - 1) {
            Cell affected = field[startCell.getLevel()][startCell.getLine()][startCell.getColumn() + 1];
            putAdjacentToQueue(affected, startCell, cellsQueue);
        }
    }

    private static void checkUp(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        if (startCell.getLine() != 0) {
            Cell affected = field[startCell.getLevel()][startCell.getLine() - 1][startCell.getColumn()];
            putAdjacentToQueue(affected, startCell, cellsQueue);
        }
    }

    private static void checkDown(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        if (startCell.getLine() != field[startCell.getLevel()].length - 1) {
            Cell affected = field[startCell.getLevel()][startCell.getLine() + 1][startCell.getColumn()];
            putAdjacentToQueue(affected, startCell, cellsQueue);
        }
    }

    private static void checkFloorDown(Cell[][][] field, Cell startCell, Queue<Cell> cellsQueue) {
        if (startCell.getLevel() != field.length - 1) {
            Cell affected = field[startCell.getLevel() + 1][startCell.getLine()][startCell.getColumn()];
            putAdjacentToQueue(affected, startCell, cellsQueue);
        }
    }

    private static void putAdjacentToQueue(Cell affected, Cell startCell, Queue<Cell> cellsQueue) {
        if (!affected.isWall() && !affected.isWalked()) {
            affected.setDistance(startCell.getDistance() + 1);
            affected.setWalked(true);
            cellsQueue.add(affected);
        }
    }
}
