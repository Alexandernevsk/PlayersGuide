package Week1.Day1.Day20;


import java.util.Scanner;


public class SelfService {
    public String Seasoning(String choose){
     return SeasoningSoup.loop(choose).toString();
   }
   public String ingredient(String choose){
     return  MainIngredient.loop(choose).toString();

   }

   public TypeSoup meal(String choose) {
      return TypeSoup.loop(choose);

   }


   public void finishedMeal(){
       Scanner scanner = new Scanner(System.in);
       System.out.println("What kind of seasoning do you want? Sweet, Salty or Spicy?");
     String seasoning = Seasoning(scanner.nextLine());
       System.out.println("What kind of ingredient do you want? Carrots, Chicken, Mushrooms or Potatoes?");
     String ingredient = " " + ingredient(scanner.nextLine());
       System.out.println("What kind of meal do you want? Soup, Stew or Gumbo?");
     String meal = " " + meal(scanner.nextLine()) + ".";
       String theSoup = seasoning + ingredient + meal;
       System.out.println("You chose: " + theSoup);
   }
}