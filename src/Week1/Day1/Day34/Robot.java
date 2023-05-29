package Week1.Day1.Day34;

public class Robot {
    private int x;
    private int y;
    private boolean isPowered;

    public boolean isPowered() {
        return isPowered;
    }

    public void setX(int x) {
        this.x += x;
    }

    public void setY(int y) {
        this.y += y;
    }

    public void setPowered(boolean powered) {
        isPowered = powered;
    }

    public void setCommands(RobotCommand robotCommand, RobotCommand robotCommand1, RobotCommand robotCommand2) {
        commands[0] = robotCommand;
        commands[1] = robotCommand1;
        commands[2] = robotCommand2;
    }

    private RobotCommand[] commands = new RobotCommand[3];
    public void run() {
        for (RobotCommand command : commands) {
            command.run(this);
            System.out.printf("[%d %d %b]\n", x, y, isPowered);
        }
    }
}
