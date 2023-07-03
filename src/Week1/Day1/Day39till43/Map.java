package Week1.Day1.Day39till43;

import java.util.HashMap;

public class Map {
    HashMap<Coordinate, RoomType> maze = new HashMap<>();
    private final int height;
    private final int width;

    /**
     * TODO: For a bit more complication, I could add more Fountains or Entrances;
     * ArrayList<Coordinate> fountains = new ArrayList<>();
     * ArrayList<Coordinate> entrances = new ArrayList<>();
     */

    Coordinate fountainLocation = new Coordinate(2, 0);
    Coordinate pitLocation = new Coordinate(3, 0);
    Coordinate entranceLocation = new Coordinate(0, 0);

    //Keeps track whether changes in Coordinates are within Bounds of the Map
    public boolean outOfBounds(Coordinate coordinate) {
        return ((coordinate.row() < 0 || coordinate.row() >= getWidth()) || (coordinate.column() < 0 || coordinate.column() >= getHeight()));
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public Map(int height, int width) {
        this.height = height;
        this.width = width;

        for (int row = 0; row < width; row++) {
            for (int column = 0; column < height; column++) {
                maze.put(new Coordinate(row, column), new Empty());
            }
        }

        maze.put(fountainLocation, new Fountain());
        maze.put(pitLocation, new Pit());
        maze.put(entranceLocation, new Entrance());

    }
}
