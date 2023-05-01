package Week1.Day1.Day28;

public enum Result {
    WIN, LOSS, DRAW;


    @Override
    public String toString() {
        return this.name().charAt(0) + this.name().substring(1).toLowerCase();
    }

}
