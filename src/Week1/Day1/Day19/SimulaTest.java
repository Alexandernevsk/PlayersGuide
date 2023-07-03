package Week1.Day1.Day19;


import java.util.Scanner;

//Can be written much cleaner


public class SimulaTest {
    public static void main(String[] args) {
        switchingChestStates();
    }
    public static void switchingChestStates() {
        Scanner in = new Scanner(System.in);
        Chest chest = new Chest(ChestStates.OPEN);
        System.out.println("Do you want to do something with the chest? Please type in yes to continue.");
        String choosing = in.nextLine();
        while (choosing.contains("yes")) {
            System.out.println("Chest is currently: "+ chest.getStatus());
            System.out.println("What do you want to do with the chest? Open, Close, or Lock it?");
            Scanner states = new Scanner(System.in);
            String chestSwitch = states.nextLine();
            chest.setStatus(chestSwitch);
            System.out.println(chest.getStatus());
            System.out.println("Do you want to do something with the chest? Please type in yes to continue.");
            choosing = in.nextLine();
        }
    }
}