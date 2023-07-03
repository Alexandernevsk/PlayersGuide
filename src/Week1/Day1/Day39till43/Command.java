package Week1.Day1.Day39till43;

import java.util.Scanner;


/**
 * Command is the parent-interface .
 * All (child) interfaces below are grouped together.
 * Classes that implement the interfaces are below.
 * All are accessed through the FountainOfObjects-class.
 * Main reason is that that class connects the different classes together,
 * and therefore has access to all the classes in order to manage the logic and behaviour of them.
 */
public interface Command {
    void doAction(FountainOfObjects game);
}

interface EnableFountain extends Command {
    @Override
    void doAction(FountainOfObjects game);
}

interface Move extends Command {
    @Override
    void doAction(FountainOfObjects game);
}

interface Attack extends Command {
    @Override
    void doAction(FountainOfObjects game);
}

class Shoot implements Attack {

    //Enum for the different directions where to player can shoot his bow;
    enum ShootDirection {
        NORTH(1), EAST(1), WEST(-1), SOUTH(-1);
        private final int shotDirection;

        public int getShotDirection() {
            return shotDirection;
        }

        public static ShootDirection playerInput() {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            for (ShootDirection direction : ShootDirection.values()) {
                if (input.equalsIgnoreCase(direction.toString())) {
                    return direction;
                }
            }
            System.out.println("Not a valid direction to shoot");
            return playerInput();
        }

        ShootDirection(int direction) {
            this.shotDirection = direction;
        }

    }

    public Coordinate shootDirection(ShootDirection direction, Player player) {
        switch (direction) {
            case WEST, EAST -> {
                player.removeArrow();
                return new Coordinate(player.getCoordinates().row() + direction.getShotDirection(), player.getColumn());
            }
            case SOUTH, NORTH -> {
                player.removeArrow();
                return new Coordinate(player.getCoordinates().row(), player.getColumn() + direction.getShotDirection());
            }
        }
        System.out.println("not valid try again!");
        return shootDirection(direction, player);
    }

    @Override
    public void doAction(FountainOfObjects game) {
        game.getPlayer().displayArrowCount();
        if (game.getPlayer().hasArrows()) {
            System.out.println("What way do you want to shoot?");
            game.getAmarok().hit(shootDirection(ShootDirection.playerInput(), game.getPlayer()));
        } else System.out.println("No more arrows");
    }
}

class On implements EnableFountain {
    @Override
    public void doAction(FountainOfObjects game) {
        if (game.getPlayer().getCoordinates().equals(game.getMap().fountainLocation)) {
            game.fountain.setOn(true);
        } else System.out.println("Not at fountain");
    }
}

class Off implements EnableFountain {
    @Override
    public void doAction(FountainOfObjects game) {
        if (game.getPlayer().getCoordinates().equals(game.getMap().fountainLocation)) {
            game.fountain.setOn(false);
        } else System.out.println("Not at fountain");
    }
}

class North implements Move {
    Entities entities;

    public North(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void doAction(FountainOfObjects game) {
        entities.setColumn(entities.getColumn() + 1);
    }
}

class East implements Move {
    Entities entities;

    public East(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void doAction(FountainOfObjects game) {
        entities.setRow(entities.getRow() + 1);
    }
}

class West implements Move {
    Entities entities;

    public West(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void doAction(FountainOfObjects game) {
        entities.setRow(entities.getRow() - 1);
    }
}

class South implements Move {
    Entities entities;

    public South(Entities entities) {
        this.entities = entities;
    }

    @Override
    public void doAction(FountainOfObjects game) {
        entities.setColumn(entities.getColumn() - 1);
    }
}