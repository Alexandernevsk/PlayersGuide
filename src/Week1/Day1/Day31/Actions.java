package Week1.Day1.Day31;

public enum Actions {
    //most are combinations except for center,
   CENTER(1,1), RIGHT(1,0), LEFT(-1,0), TOP(1,0), BOTTOM(1,2);

   private final int x,y;

    Actions(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
