package Day9;

import java.util.Scanner;
public class Clocktower {
    public static void main(String[] args) {
        Scanner userinput = new Scanner(System.in);
        tickTock(userinput.nextInt());
    }
    public static void tickTock (int sound){
        if(sound % 2 == 0){
            System.out.println("Tick");
        }else System.out.println("Tock");
    }
}
