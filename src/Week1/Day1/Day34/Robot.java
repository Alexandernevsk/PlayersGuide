package Week1.Day1.Day34;



public class Robot {
        private int x;
        private int y;
        private boolean isPowered;

        // The Final keyword could also not be the case, but seeing it was already pre-programmed this way. Final seems better.
        //Not only because my IDE is nagging me, but also because the variable isn't changed in the constructor.
        private final RobotCommand[] commands = new RobotCommand[3];

    public Robot() {
        x = 0;
        y = 0;
        isPowered = false;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public void setX(int x) {
        this.x += x;
    }

    public boolean isPowered() {
        return isPowered;
    }

    public void setY(int y) {
        this.y += y;
    }

    public  void setCommands(RobotCommand robotCommand, RobotCommand robotCommand1, RobotCommand robotCommand2) {
            commands[0] = robotCommand;
            commands[1] = robotCommand1;
            commands[2] = robotCommand2;
    }



    public void run() {
            for (RobotCommand command : commands) {
                command.run(this);
                System.out.printf("[%d %d %b]\n", x, y, isPowered);
            }
    }

}
