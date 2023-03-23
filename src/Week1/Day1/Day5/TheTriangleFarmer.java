package Week1.Day1.Day5;

import java.util.Scanner;

public class TheTriangleFarmer {
    public static void calcTriangle(){
        System.out.println("What is the height?");
        Scanner input = new Scanner(System.in);
        double height = input.nextDouble();
        System.out.println("What is the base?");
        double base = input.nextDouble();
        System.out.print("The area is: " + (height * base)/2);
    }
    public static void main(String[] args) {calcTriangle();}
}
