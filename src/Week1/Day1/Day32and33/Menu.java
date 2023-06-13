package Week1.Day1.Day32and33;
import java.util.Objects;
import java.util.Scanner;


public class Menu {
    private Pack pack;
    private Scanner scanner = new Scanner(System.in);


    public Menu() {
        this.pack = new Pack();
    }

    public void menuOptions(MenuOptions options){
        options.addItem(pack);
    }

    public boolean checkForItem(String input){
            if(pack.getPack().toString().contains(input)){
                return true;
            } else {
                System.out.println("\n\nItem isn't in your list\n\n");
                return false;
            }
    }


    public void removeItem(){
        if(pack.getPack().isEmpty()){
            System.out.println("You cannot remove anything, because its empty!");
        }else {
            System.out.println("\n\nThis is your pack inventory, which item do you want to remove?");
            System.out.println( pack.showPackContents());
            String option = scanner.nextLine();
            if(checkForItem(option)) {
                pack.getPack().removeIf(i -> option.equalsIgnoreCase(i.toString()));
            }else startMenu();
        }
    }
    public static String displayOptions(){
        var stringBuilder = new StringBuilder();
            for(var option : MenuOptions.values()) {
                stringBuilder.append(("%d. %s\n").formatted(option.ordinal() + 1,option.toString()));
            }
        return stringBuilder.toString();
    }

    enum MainMenuOptions {
        ADD, REMOVE, EXIT;

        public static MainMenuOptions chooseOption(String input){
            for(var option : MainMenuOptions.values()){
                if(input.equalsIgnoreCase(option.toString())){
                    return option;
                }
            }
            return null;
        }
    }

    public void startMenu(){
        while(true) {
            try{
                System.out.println("This is your inventory: ");
                System.out.println(pack);
                System.out.println("Choose you're option: Add, Remove, Exit.");
            switch (Objects.requireNonNull(MainMenuOptions.chooseOption(scanner.nextLine()))) {
                case ADD -> chooseItem();
                case REMOVE -> removeItem();
                case EXIT -> System.exit(0);
                }
            }catch (NullPointerException nullPointerException){
                System.out.println("Not a valid option. Please try again.");
            }
        }
    }


    public void chooseItem(){
        System.out.println(pack);
        System.out.println("Here are the options: ");
        System.out.println(displayOptions());
        System.out.println("What do you want to choose?");
        String opted = scanner.nextLine();
        if(MenuOptions.checkMenu(opted) != null){
            menuOptions(Objects.requireNonNull(MenuOptions.checkMenu(opted)));
        }else System.out.println("not a valid option!");
    }
}
