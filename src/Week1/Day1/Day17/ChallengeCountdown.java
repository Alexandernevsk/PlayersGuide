package Week1.Day1.Day17;

import java.util.ArrayList;

public class ChallengeCountdown {
    public static void main(String[] args) {

    }
    public static int countdown(int counter) {
        if (counter > 20) {
            System.out.println(counter);
            return counter;
        }
        System.out.println(counter);
       int sum = countdown(counter-1) + counter;
       return sum;
    }

}



