package Week1.Day1.Day16;

import java.awt.font.NumericShaper;
import java.util.Scanner;


public class Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //askNumber("Type in a number.");
        ForNumberInRange("Type a min value, max value, and a number in of that range.",
                input.nextInt(), input.nextInt());
    }
    public static int askNumber(String text){
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        String convert = input.nextLine();
        int number = Integer.parseInt(convert);
        System.out.println("This is what you typed: " + number);
        return number;
    }
    public static int ForNumberInRange(String text,int min, int max){
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        int inputNumber = input.nextInt();
        while(inputNumber < min || inputNumber > max){
            System.out.println("Number is ouf of range. Please try again!");
            inputNumber = input.nextInt();
            }
        System.out.println("That number is in range");
        return inputNumber;
    }
}
