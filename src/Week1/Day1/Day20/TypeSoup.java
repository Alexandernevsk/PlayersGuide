package Week1.Day1.Day20;

import java.util.Scanner;
import java.util.stream.Stream;

public enum TypeSoup {
    STEW,
    GUMBO,
    SOUP;

    @Override
    public String toString() {
        return this.name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static TypeSoup loop(String choose){
        for(TypeSoup e: TypeSoup.values()){
            if(choose.equalsIgnoreCase(e.toString())){
                return e;
            }
        }
        return null;
    }

}
