package Week1.Day1.Day39;


public class Controller {
    Player player;
    ColorItem<Room> roomColorItem = new ColorItem<>();
    ColorItem<Player> playerColorItem;
    ColorItem<Controller> controllerColorItem;


    public Controller() {
        controllerColorItem = new ColorItem<>(this);

        System.out.println("Default map is 4 by 4, medium 6 by 6, and large 8  by 8.");
        System.out.println("Choose your map size.");
        var size = Grid.MapSize.chooseSize();
            player = new Player(size);
            playerColorItem = new ColorItem<>(player);
    }

    public boolean checkWinCondition() {
        return player.getGrid().getFountainRoom().isOn() && player.getRow() == 0 && player.getColumn() == 0;
    }

    public String compositeDescription(){

        var room =  player.getGrid().getRoom(player.getRow(), player.getColumn());
        roomColorItem = new ColorItem<>(room);
        return String
                .format("%s%s", playerColorItem.colorItem(player),
                        !(room instanceof EmptyRoom || room instanceof PitRoom) ? roomColorItem.colorItem(room) : "");
    }


    @Override
    public String toString() {
       return "What do you want to do? ";
    }

    public void gameLoop() {
        while(!checkWinCondition() && !player.getGrid().getPitRoom().isTrapped()){
            System.out.println(player.adjacencyToPit());
            System.out.print(compositeDescription() + controllerColorItem.colorItem(this));
            if(!(player.getGrid().getRoom(player.getRow(), player.getColumn()) instanceof FountainRoom)){
                System.out.print(ColorItem.ItemColor.ANSI_GREEN + "Move: ");
            }else System.out.print(ColorItem.ItemColor.ANSI_GREEN + "Move or Do: ");
            player.playersAction(Player.Action.loopActions());
            player.playerTrapped();
        }
        if(checkWinCondition()){
            System.out.println(compositeDescription() + ColorItem.ItemColor.ANSI_YELLOW_UNDERLINED +"You win!");
        }
    }

}
