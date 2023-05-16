package Week1.Day1.Day16;

import java.awt.font.NumericShaper;
import java.util.Scanner;


public class Number {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        //askNumber("Type in a number.");
        System.out.println("Type a min value, max value, and a number in of that range.");
        ForNumberInRange(input.nextInt(), input.nextInt());
    }
    public static int askNumber(String text){
        System.out.println(text);
        Scanner input = new Scanner(System.in);
        String convert = input.nextLine();
        int number = Integer.parseInt(convert);
        System.out.println("This is what you typed: " + number);
        return number;
    }
    public static int ForNumberInRange(int min, int max){
        Scanner input = new Scanner(System.in);
        System.out.println("Type a number in the range of the two numbers");
        int inputNumber = askNumber(input.nextLine());
        while(inputNumber < min || inputNumber > max){
            System.out.println("Number is ouf of range. Please try again!");
            inputNumber = input.nextInt();
            }
        System.out.println("That number is in range");
        return inputNumber;
    }
}
