package Week1.Day1.Day18;
import java.util.Scanner;
public class Manticore {
    public static void main(String[] args) {
        setNumber();
    }
    public static void setNumber() {
        Scanner input = new Scanner(System.in);
        System.out.println("Please type in a number between 1 and 100.");
        int mark = input.nextInt();
        //Anti cheat loop
        while (mark < 1 || mark > 100) {
            System.out.println("Number is not in range. Please type in another number.");
            mark = input.nextInt();
            if (mark >= 1 && mark <= 100) {
                System.out.println(" That number is in range.");
                guessNumber(mark);
            }
        }
        guessNumber(mark);
    }
    public static void guessNumber(int mark){
        Game game = new Game();
        System.out.println("Guess the number that's between 0 and 100.");
        Scanner input1 = new Scanner(System.in);
        int guess = input1.nextInt();
        int counter = 1;
        while(game.displayManticoreHp() >= 1 && game.displayConsolas() >= 1) {
            System.out.println("Attempt: " + counter);
            if (guess > mark) {
                System.out.println("That's too high, guess again!");
                game.reduceConsolasHp();
            } else if (guess < mark) {
                System.out.println("That's too low, guess again");
                game.reduceConsolasHp();
            } else {
                System.out.println("You hit the manticore. Good Job!");
                game.reduceManticoreHp(counter);
                if(game.displayManticoreHp() == 0){
                    System.out.println("The city is saved, you defeated the Manticore");
                    System.out.println("Wanna play again?");
                    Scanner yes = new Scanner(System.in);
                    String yes_no = yes.nextLine();
                    if(yes_no.contains("yes")){
                        setNumber();
                    }
                }
            }  if (game.displayConsolas() == 0) {
                System.out.println("The city is ruined, the Manticore is victorious.");
                System.out.println("Wanna play again?");
                Scanner yes = new Scanner(System.in);
                String yes_no = yes.nextLine();
                if (yes_no.contains("yes")) {
                    setNumber();
                }
            }
            System.out.println("The manticore is now at: " + game.displayManticoreHp());
            System.out.println("Consolas is now at: " + game.displayConsolas());
            guess = input1.nextInt();
            counter++;
        }
    }
}




