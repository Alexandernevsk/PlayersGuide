package Week1.Day1.Day39;

public class ExecuteGame {
    public static void main(String[] args) {
        System.out.println("Welcome to the Fountain of objects!");
        System.out.println("You can move vertically or horizontally, and toggle the fountain of objects");
        new Controller().gameLoop();
    }
}
