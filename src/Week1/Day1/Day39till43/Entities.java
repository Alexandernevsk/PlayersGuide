package Week1.Day1.Day39till43;

import java.util.Scanner;

public abstract class Entities {
    private boolean alive;
    private int row, column;

    public Entities(boolean alive, int row, int column) {
        this.alive = alive;
        this.row = row;
        this.column = column;
    }

    //Returns a Coordinate for the Hashmap in the Map class;
    public Coordinate getCoordinates() {
        return new Coordinate(row, column);
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setColumn(int column) {
        this.column = column;
    }

    public boolean isAlive() {
        return alive;
    }

    public void setAlive(boolean alive) {
        this.alive = alive;
    }

}

class Player extends Entities {

    enum Options {
        NORTH, SOUTH, EAST, WEST, ON, OFF, SHOOT;

        public static Options options() {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            for (Options option : Options.values()) {
                if (input.equalsIgnoreCase(option.toString())) {
                    return option;
                }
            }
            System.out.println("Not a valid command");
            return options();
        }
    }

    public Options getOption() {
        return option;
    }

    private Options option;
    private int arrows = 5;

    public Player(boolean alive, int row, int column) {
        super(alive, row, column);
    }

    public void setOption() {
        option = Options.options();
    }

    public void displayArrowCount() {
        System.out.printf("Arrows lefts: %d\n", arrows);
    }

    public boolean hasArrows() {
        return arrows > 0;
    }

    public void removeArrow() {
        arrows--;
    }

}

abstract class Monster extends Entities {
    abstract void interact(FountainOfObjects game);

    public Monster(boolean alive, int row, int column) {
        super(alive, row, column);
    }

}

class Maelstrom extends Monster {

    public Maelstrom(int row, int column) {
        super(false, row, column);
    }

    /* Probably needs a rework for larger maps.
     * Reason being is that larger maps have more amaroks, pits, and maelstroms.
     * This method only works for a small map where there is only one of each monster.
     * So the left-side of the operator needs additional logic.
     * Now only works for non-empty rooms and the lonely Amarok.
     */
    public boolean possibleLocation(FountainOfObjects game) {
        return (!(game.getMap().maze.get(this.getCoordinates()) instanceof Empty) || (this.getCoordinates().equals(game.getAmarok().getCoordinates())));
    }


    //Will move the player to another location, it checks the new location for any eventualities
    public void movePlayer(FountainOfObjects game) {
        Command[] movePlayer = {new North(game.getPlayer()), new East(game.getPlayer()), new East(game.getPlayer())};
        for (Command command : movePlayer) {
            command.doAction(game);
            if (game.getPlayer().getColumn() >= game.getMap().getHeight()) {
                game.getPlayer().setColumn(0);
            }
            if (game.getPlayer().getRow() >= game.getMap().getWidth()) {
                game.getPlayer().setRow(0);
            }
        }
    }

    /* Maelstrom will first finish its move cycle,
     * If after the move cycle the maelstrom doesn't satisfy its conditions,
     * It will break its cycle prematurely when it finds a possible location.
     * That's why I need two 'loops', although I call the second more of a semi-loop
     */

    public void beyondBorders() {
        System.out.println("You move beyond the borders of the map");
    }

    @Override
    void interact(FountainOfObjects game) {
        System.out.println(AnsiColor.warningDeath() + "The maelstrom sucks you in, and moves you through the cave!");
        System.out.println(AnsiColor.RESET);

        Command[] moveMaelstrom = {new South(this), new West(this), new West(this)};
        movePlayer(game);

        for (Command command : moveMaelstrom) {
            command.doAction(game);
            if (this.getRow() < 0) {
                this.setRow(game.getMap().getHeight() - 1);
                beyondBorders();
            }
            if (this.getColumn() < 0) {
                this.setColumn(game.getMap().getWidth() - 1);
                beyondBorders();
            }
        }

        int counter = 0;
        while (possibleLocation(game)) {
            moveMaelstrom[counter].doAction(game);
            if (this.getRow() < 0) {
                this.setRow(game.getMap().getHeight() - 1);
            }
            if (this.getColumn() < 0) {
                this.setColumn(game.getMap().getWidth() - 1);
            }
            counter++;
            counter = counter < moveMaelstrom.length ? counter : 0;
        }
    }
}

class Amarok extends Monster {

    public void hit(Coordinate coordinate) {
        if (coordinate.equals(this.getCoordinates())) {
            setAlive(false);
        }
    }

    public Amarok(int row, int column) {
        super(true, row, column);
    }

    @Override
    void interact(FountainOfObjects game) {
        if (this.isAlive()) {
            System.out.println(AnsiColor.warningDeath() + "The Amarok attacks and you died. You lose!");
            game.getPlayer().setAlive(false);
        }
    }
}


