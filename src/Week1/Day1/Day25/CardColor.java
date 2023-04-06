package Week1.Day1.Day25;


import java.util.Arrays;

public enum CardColor {
    RED,GREEN, BLUE, YELLOW;
    public static CardColor displayall(int i) {
        for (CardColor e : CardColor.values()) {
            if(e.ordinal() == i){
                return e;
            }
        }
        return null;
    }
}
