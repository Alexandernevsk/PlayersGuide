package Week1.Day1.Day20;

import java.util.stream.Stream;

public enum SeasoningSoup {
    SPICY,
    SALTY,
    SWEET;

    @Override
    public String toString() {
        return this.name().charAt(0) + name().substring(1).toLowerCase();
    }


    public static SeasoningSoup loop(String choose) {
        for (SeasoningSoup e : SeasoningSoup.values()) {
            if (choose.equalsIgnoreCase(e.toString())) {
                return e;
            }
        }
        return null;
    }
}
