package Week1.Day1.Day19;

public enum ChestStates{
    OPEN ("Open"),
    CLOSED("Closed"),
    LOCKED("Locked");
    final String inputState;


    ChestStates(String inputState){
        this.inputState = inputState;
    }
}
