package task2;

import java.util.Queue;

public class Steps {
    public static void waveSteps(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        waveLeft(field, startWave, cellsQueue);
        waveRight(field, startWave, cellsQueue);
        waveUp(field, startWave, cellsQueue);
        waveDown(field, startWave, cellsQueue);
        waveFloorDown(field, startWave, cellsQueue);
    }

    private static void waveLeft(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        if (startWave.getColumn() != 0) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()][startWave.getColumn() - 1];
            waveIncrement(affected, startWave, cellsQueue);
        }
    }

    private static void waveRight(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        if (startWave.getColumn() != field[startWave.getLevel()][startWave.getLine()].length - 1) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()][startWave.getColumn() + 1];
            waveIncrement(affected, startWave, cellsQueue);
        }
    }

    private static void waveUp(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        if (startWave.getLine() != 0) {
            Cell affected = field[startWave.getLevel()][startWave.getLine() - 1][startWave.getColumn()];
            waveIncrement(affected, startWave, cellsQueue);
        }
    }

    private static void waveDown(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        if (startWave.getLine() != field[startWave.getLevel()].length - 1) {
            Cell affected = field[startWave.getLevel()][startWave.getLine() + 1][startWave.getColumn()];
            waveIncrement(affected, startWave, cellsQueue);
        }
    }

    private static void waveFloorDown(Cell[][][] field, Cell startWave, Queue<Cell> cellsQueue) {
        if (startWave.getLevel() != field.length - 1) {
            Cell affected = field[startWave.getLevel() + 1][startWave.getLine()][startWave.getColumn()];
            waveIncrement(affected, startWave, cellsQueue);
        }
    }

    private static void waveIncrement(Cell affected, Cell startWave, Queue<Cell> cellsQueue) {
        if (!affected.isWall() && !affected.isWalked()) {
            affected.setDistance(startWave.getDistance() + 1);
            affected.setWalked(true);
            cellsQueue.add(affected);
        }
    }
}
