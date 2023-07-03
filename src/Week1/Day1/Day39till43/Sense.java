package Week1.Day1.Day39till43;

public class Sense {
    public void sense(FountainOfObjects game) {
        System.out.printf(AnsiColor.BOLD_MAGENTA + "You are in the room at (Row=%d, Column=%d).\n",
                game.getPlayer().getRow(), game.getPlayer().getColumn());
        if (game.getMap().entranceLocation.equals(game.getPlayer().getCoordinates())) {
            entrance(game);
        } else if (game.getMap().fountainLocation.equals(game.getPlayer().getCoordinates())) {
            fountain(game);
        }


        if (checkAdjacency(game.getMap().pitLocation, game.getPlayer())) {
            System.out.print(AnsiColor.RESET);
            System.out.println(AnsiColor.RED + "You feel a draft. There is a pit in a nearby room.");
        }

        if (checkAdjacency(game.getAmarok().getCoordinates(), game.getPlayer()) && game.getAmarok().isAlive()) {
            System.out.print(AnsiColor.RESET);
            System.out.println(AnsiColor.RED + "You can smell the rotten stench of an amarok in a nearby room.");
        }

        if (checkAdjacency(game.getMaelstrom().getCoordinates(), game.getPlayer())) {
            System.out.println(AnsiColor.RED + "You hear the growling and groaning of a maelstrom nearby.");
        }

        System.out.print(AnsiColor.GREEN + "What do you want to do? " + AnsiColor.RESET);
    }

    public void entrance(FountainOfObjects game) {
        String fountain = game.fountain.isOn() ? "The Fountain of Objects has been reactivated, and you have escaped with your life!\nYou win!"
                : "You see light coming from the cavern entrance.";
        System.out.println(AnsiColor.YELLOW + fountain);
        System.out.print(AnsiColor.RESET);
    }

    public void fountain(FountainOfObjects game) {
        String entrance = game.fountain.isOn() ? "You hear the rushing waters from the Fountain of Objects. It has been reactivated!"
                : "You hear water dripping in this room. The Fountain of Objects is here!";
        System.out.println(AnsiColor.BLUE + entrance);
        System.out.print(AnsiColor.RESET);
    }

    public boolean checkAdjacency(Coordinate threat, Player player) {
        int row = Math.abs(threat.row() - player.getRow());
        int column = Math.abs(threat.column() - player.getColumn());
        return ((row == 1 && column == 0) || (row == 0 && column == 1) || (row == 1 && column == 1));
    }
}
