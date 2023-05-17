package Week1.Day1.Day31;

public enum DotCross {
    DOT("0"), CROSS("X"), NONE("");

    private final String symbol;

    DotCross(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
        return symbol;
    }
}
