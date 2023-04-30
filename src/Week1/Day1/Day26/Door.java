package Week1.Day1.Day26;


import java.util.Scanner;

/** General outline:
 * I have two enums one with options to choose, and that one is for the user to choose from.
 * Included some more options than only the options for changing the states of a door.
 * Besides the enums I created a DoorInterface to have general outline for the several methods.
 * Interface is not very complicated just a useful tool to keep track of the outline.
 */

public class Door implements DoorInterface  {
    //Accepts OPEN, CLOSED, LOCKED as inputs, and door always starts LOCKED
    private DoorStates state = DoorStates.LOCKED;
    private static boolean runWhileLoop = true;
    private String password;

    public static void main(String[] args) {
        Door door = new Door();
        door.doorOptions(door);

    }

    public Door(){
        while(true){
            System.out.println("Please fill in your password");
            System.out.println("Password must be longer than 6 characters and smaller than 15");
            String password = userInput().replaceAll(" ", "");
            if(password.length() > 6 && password.length() < 15){
                this.password = password;
                break;
            }else System.out.println("Invalid password");
        }
    }
    //Main method. Switch seemed the best solution for the different option. Tried invocation, but that was a bit too hard to achieve

    public void doorOptions(Door door){
        while(runWhileLoop) {
            System.out.println();
            System.out.println(door + " What do you want to do?");
            System.out.println("All the available options are: exit, open, close, lock, unlock or change (to change your password)");
            System.out.println("You can only open or lock the door when it is closed; close it when it is opened, and unlock it when it is locked.");
            String opts = userInput();
            try {
                switch (Options.valueOf(opts.toUpperCase())) {
                    case LOCK -> lock(door);
                    case CLOSE -> close(door);
                    case OPEN -> open(door);
                    case EXIT -> exit();
                    case CHANGE -> setPassword();
                    case UNLOCK -> unlock(door);
                    default -> System.out.println("That's not a option");
                }
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    @Override
    public void exit() {
        runWhileLoop = false;
    }
    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    public void setState(DoorStates state) {
        this.state = state;
    }

    public void setPassword() {
        while(true) {
            System.out.println("Please fill in current password");
            if (userInput().equals(password)) {
                System.out.println("Password must be longer than 6 characters and smaller than 15");
                String password = userInput().replaceAll(" ", "");
                if (password.length() > 6 && password.length() < 15) {
                    this.password = password;
                    break;
                } else System.out.println("Invalid password");
            } else throw new IllegalArgumentException("password is incorrect");
        }
    }

    public String getPassword() {
        return password;
    }


    @Override
    public void close(Door door) {
        if(door.state.equals(DoorStates.OPEN)){
            setState(DoorStates.CLOSED);
        }else throw new IllegalArgumentException("Door is not open");
    }

    @Override
    public void open(Door door) {
        if(door.state.equals(DoorStates.CLOSED)){
            setState(DoorStates.OPEN);
        }else throw new IllegalArgumentException(" Door is not closed");

    }

    @Override
    public void lock(Door door) {
        if(door.state.equals(DoorStates.CLOSED)){
            setState(DoorStates.LOCKED);
        }else throw new IllegalArgumentException("Door is not closed");

    }

    @Override
    public void unlock(Door door) {
        if(door.state.equals(DoorStates.LOCKED)){
            System.out.println("Type in your password");
            if(userInput().equals(getPassword())){
                setState(DoorStates.CLOSED);
            }else throw new IllegalArgumentException("password is incorrect");
        }else throw new IllegalArgumentException("Door is not locked");
    }

    @Override
    public String toString() {
        return "Door is currently: " + state  +'.';
    }
}
