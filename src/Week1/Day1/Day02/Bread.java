package Week1.Day1.Day02;

import java.util.Scanner;
public class Bread {
    public static void main(String[] args) {
        System.out.println("Bread is ready.");
        System.out.println("Who is the bread for?");
        Scanner kropotkin = new Scanner(System.in);
        System.out.println("Noted: " + kropotkin.nextLine() + " got bread.");
    }
}
