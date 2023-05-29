package Week1.Day1.Day34;

public  abstract class RobotCommand {
    public abstract void run(Robot robot);

}
class OnCommand extends RobotCommand{
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            System.out.println("Is already powered.");
        }else robot.setPowered(true);
    }
}

class OffCommand extends RobotCommand {
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setPowered(false);
        }else System.out.println("Is already off.");
    }
}

class NorthCommand extends RobotCommand{
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setY(1);
        }else System.out.println("Robot must be turned on to move");
    }
}

class SouthCommand extends RobotCommand{
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setY(-1);
        }else System.out.println("Robot must be turned on to move");
    }
}

class WestCommand extends RobotCommand{
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setX(-1);
        }else System.out.println("Robot must be turned on to move");
    }
}

class EastCommand extends RobotCommand{
    @Override
    public void run(Robot robot) {
        if(robot.isPowered()){
            robot.setX(1);
        }else System.out.println("Robot must be turned on to move");
    }
}