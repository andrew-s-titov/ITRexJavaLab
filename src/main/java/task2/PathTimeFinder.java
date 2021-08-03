package task2;

import java.io.*;
import java.util.*;

public class PathTimeFinder {
    private final String fileName;

    public PathTimeFinder(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Finds the shortest path from the prince to the princess and calculates time.
     *
     * @param sec time for each prince's step
     * @return shortest amount of time for the prince to reach the princess
     */
    public int getTime(int sec) {
        return getShortestPath() * sec;
    }

    /**
     * Takes a file with a labyrinth parameters and finds a shortest path form a block where the prince is detected to
     * a block where the princess is detected.
     *
     * @return shortest amount of time for the prince to reach the princess.
     */
    private int getShortestPath() {
        try (FileParser parser = new FileParser(fileName)) {
            Cell[][][] field = parser.getField();
            Cell prince = parser.getPrince();
            Cell princess = parser.getPrincess();
            return findShortestPath(field, prince, princess);
        } catch (IOException e) {
            System.out.println("Something's wrong with the file. Please, start again or try to load another file.");
        }
        throw new IllegalArgumentException("The prince can't find the princess!");
    }

    /**
     * Starts a wave algorithm from a block where the prince is detected to find the shortest path to a block where
     * the princess is detected.
     *
     * @param field    the labyrinth field
     * @param prince   a block where the prince is detected
     * @param princess a block where the princess is detected
     * @return shortest amount of steps for the prince to reach the princess
     */
    private int findShortestPath(Cell[][][] field, Cell prince, Cell princess) {
        Queue<Cell> cellsQueue = new LinkedList<>();
        cellsQueue.add(prince);

        while (!cellsQueue.isEmpty()) {
            Cell topCellInTheQueue = cellsQueue.remove();
            if (topCellInTheQueue == princess) {
                return princess.getDistance();
            }
            Steps.waveSteps(field, topCellInTheQueue, cellsQueue);
        }
        throw new IllegalArgumentException("The prince can't find the princess!");
    }
}