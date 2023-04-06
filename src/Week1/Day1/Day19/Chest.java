package Week1.Day1.Day19;

import java.util.Objects;


public class Chest {
    private String status;

    public Chest(ChestStates chest) {
        status = chest.inputState;
    }
    public String getStatus() {
        return "The chest is currently: " + status;
    }
    public void setStatus(String choose) {
        if (choose.contains("Open")) {
            if (!status.equals(ChestStates.LOCKED.inputState) && !status.equals(ChestStates.OPEN.inputState)) {
                status = ChestStates.OPEN.inputState;
            } else System.out.println("You can't open the chest because it's: " + status);
        }
        if (choose.contains("Close")) {
            if (!status.equals(ChestStates.CLOSED.inputState) && status.equals(ChestStates.OPEN.inputState)) {
                status = ChestStates.CLOSED.inputState;
                }else System.out.println("You can't close the chest because it's: " + status);
            }
        if(choose.contains("Lock")){
            if(!Objects.equals(status, ChestStates.LOCKED.inputState) && !Objects.equals(status, ChestStates.OPEN.inputState)){
                status = ChestStates.LOCKED.inputState;
            }else System.out.println("You can't lock the chest because it's: " + status);
        }
        if(choose.contains("Unlock")){
            if(status.equals(ChestStates.LOCKED.inputState) && !status.equals(ChestStates.CLOSED.inputState)){
                status = ChestStates.CLOSED.inputState;
            }else System.out.println("You cant unlock the chest because it's: " + status);
        }
    }
}