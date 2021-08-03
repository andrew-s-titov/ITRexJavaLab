package task2PrinceGame;

import java.util.Queue;

public class Steps {
    public static void waveSteps (Cell[][][] field, Cell startWave, Queue<Cell> q) {
        waveLeft(field, startWave, q);
        waveRight(field, startWave, q);
        waveUp(field, startWave, q);
        waveDown(field, startWave, q);
        waveFloorDown(field, startWave, q);
    }

    private static void waveLeft(Cell[][][] field, Cell startWave, Queue<Cell> q) {
        if (startWave.getColumn() != 0) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()][startWave.getColumn()-1];
            waveIncrement(affected, startWave, q);
        }
    }

    private static void waveRight(Cell[][][] field, Cell startWave, Queue<Cell> q) {
        if (startWave.getColumn() != field[startWave.getLevel()][startWave.getLine()].length-1) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()][startWave.getColumn()+1];
            waveIncrement(affected, startWave, q);
        }
    }

    private static void waveUp(Cell[][][] field, Cell startWave, Queue<Cell> q) {
        if (startWave.getLine() != 0) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()-1][startWave.getColumn()];
            waveIncrement(affected, startWave, q);
        }
    }

    private static void waveDown(Cell[][][] field, Cell startWave, Queue<Cell> q) {
        if (startWave.getLine() != field[startWave.getLevel()].length-1) {
            Cell affected = field[startWave.getLevel()][startWave.getLine()+1][startWave.getColumn()];
            waveIncrement(affected, startWave, q);
        }
    }

    private static void waveFloorDown(Cell[][][] field, Cell startWave, Queue<Cell> q) {
        if (startWave.getLevel() != field.length-1) {
            Cell affected = field[startWave.getLevel()+1][startWave.getLine()][startWave.getColumn()];
            waveIncrement(affected, startWave, q);
        }
    }

    private static void waveIncrement (Cell affected, Cell startWave, Queue<Cell> q) {
        if (!affected.isWall() && !affected.isWalked() || (affected.isWalked() && affected.getDistance() > startWave.getDistance())) {
            affected.setDistance(startWave.getDistance() + 1);
            affected.setWalked(true);
            q.add(affected);
        }
    }
}
