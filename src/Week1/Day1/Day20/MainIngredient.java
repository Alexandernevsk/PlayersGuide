package Week1.Day1.Day20;

import javax.lang.model.element.Element;
import java.util.stream.Stream;

public enum MainIngredient {
    CHICKEN("Chicken"),
    MUSHROOMS("Mushroom"),
    CARROTS("Carrot"),
    POTATOES("Potato");
    private String output;

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
