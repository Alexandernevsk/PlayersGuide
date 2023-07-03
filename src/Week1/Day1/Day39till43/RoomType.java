package Week1.Day1.Day39till43;

public abstract class RoomType {

    /**
     * Default interact method:
     * Executes the player-input: Shoot, Move, and Enable fountain interfaces.
     */
    void interact(FountainOfObjects game) {
        game.setCommand();
    }

}

class Fountain extends RoomType {
    //Additional functionality: can be turned off or on depending on player-input;
    private boolean on = false;


    public boolean isOn() {
        return on;
    }

    public void setOn(boolean on) {
        this.on = on;
    }

}

class Pit extends RoomType {

    /**
     * The player can't execute an action when in the pit, because the pit causes the player to immediately die.
     * That is why the pit-class overrides the standard interact method.
     */

    @Override
    void interact(FountainOfObjects game) {
        System.out.println(AnsiColor.warningDeath() + "You fell into the pit. You lose!");
        game.getPlayer().setAlive(false);
    }
}

/**
 * Both room-types below are empty, as you perhaps astutely observe.
 * The reason is that these rooms don't add their own functionalities aside of the parent-class.
 */
class Entrance extends RoomType {

}

class Empty extends RoomType {

}
