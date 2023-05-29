package Week1.Day1.Day34;

import java.util.HashMap;
import java.util.Scanner;
public class RunRobot {
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
