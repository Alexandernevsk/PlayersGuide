package Week1.Day1.Day20;

public enum MainIngredient {
    CHICKEN("Chicken"),
    MUSHROOMS("Mushroom"),
    CARROTS("Carrot"),
    POTATOES("Potato");
    private final String output;

    MainIngredient(String output) {
        this.output = output;
    }

    public String getOutput() {
        return output;
    }

  public static MainIngredient loop (String choose){
      for(MainIngredient e: MainIngredient.values()){
          if(choose.equalsIgnoreCase(e.getOutput())){
              return e;
          }
      }
      return null;
  }
}
