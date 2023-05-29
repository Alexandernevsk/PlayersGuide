package Week1.Day1.Day34;

public class SouthCommand implements RobotCommand{
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setY(-1);
        } else System.out.println("Robot cannot move because it's off");
    }
}
