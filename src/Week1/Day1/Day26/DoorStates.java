package Week1.Day1.Day26;

public enum DoorStates{
    OPEN, CLOSED, LOCKED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }

    public static boolean checkPassword(Door door, String input){
        return door.getPassword().equals(input);
    }


}