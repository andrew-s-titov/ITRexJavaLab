package task2;

import java.util.LinkedList;
import java.util.Queue;

public class PathTimeFinder {
    final private Cell[][][] field;
    final private Cell prince;
    final private Cell princess;

    public PathTimeFinder(Cell[][][] field, Cell prince, Cell princess) {
        this.field = field;
        this.prince = prince;
        this.princess = princess;
    }

    /**
     * Finds the shortest path from the prince to the princess and calculates time.
     *
     * @param sec time for each prince's step
     * @return shortest amount of time for the prince to reach the princess
     */
    public int getTime(int sec) {
        return findShortestPath() * sec;
    }

    /**
     * Starts a wave algorithm from a block where the prince is detected to find the shortest path to a block where
     * the princess is detected.
     *
     * @return shortest amount of steps for the prince to reach the princess
     */
    private int findShortestPath() {
        Queue<Cell> cellsQueue = new LinkedList<>();
        cellsQueue.add(prince);

        while (!cellsQueue.isEmpty()) {
            Cell topCellInQueue = cellsQueue.remove();
            if (topCellInQueue == princess) {
                return princess.getDistance();
            }
            AdjacentChecker.putAllAdjacentToQueue(field, topCellInQueue, cellsQueue);
        }
        throw new IllegalArgumentException("The prince can't find the princess!");
    }
}