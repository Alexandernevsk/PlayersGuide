package Week1.Day1.Day39;

public interface PlayerCommand {
    void doAction(Player player);
}

class NorthCommand implements PlayerCommand{
    @Override
    public void doAction(Player player) {
        player.setColumn(+1);
    }
}

class SouthCommand implements PlayerCommand {
    @Override
    public void doAction(Player player) {
        player.setColumn(-1);
    }
}

class WestCommand implements PlayerCommand {
    @Override
    public void doAction(Player player) {
        player.setRow(-1);
    }
}

class EastCommand implements PlayerCommand {
    @Override
    public void doAction(Player player) {
        player.setRow(+1);
    }
}

class OnCommand implements PlayerCommand {
    @Override
    public void doAction(Player player) {
        if(player.getGrid().getRoom(player.getRow(), player.getColumn()) instanceof FountainRoom){
            ((FountainRoom) player.getGrid().getRoom(player.getRow(), player.getColumn())).setOn(true);
        } else System.out.println("not a fountain room!");
    }
}

class OffCommand implements PlayerCommand {
    @Override
    public void doAction(Player player) {
        if(player.getGrid().getRoom(player.getRow(), player.getColumn()) instanceof FountainRoom){
            ((FountainRoom) player.getGrid().getRoom(player.getRow(), player.getColumn())).setOn(false);
        } else System.out.println("not a fountain room!");
    }
}