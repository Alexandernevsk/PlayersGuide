package Week1.Day1.Day29;

public enum Directions {
    UP(0,1), DOWN(0,-1), LEFT(-1,0), RIGHT(1,0);

    public final int dx, dy;
    Directions(int dx, int dy){
        this.dx = dx;
        this.dy = dy;
    }

    public static Coordinates moveCoordinate (Directions directions, Coordinates coordinates){
        return new Coordinates(coordinates.x() +directions.dx, coordinates.y() +directions.dy);
    }
}
