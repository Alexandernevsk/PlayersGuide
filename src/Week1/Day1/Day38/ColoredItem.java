package Week1.Day1.Day38;

public class ColoredItem <T> {
    private final static String RESET ="\033[0m";
    private final static String RED = "\033[031m";
    private final static String GREEN = "\033[32m";
    private final static String BLUE = "\033[34m";
    T printItem;
    private String color;
    public ColoredItem(T printItem, String color) {
        this.printItem = printItem;
        switch (color.toLowerCase()){
            case "red" -> this.color = RED;
            case "green"-> this.color = GREEN;
            case "blue" -> this.color = BLUE;
            default -> System.out.println("Not a valid choice.");
        }
    }

    void display(){
        System.out.println(color + printItem);
        System.out.print(RESET);
    }
}
