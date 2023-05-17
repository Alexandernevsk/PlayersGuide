package Week1.Day1.Day31;

public enum Cross_Dots {
    CROSS("X"), DOTS("0"), NONE(" ");

    private final String symbol;

    Cross_Dots(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString() {
       return this.symbol;
    }
}
