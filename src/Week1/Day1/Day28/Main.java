package Week1.Day1.Day28;


import java.util.ArrayList;
import java.util.Objects;


public class Main {
    //n! / (n1... nt) where t is number of exact orderings
    /* Sketch:
     * Take a String like "TTT" with two possible options T, H
     * Change the first or last char to another letter for example TTT -> TTH or HTT.
     * Now repeat the process before you get to HHH.
     * We now have the following steps -> TTT -> TTH -> THH.
     * If we reverse all string to the other output we get -> HHH -> HHT -> HTT.
     * The only ones missed are THT and HTH.
     */
    final ArrayList<String> possibilities = new ArrayList<>();

    public static void main(String[] args) {
        Main main = new Main();
        main.setPossibilities();
        System.out.println(main.possibilities);
    }
    public void setPossibilities(){

    }

}




