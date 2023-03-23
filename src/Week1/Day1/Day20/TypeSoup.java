package Week1.Day1.Day20;

import java.util.Scanner;
import java.util.stream.Stream;

public enum TypeSoup {
    STEW ("Stew"),
    GUMB0 ("Gumbo"),
    SOUP( "Soup");
   final private String output;
    TypeSoup(String output){
        this.output = output;
    }

    public String getOutput() {
        return output;
    }
    public static TypeSoup loop(String choose){
        for(TypeSoup e: TypeSoup.values()){
            if(choose.equalsIgnoreCase(e.getOutput())){
                return e;
            }
        }
        return null;
    }
}
