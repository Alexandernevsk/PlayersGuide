package Week1.Day1.Day18;



public class Game {
    public static void main(String[] args) {
        System.out.println("Welcome to the number guessing Game.");
        System.out.println("The manticore is flying above the city, and you need to know it's position.");
        System.out.println("You do this by guessing a number between 1 and 100");
        System.out.println("If you have guessed correctly you damage the Manticore by one.");
        System.out.println("Every 3, 5, and 15 turns you deliver a special attack.");
        System.out.println("For 3, 5 you deliver three points of damage, for turn 15 the Manticore loses all his HP.");
        System.out.println();
        Mechanics  mechanics = new Mechanics();
        Mechanics.gameLoop(mechanics);
    }





}

