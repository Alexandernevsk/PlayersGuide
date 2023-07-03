package Week1.Day1.Day39till43;

public class FountainOfObjects {
    private final Player player = new Player(true, 0, 0);
    private final Map map = new Map(4, 4);

    /**
     * Fountain Field:
     * I'm content to make only one fountain for now
     * Although it mildly bugs me that fountain needs to be explicitly cast.
     * I can't get the fountain through the interact method.
     * Unfortunately it jars my program logic too much.
     * Only other option is to make a 'instance of' conditional, but I tend to avoid to use of it.
     */


    //For larger maps I need to make an arraylist for the monsters
    private final Amarok amarok = new Amarok(0, 3);
    private final Maelstrom maelstrom = new Maelstrom(1, 3);

    /**
     * ask for player input through the setOption method
     * Based on input executes action if possible
     */
    Fountain fountain = (Fountain) map.maze.get(map.fountainLocation);

    public Player getPlayer() {
        return player;
    }

    public Map getMap() {
        return map;
    }

    public Fountain getFountain() {
        return fountain;
    }

    public Amarok getAmarok() {
        return amarok;
    }

    public Maelstrom getMaelstrom() {
        return maelstrom;
    }


    public void setCommand() {
        player.setOption();
        switch (player.getOption()) {
            case ON -> execute(new On());
            case OFF -> execute(new Off());
            case WEST -> {
                if (map.outOfBounds(new Coordinate(player.getCoordinates().row() - 1, player.getCoordinates().column()))) {
                    System.out.println("Out of bounds");
                } else execute(new West(player));
            }
            case EAST -> {
                if (map.outOfBounds(new Coordinate(player.getCoordinates().row() + 1, player.getCoordinates().column()))) {
                    System.out.println("Out of bounds");
                } else execute(new East(player));
            }
            case NORTH -> {
                if (map.outOfBounds(new Coordinate(player.getCoordinates().row(), player.getCoordinates().column() + 1))) {
                    System.out.println("Out of bounds");
                } else execute(new North(player));
            }
            case SOUTH -> {
                if (map.outOfBounds(new Coordinate(player.getCoordinates().row(), player.getCoordinates().column() - 1))) {
                    System.out.println("Out of bounds");
                } else execute(new South(player));
            }
            case SHOOT -> execute(new Shoot());
        }
    }


    /**
     * @param command executes a command form the Command interface
     */
    public void execute(Command command) {
        command.doAction(this);
    }

    public boolean winCondition() {
        return fountain.isOn() && player.getCoordinates().equals(map.entranceLocation);
    }

    public static void main(String[] args) {
        FountainOfObjects game = new FountainOfObjects();
        Sense sense = new Sense();
        do {
            sense.sense(game);
            game.map.maze.get(game.player.getCoordinates()).interact(game);
            if (game.amarok.getCoordinates().equals(game.player.getCoordinates())) {
                game.amarok.interact(game);
            } else if (game.maelstrom.getCoordinates().equals(game.player.getCoordinates())) {
                game.maelstrom.interact(game);
            }

        } while (game.player.isAlive() && !game.winCondition());

        if (game.winCondition()) {
            sense.entrance(game);
        }
    }
}

