package Week1.Day1.Day39;

public abstract class Room  {
    public abstract String getRoomDescription();

}
 class EmptyRoom extends Room {
     @Override
     public String getRoomDescription() {
         return null;
     }
 }

 class FountainRoom extends Room {
     private boolean isOn;
     @Override
     public String getRoomDescription() {
         if (isOn) {
             return "You hear the rushing waters from the Fountain of Objects. it has reactivated!\n";
         } else return "You hear water dripping in this room. The Fountain of objects is here!\n";
     }

     public FountainRoom() {
         //Default value;
         this.isOn = false;
     }

     public void setOn(boolean on) {
         isOn = on;
     }

     public boolean isOn() {
         return isOn;
     }

     @Override
     public String toString() {
         return getRoomDescription();
     }

 }

 class PitRoom extends Room{

    private boolean trapped;

     public boolean isTrapped() {
         return trapped;
     }

     public void setTrapped(boolean trapped) {
         this.trapped = trapped;
     }

     @Override
     public String getRoomDescription() {
         return isTrapped() ? "You fell into the pit!" : "You feel a draft. There is a pit in a nearby room";
     }

     @Override
     public String toString() {
         return getRoomDescription();
     }
 }


class EntranceAndExitRoom extends Room {
   FountainRoom room;

    public void setRoom(FountainRoom room) {
        this.room = room;
    }

    @Override
    public String getRoomDescription() {
            return room.isOn() ?
                    "The fountain objects is reactivated, and you have escaped with your life!\n" :
                    "You see the light coming from the cavern entrance\n";
    }

    @Override
    public String toString() {
        return getRoomDescription();
    }
}
