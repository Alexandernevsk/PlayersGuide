package Week1.Day1.Day12;

import java.util.Scanner;

public class Prototype {
    public static void main(String[] args) {
        setNumber();

        }
    private static void setNumber(){
        Scanner input = new Scanner(System.in);
        System.out.println("What number between 0 and 100 do you choose?");
        int mark = input.nextInt();
        guessNumber(mark);
    }
  public static void guessNumber(int mark) {
      System.out.println("Guess the number that's between 0 and 100.");
      Scanner input1 = new Scanner(System.in);
      int guess = input1.nextInt();
      while(guess != mark) {
          if (guess > mark) {
              System.out.println("That's too high, guess again!");
          } else if (guess < mark) {
              System.out.println("That's too low, guess again");
          }
          guess = input1.nextInt();
        }
        again();
      }
    public static void again(){
        System.out.println("You did it! Do you wanna play again?\t Type in yes to continue playing.");
        Scanner input = new Scanner(System.in);
        String yes = input.nextLine();
        if(yes.contains("yes") || yes.contains("Yes")){
            setNumber();
        }
    }
}