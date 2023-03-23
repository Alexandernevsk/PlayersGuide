package Week1.Day1.Day20;

import java.util.stream.Stream;

public enum SeasoningSoup {
    SPICY ("Spicy"),
    SALTY ("Salty"),
    SWEET ("Sweet");
   final private String output;
    SeasoningSoup(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
    public static SeasoningSoup loop(String choose){
        for(SeasoningSoup e: SeasoningSoup.values()){
            if(choose.equalsIgnoreCase(e.getOutput())){
                return e;
            }
        }
        return null;
    }
}
