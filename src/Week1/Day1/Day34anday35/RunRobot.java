package Week1.Day1.Day34anday35;

import java.util.HashMap;
import java.util.Scanner;
public class RunRobot {
    /**
     * Is the interface version better than the abstract class function?
     * I would say in some ways yes.
     * It's easy to guarantee the same behaviour with the interface as with the abstract class in this example code.
     * Although they all are related to the same outcome i.e. commanding the robot, the commands can vary more.
     *As I understand the interface is more useful of you want to model some class behaviour instead of placing
     * a specific class into an abstract class that models different forms of behaviour.
     * Also interfaces, design-wise at least, don't have much use for fields, whereas abstract classes do.
     * The way I see it now, is that interface are mainly used for implementing abstract methods and nothing more,
     * While abstract classes can be used for more than only methods, but also for example implementing fields for child-classes.
     *
     * Another advantage of an interface in this example is that the RobotCommand Interface is one of many
     * interfaces that can be used for the different classes, while child classes in java cannot inherit from different
     * parent classes, so once you a child-class inherits from a parent class, it needs to follow suit.
     * In the interface example it also does, but you don't need to bother with expanding one particular interface,
     * If a different robot command does other things, it can implement that specific interface too.
     */


    private final HashMap<String, RobotCommand> listOfCommands = new HashMap<>();
    private final Robot robot;

    public RunRobot() {
        this.robot = new Robot();
        listOfCommands.put("On", new OnCommand());
        listOfCommands.put("Off", new OffCommand());
        listOfCommands.put("West", new WestCommand());
        listOfCommands.put("East", new EastCommand());
        listOfCommands.put("North", new NorthCommand());
        listOfCommands.put("South", new SouthCommand());
    }

    public RobotCommand setCommands(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose your option: On, Off, North, South, West or East.");
        String input = scanner.nextLine();
        for(var command : listOfCommands.entrySet()){
            if(input.equalsIgnoreCase(command.getKey())){
                return command.getValue();
            }
        }
        System.out.println("not a valid option");
        return setCommands();
    }

    public static void main(String[] args) {
        RunRobot runRobot = new RunRobot();
        Scanner scanner = new Scanner(System.in);
        boolean runTheRobot = true;
        while(runTheRobot) {
            runRobot.robot.setCommands(runRobot.setCommands(), runRobot.setCommands(), runRobot.setCommands());
            runRobot.robot.run();
            System.out.println("continue: type y/n?");
            if(scanner.nextLine().equalsIgnoreCase("n")){
                runTheRobot = false;
            }
        }
    }

}
