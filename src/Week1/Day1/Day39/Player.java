package Week1.Day1.Day39;

import java.util.Scanner;

public class Player {
    private final Grid grid;
    private int row;
    private int column;


    public Player(Grid.MapSize mapSize) {
        this.grid = new Grid(mapSize);
        for(int j = 0; j < grid.getMap().length; j++){
            for(int i = 0; i < getGrid().getMap().length; i++){
                if(getGrid().getRoom(i,j) instanceof EntranceAndExitRoom){
                    row = i; column = j;
                }
            }
        }
    }


    public Grid getGrid() {
        return grid;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        if(getRow() + row < 0  || getRow() + row > grid.getSizeNumber()-1) {
            System.out.println("Not a valid direction");
        }else this.row = getRow() + row;
    }

    public void setColumn(int column) {
        if(this.column + column < 0 || this.column + column > grid.getSizeNumber()-1){
            System.out.println("Not a valid direction");
        } else this.column = getColumn() + column;
    }

    enum Action {
        NORTH, SOUTH, WEST, EAST, ON, OFF;

        public static Action loopActions(){
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            for(var option: Action.values()){
                if(input.equalsIgnoreCase(option.toString())){
                    return option;
                }
            }
            System.out.println("Not a valid option!");
            return loopActions();
        }

    }

    public void playerTrapped(){
        if(grid.getMap()[getRow()][getColumn()] instanceof PitRoom){
            grid.getPitRoom().setTrapped(true);
            System.out.println(ColorItem.ItemColor.ANSI_RED_BOLD + grid.getPitRoom().getRoomDescription() + " You lose!");
        }
    }

    public String adjacencyToPit () {
        String description = ColorItem.ItemColor.ANSI_YELLOW_UNDERLINED + getGrid().getPitRoom().getRoomDescription() + ColorItem.ItemColor.ANSI_RESET;
        if (getGrid().getPitRoom().isTrapped()) {
            return "";
        } else {
            for (int x_axis = 0; x_axis < getGrid().getMap().length; x_axis++) {
                for (int y_axis = 0; y_axis < getGrid().getMap().length; y_axis++) {
                    if (getGrid().getMap()[x_axis][y_axis] instanceof PitRoom) {

                        int dx = Math.abs(getRow() - x_axis);
                        int dy = Math.abs(getColumn() - y_axis);

                        if ((dx == 1 && dy == 1) || (dx == 1 && dy == 0) || (dx == 0 && dy == 1)) {
                            return description;
                        }
                    }
                }
            }
        }
        return "";
    }

    public void playersAction(Action action){
        switch (action){
            case NORTH ->  new NorthCommand().doAction(this);
            case SOUTH -> new SouthCommand().doAction(this);
            case WEST ->  new WestCommand().doAction(this);
            case EAST -> new EastCommand().doAction(this);
            case ON -> new OnCommand().doAction(this);
            case OFF -> new OffCommand().doAction(this);
            default -> System.out.println("Not a valid option");
        }
    }


    @Override
    public String toString() {
        return "You are in the room at: Room (Row=" + row + ", " + "Column=" + column + ").\n";
    }
}
