package Week1.Day1.Day18;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Mechanics {
    private int mark;
    private final Manticore manticore;
    private final Consolas consolas;
    private int counter = 1;


    public static void gameLoop(Mechanics mechanics){
        while (mechanics.counter <= 15) {
            System.out.println(mechanics);
            System.out.println("Enter your number");
            mechanics.manageHealth(mechanics.manticore, mechanics.consolas, mechanics.checkHit(mechanics.userInput()));
            mechanics.counter++;
            if(mechanics.manticore.displayManticoreHp() < 1){
               win();
            }else if(mechanics.consolas.displayConsolas() < 1){
                lose();
            }
        }
    }
    //Initialized a new object here so that all values of object are reset to standard settings.
    public static void initializer (){
        Mechanics initializer = new Mechanics();
        gameLoop(initializer);
    }
    public static void win () {
        System.out.println("\n");
        System.out.println("You defeated the Manticore! You are victorius.");
        System.out.println("Do you want to play again? Type in y/n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("y")) {
           initializer();
        }else System.exit(0);
    }
    public static void lose(){
        System.out.println("\n");
        System.out.println("Consolas is reduced to rumble! You are defeated.");
        System.out.println("Do you want to play again? Type in y/n");
        Scanner scanner = new Scanner(System.in);
        if (scanner.nextLine().equalsIgnoreCase("y")) {
            initializer();
        }else System.exit(0);
    }

    public int userInput(){
        Scanner scanner = new Scanner(System.in);
        try {return scanner.nextInt();}
        catch (InputMismatchException e){
            System.out.println("You can only type in a number!");
        }
        return userInput();
    }
    //No penalty for numbers out of bounds. Program checks first whether the hit is valid before continuing.
    public  int setNumber(int guess) {
        while (true) {
            if(guess >= 1 && guess <= 100){
                return guess;
            }
            System.out.println("Number is not in range. Please type in another number.");
            guess = setNumber(userInput());
        }
    }
    //Quasi zero-args constructor where only the mark is set with bounds checking.
    public Mechanics () {
        Manticore manticore = new Manticore();
        Consolas consolas = new Consolas();
        this.manticore = manticore;
        this.consolas = consolas;
        while(true){
            System.out.println("Enter your mark.");
            mark = userInput();
            if(mark >= 1){
                if(mark <= 100){
                    break;
                }
            }
            System.out.println("Number can't be smaller than 1 or bigger than 100.");
        }
    }
    //The intermediary stage that translate number into a true or false statement to calculate Manticore and Consolas Hp.
    public boolean checkHit(int guess ){
            guess = setNumber(guess);
            if (guess > mark) {
                System.out.println("Too high");
                return false;
            } else if (guess < mark) {
                System.out.println("Too low");
                return false;
            } else{
                return true;
            }
    }
    //Game logic is binary: either you hit or you don't. This makes it useful for a boolean.
    public void manageHealth(Manticore manticore, Consolas consolas, boolean check){
        if(check){
            manticore.reduceManticoreHp(counter);
        }else consolas.reduceConsolasHp();
    }

    //Overridden the default ToString Method to display all values relevant for the user through a object.
    @Override
    public String toString() {
        return "Manticore is at: " + manticore.displayManticoreHp() + ". Consolas is at: " + consolas.displayConsolas()
                + ". Turn is: " + counter;
    }
}
