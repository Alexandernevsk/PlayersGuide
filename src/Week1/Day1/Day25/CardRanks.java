package Week1.Day1.Day25;

import java.util.Arrays;

public enum CardRanks {
    N1 ("1"),N2("2"),N3("3"),N4("4"),N5 ("5"),
    N6("6"),N7("7"),N8("8"),N9("9"),N10("10"),
    S1("@"),S2("%"),S3("$"),S4("^");
    private final String symbols;
    CardRanks(String symbols) {
        this.symbols = symbols;
    }

    public String getSymbols() {
        return symbols;
    }

    public static CardRanks displayall(int i){
        for(CardRanks e: CardRanks.values()){
            if(e.ordinal() == i){
                return e;
            }
        }
        return null;
    }
}
