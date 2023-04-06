package Week1.Day1.Day26;

import java.util.Scanner;

public class TheDoor {
    private String password;
    private DoorStates doorStates;

    public static void main(String[] args) {
        TheDoor door = new TheDoor("abcd");
        System.out.println(DoorStates.LOCKED);
    }
    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public TheDoor(String password) {
        this.password = password;
    }

    public TheDoor() {
    }



    @Override
    public String toString() {
        return "TheDoor{" +
                "password='" + password + '\'' +
                ", doorStates=" + doorStates +
                '}';
    }
}
