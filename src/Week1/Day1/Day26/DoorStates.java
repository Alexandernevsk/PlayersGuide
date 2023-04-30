package Week1.Day1.Day26;

public enum DoorStates{
    OPEN, CLOSED, LOCKED;

    @Override
    public String toString() {
        return name().toLowerCase();
    }



}