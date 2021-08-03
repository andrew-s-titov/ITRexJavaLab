package task2PrinceGame;

import java.io.BufferedReader;
import java.io.Closeable;
import java.io.FileReader;
import java.io.IOException;

public class FileParser implements Closeable {
    BufferedReader reader;
    private Cell[][][] field;
    private Cell prince = null;
    private Cell princess = null;

    public FileParser (String fileName) throws IOException {
        reader = new BufferedReader(new FileReader (fileName));
        parseFile();
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
     * Parses the given file, create field with block and get prince and princess locations.
     * @throws IOException
     */
    private void parseFile() throws IOException{
        String params = reader.readLine();

        if (params.length() < 5) {
            throw new IllegalArgumentException("Can't find all params");
        }

        int levels = Integer.parseInt(params, 0, 1, 10);
        int lines = Integer.parseInt(params, 2, 3, 10);
        int columns = Integer.parseInt(params, 4, 5, 10);

        // setting the labyrinth parameters
        this.field = new Cell[levels][lines][columns];

        // setting the labyrinth parameters
        // for every level
        for (int lev = 0; lev < field.length; lev++) {
            // skipping one line
            reader.readLine();
            // for every line
            for (int line = 0; line < field[lev].length; line++) {
                char[] cellTypes = reader.readLine().toCharArray();
                // for every column
                for (int col = 0; col < field[lev][line].length; col++) {
                    char type = cellTypes[col];
                    switch (type) {
                        case ('o'):
                            field[lev][line][col] = new Cell(true, lev, line, col);
                            break;
                        case ('.'):
                            field[lev][line][col] = new Cell(false, lev, line, col);
                            break;
                        case ('1'):
                            field[lev][line][col] = new Cell(false, lev, line, col);
                            prince = field[lev][line][col];
                            prince.setDistance(0);
                            prince.setWalked(true);
                            break;
                        case ('2'):
                            field[lev][line][col] = new Cell(false, lev, line, col);
                            princess = field[lev][line][col];
                            break;
                    }
                }
            }
        }
    }

    @Override
    public void close() throws IOException {
        reader.close();
    }
}
