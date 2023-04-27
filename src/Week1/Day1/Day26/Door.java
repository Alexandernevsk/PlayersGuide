package Week1.Day1.Day26;

import java.util.Scanner;

public class Door {
    private String password;
    private DoorStates doorStates;

    public static void main(String[] args) {
        Door door = new Door("abcd");
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

    public Door(String password) {
        this.password = password;
    }

    public DoorStates getDoorStates() {
        return doorStates;
    }

    @Override
    public String toString() {
        return "TheDoor{" +
                "password='" + password + '\'' +
                ", doorStates=" + doorStates +
                '}';
    }
}
