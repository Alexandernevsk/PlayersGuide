package Week1.Day1.Day20;


import java.util.Scanner;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class SelfService {
   private String theSoup;
   public String Seasoning(String choose){
     return SeasoningSoup.loop(choose).getOutput();
   }
   public String ingredient(String choose){
     return  MainIngredient.loop(choose).getOutput();

   }

   public String meal(String choose) {
      return TypeSoup.loop(choose).getOutput();

   }
   public void finishedMeal(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("What kind of seasoning do you want? Sweet, Salty or Spicy?");
     String seasoning = Seasoning(scanner.nextLine());
       System.out.println("What kind of ingredient do you want? Carrots, Chicken, Mushrooms or Potatoes?");
     String ingredient = " " + ingredient(scanner.nextLine());
       System.out.println("What kind of meal do you want? Soup, Stew or Gumbo?");
     String meal = " " + meal(scanner.nextLine()) + ".";
       theSoup = seasoning + ingredient + meal;
       System.out.println("You chose: " + theSoup);
   }

   public String getTheSoup() {
      return theSoup;
   }
}