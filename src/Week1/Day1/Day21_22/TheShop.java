package Week1.Day1.Day21_22;

import java.util.Scanner;

public class TheShop {
    private double bill = 0;
    public static void shopDisplay(){
        System.out.println("|---------------------------------------|---------------------|");
        System.out.println("|      Welcome to my fletcher shop      |  ANNO DOMINI: MLXI  |" );
        System.out.println("|---------------------------------------|  v>v<vv>v<vv>v<vv>v<|");
        System.out.println("|<--------------<<      >>------------->|  v>v<vv>v<vv>v<vv>v<|");
        System.out.println("--------------------------------------------------------------|");
        System.out.println("|Here's my Shop:    |  >>---------------------------------->> |" );
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| For custom arrows I have the following conditions:          |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1.Arrow-shaft between 60-100cm in length (0.05 gold per cm).|");
        System.out.println("| 2.Arrow-Head type: Steel, Obsidian or Wood.                 |");
        System.out.println("| 3.Feather type: Plastic,Turkey or Goose.                    |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|For standard arrows I have the following in store:           |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1. The Beginner Arrow: "
                + StandardArrows.BEGINNER.getPriceCost(StandardArrows.BEGINNER.toString()) + "                                 |");
        System.out.println("| 2. The Marksman Arrow: "
                + StandardArrows.MARKSMAN.getPriceCost(StandardArrows.MARKSMAN.toString()) + "                                |");
        System.out.println("| 3. The Elite Arrow: "
                + StandardArrows.ELITE.getPriceCost(StandardArrows.ELITE.toString()) + "                                   |");
        System.out.println("|-------------------------------------------------------------|");

    }
    public void customArrowDisplay(){
        System.out.println("             |---------------------------------|                ");
        System.out.println("             |      Custom Arrow Menu:         |                ");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1.Arrow-shaft between 60-100cm in length (0.05 gold per cm).|");
        System.out.println("| 2.Arrow-Head type: Steel, Obsidian or Wood.                 |");
        System.out.println("| 3.Feather type: Plastic,Turkey or Goose.                    |");
        System.out.println("| 4.Return back to the main menu.                             |");
        System.out.println("| 5.Go to buy.                                                |");
        System.out.println("|-------------------------------------------------------------|");

        String menu = """
             |---------------------------------|               
             |      Custom Arrow Menu:         |               
|-------------------------------------------------------------|
| 1.Arrow-shaft between 60-100cm in length (0.05 gold per cm).|
| 2.Arrow-Head type: Steel, Obsidian or Wood.                 |
| 3.Feather type: Plastic,Turkey or Goose.                    |
| 4.Return back to the main menu.                             |
| 5.Go to buy.                                                |
|-------------------------------------------------------------|
                
                """;
        System.out.println(menu);
    }
    public static void standardArrowDisplay(){
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("|                 Standard Arrow Menu:                        |");
        System.out.println("|-------------------------------------------------------------|");
        System.out.println("| 1. The Beginner Arrow: "
                + StandardArrows.getPriceCost(StandardArrows.BEGINNER) + "                                 |");
        System.out.println("| 2. The Marksman Arrow: "
                + StandardArrows.getPriceCost(StandardArrows.MARKSMAN) + "                                |");
        System.out.println("| 3. The Elite Arrow: "
                + StandardArrows.getPriceCost(StandardArrows.ELITE) + "                                   |");
        System.out.println("| 4.Return back to the main menu.                             |");
        System.out.println("| 5.Go to buy.                                                |");
        System.out.println("|-------------------------------------------------------------|");

    }
    //TODO rewrite the function into a switch to make it more user friendly
    public void priceDisplay(){
        shopDisplay();
        System.out.println("\nDo you want to look at the custom or standard prices?");
       switch (costumerResponse().toLowerCase()){
           case "custom" -> customPriceDisplay();
           case "standard" -> standardPriceDisplay();
           case "exit" -> System.out.println("Goodbye.");
           case "no" -> System.out.println("Adios.");
         }
        }
    public void customPriceDisplay(){
        customArrowDisplay();
        System.out.println("Type in the number next to the item.");
        switch(costumerResponse()){
            case "1" -> priceShaft();
            case "2" -> priceHeads();
            case "3" -> priceFeather();
            case "4" -> priceDisplay();
            case "5" -> buy();
        }
    }
    public void standardPriceDisplay(){
        standardArrowDisplay();
        System.out.println("Choose between main menu or buy.");
        switch(costumerResponse()){
            case "4" -> priceDisplay();
            case "5" -> buy();
        }
    }
    public void priceShaft(){
        new ArrowShaft().costforShaft();
        System.out.println("\nDo you want to look further in the Shop?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            priceDisplay();
        }else buy();
    }
    public void priceHeads(){
        Arrowhead.allValues();
        System.out.println("\nDo you want to look further in the Shop?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            priceDisplay();
        }else buy();
    }
    public  void priceFeather(){
        FeatherType.allValues();
        System.out.println("\nDo you want to look further in the Shop?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            priceDisplay();
        }else buy();
    }
    public static String costumerResponse(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }
    //TODO replace this code into the private arrow class
    public double setCostCustomArrow(){
        System.out.println("Do you want to see the menu?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            shopDisplay();
        }
        new TheShop().setBill(bill += new ArrowShaft().buy());
        System.out.println("What kind of arrowhead do you want?");
        new TheShop().setBill(bill += Arrowhead.loop(costumerResponse()));
        System.out.println("What kind of feather-type do you want?");
        new TheShop().setBill(bill += FeatherType.loop(costumerResponse()));
        System.out.println("This is what it cost: " + getBill());
        System.out.println("\nDo you wanna buy something else?");
        while(costumerResponse().equalsIgnoreCase("yes")) {
            System.out.println("Would you like to buy more arrows?");
            if(costumerResponse().equalsIgnoreCase("yes")) {
                buy();
            }
        }
        return new TheShop().getBill();
    }
    public void setCostStandardArrow() {
        System.out.println("Do you want to see the menu?");
        if (costumerResponse().equalsIgnoreCase("yes")) {
            shopDisplay();
        }
        System.out.println("Type in the number next to the arrows to add one.");
        switch(costumerResponse()){
            case "1" -> new TheShop().setBill(bill += StandardArrows.getPriceCost(StandardArrows.BEGINNER));
            case "2" -> new TheShop().setBill(bill +=StandardArrows.MARKSMAN.getPriceCost(StandardArrows.MARKSMAN.toString()));
            case "3" -> new TheShop().setBill(bill +=StandardArrows.ELITE.getPriceCost(StandardArrows.ELITE.toString()));
        }
        System.out.println("Do you want to buy more things?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            buy();
        }else {
            System.out.println("This is your bill " + getBill());
        }
    }
    public void buy(){
        System.out.println("Do you want to buy custom arrows?");
        if (costumerResponse().equalsIgnoreCase("yes")){
            setCostCustomArrow();
        }
        System.out.println("Do you want to buy standard arrows?");
        if(costumerResponse().equalsIgnoreCase("yes")){
            setCostStandardArrow();
        }
    }
    public double getBill() {
        return bill;
    }
    private void setBill(double bill) {
        this.bill = bill;
    }
}
