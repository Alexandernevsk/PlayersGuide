package Week1.Day1.Day26;

import java.util.Scanner;
public class Door {
    private String _password;
    private DoorStates _doorState;
    public int tries = 3;

    public static void main(String[] args) {
        Door door = new Door();
        switchingDoors(door);
    }
//Added an init block to initially lock the door -- like you would encounter in a hotel room.

    {_doorState = DoorStates.LOCKED;}

    public Door() {
        System.out.println("Please type in a password with more than 3 digits.");
        System.out.println("There shouldn't be any white spaces! These will be removed automatically.");
        this._password = userPassword();
    }
    public String get_password() {
        return _password;
    }

    public DoorStates get_doorState() {
        return _doorState;
    }

    //Create some limits for password creation to avoid nonsense passwords as blank spaces or minimal length.
    public void change_password(){
        System.out.println("Type in your current password to change password. It's case-sensitive!");
        while(tries > 0) {
            String currentPassword = userPassword();
            if (currentPassword.equals(_password)) {
                System.out.println("Type in your new password.");
                System.out.println(_password);
                this._password = userPassword();
                break;
            } else {
                System.out.println("Doesn't match your current password.");
                tries--;
                System.out.println(tries);
            }
            if(tries == 0){
                System.out.println("You type the password wrong 3 times. The program will now terminate");
                System.exit(0);
            }
        }
    }
    public void set_doorState(DoorStates _doorState) {
        this._doorState = _doorState;
    }

    @Override
    public String toString() {
        return "The door is " +  _doorState + '.';
    }
    public static String userPassword(){
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(removeWhiteSpaces(input).length() < 4){
            System.out.println("Password must be longer than 3 digits.");
            input = scanner.nextLine();
        }
        return removeWhiteSpaces(input);
    }

    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public static String removeWhiteSpaces(String stringSpaces){
        return stringSpaces.replaceAll("\\p{Z}","");
    }
    public static void switchingDoors(Door door){
        while(true){
            UserOptions.changingDoor(door);
            System.out.println("Do you want to change your password? yes or no?");
            if(userInput().equalsIgnoreCase("yes")){
                door.change_password();
            }
            System.out.println("Do you wanna exit? yes or no?");
            if(userInput().equalsIgnoreCase("yes")){
                System.exit(0);
            }
        }
    }

}
