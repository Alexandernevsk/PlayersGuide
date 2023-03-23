package Week1.Day1.Day7;
import java.util.Scanner;
public class DominionOfKings {
    //Iemand speelt dominion!!
    public static void main(String[] args) {
        int totalPoints = 0;
        Scanner userInput = new Scanner(System.in);
        System.out.println("How many estates do you have milord?");
        totalPoints += userInput.nextInt();
        System.out.println("How many duchies do you have milord?");
        totalPoints = totalPoints + (userInput.nextInt() * 3);
        System.out.println("How many provinces do you have milord?");
        totalPoints = totalPoints + (userInput.nextInt()* 6);
        System.out.println("How many colonies do you have milord?");
        //Speel graag met uitbreidingen, dus deze moet er voor mij in!
        totalPoints = totalPoints + (userInput.nextInt() * 10);
        System.out.println("This is your total score: " + totalPoints + "!");
    }
}
