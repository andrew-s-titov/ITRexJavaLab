package task2;

public class Cell {
    private int distance;
    private boolean walked;
    final private boolean isWall;
    final private int level;
    final private int line;
    final private int column;

    public Cell(boolean isWall, int level, int line, int column) {
        this.isWall = isWall;
        this.level = level;
        this.line = line;
        this.column = column;
        this.walked = false;
    }

    public int getLevel() {
        return level;
    }

    public int getLine() {
        return line;
    }

    public int getColumn() {
        return column;
    }

    public int getDistance() {
        return distance;
    }

    public void setDistance(int distance) {
        this.distance = distance;
    }

    public boolean isWalked() {
        return walked;
    }

    public void setWalked(boolean walked) {
        this.walked = walked;
    }

    public boolean isWall() {
        return isWall;
    }
}
