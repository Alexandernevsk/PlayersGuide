package Week1.Day1.Day20;

public enum MainIngredient {
    CHICKEN,
    MUSHROOMS,
    CARROTS,
    POTATOES;

    @Override
    public String toString() {
        return this.name().charAt(0) + name().substring(1).toLowerCase();
    }

    public static MainIngredient loop (String choose){
      for(MainIngredient e: MainIngredient.values()){
          if(choose.equalsIgnoreCase(e.toString())){
              return e;
          }
      }
      return null;
  }
}
