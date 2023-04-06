package Week1.Day1.Day26;

public enum DoorStates {
    OPEN, CLOSED, LOCKED;

    public static String changeDoorstate(String doorState) {
        for (DoorStates e : DoorStates.values()) {
            if (doorState.equalsIgnoreCase(e.toString())) {
                return e.toString();
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static void checkDoorStates(TheDoor door){
        //door.setDoorStates(TheDoor.userInput());
        //if(door.getDoorStates() == null){
            System.out.println("That is not a valid input.");
            changeDoorstate(TheDoor.userInput());
        }


    }
