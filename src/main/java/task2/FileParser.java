package task2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileParser {

    private Cell[][][] field;
    private Cell prince = null;
    private Cell princess = null;

    public FileParser(String fileName) {
        parseFile(fileName);
    }

    public Cell[][][] getField() {
        if (field != null) {
            return field;
        } else {
            throw new IllegalArgumentException("Field params wasn't found");
        }
    }

    public Cell getPrince() {
        if (prince != null) {
            return prince;
        } else {
            throw new IllegalArgumentException("Prince wasn't found");
        }
    }

    public Cell getPrincess() {
        if (princess != null) {
            return princess;
        } else {
            throw new IllegalArgumentException("Princess wasn't found");
        }
    }

    /**
     * Parses the given file, creates a field with blocks and sets prince and princess locations.
     *
     * @param fileName name of a file with field params
     */
    private void parseFile(String fileName) {
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String params = reader.readLine();

            if (params.length() < 5) {
                throw new IllegalArgumentException("Can't find all params");
            }

            int levels = Integer.parseInt(params, 0, 1, 10);
            int lines = Integer.parseInt(params, 2, 3, 10);
            int columns = Integer.parseInt(params, 4, 5, 10);

            // setting the labyrinth size
            this.field = new Cell[levels][lines][columns];

            // setting the labyrinth's blocks parameters
            for (int level = 0; level < field.length; level++) {
                // skipping one line
                reader.readLine();
                readLevel(reader, level);
            }
        } catch (IOException e) {
            throw new RuntimeException("File reading error: " + e);
        }
    }

    private void readLevel(BufferedReader reader, int level) throws IOException {
        for (int line = 0; line < field[level].length; line++) {
            readLine(reader, level, line);
        }
    }

    private void readLine(BufferedReader reader, int level, int line) throws IOException {
        char[] cellTypes = reader.readLine().toCharArray();
        for (int column = 0; column < field[level][line].length; column++) {
            readColumn(cellTypes[column], level, line, column);
        }
    }

    private void readColumn(char type, int level, int line, int column) {
        switch (type) {
            case ('o'):
                field[level][line][column] = new Cell(true, level, line, column);
                break;
            case ('.'):
                field[level][line][column] = new Cell(false, level, line, column);
                break;
            case ('1'):
                field[level][line][column] = new Cell(false, level, line, column);
                prince = field[level][line][column];
                prince.setDistance(0);
                prince.setWalked(true);
                break;
            case ('2'):
                field[level][line][column] = new Cell(false, level, line, column);
                princess = field[level][line][column];
                break;
        }
    }
}
