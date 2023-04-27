package Week1.Day1.Day26;

public enum UserOptions {

    OPEN(DoorStates.OPEN), CLOSE(DoorStates.CLOSED), LOCK(DoorStates.LOCKED), UNLOCK(DoorStates.CLOSED);
    private final DoorStates associatesStates;
    UserOptions(DoorStates associatesStates) {
        this.associatesStates = associatesStates;
    }
    public DoorStates getAssociatesStates() {
        return associatesStates;
    }
    @Override
    public String toString() {
        return name().toLowerCase();
    }
    public static void changingDoor(Door door) {
        if (door.get_doorState().equals(DoorStates.OPEN)) {
            System.out.println(door);
            System.out.println("Type close to close the door.");
            if (Door.userInput().equalsIgnoreCase(CLOSE.toString())) {
                door.set_doorState(CLOSE.getAssociatesStates());
            } else System.out.println("You can only close the door.");
        } else if (door.get_doorState().equals(DoorStates.CLOSED)) {
            System.out.println(door);
            System.out.println("Type either open or lock.");
            String input = Door.userInput();
            if(input.equalsIgnoreCase(LOCK.toString())){
                door.set_doorState(LOCK.getAssociatesStates());
            }else if(input.equalsIgnoreCase(OPEN.toString())){
                door.set_doorState(OPEN.getAssociatesStates());
            }else System.out.println("You can only lock or open the door.");
        } else if (door.get_doorState().equals(DoorStates.LOCKED)) {
            System.out.println(door);
            System.out.println("Type in unlock to unlock your door.(Remember the program will ask for your password)");
            if (Door.userInput().equalsIgnoreCase(UNLOCK.toString())) {
                System.out.println("Please type in your password.");
                if (!DoorStates.checkPassword(door, Door.userInput())) {
                    System.out.println("That's the wrong password. Try again.");
                    changingDoor(door);
                } else door.set_doorState(UNLOCK.getAssociatesStates());
            }
        }
    }
}