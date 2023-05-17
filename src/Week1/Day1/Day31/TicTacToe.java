package Week1.Day1.Day31;

import java.util.ArrayList;

public class TicTacToe {
    ArrayList<ArrayList<Cross_Dots>> grid;
    public static final int MAX_ROW = 3;


    public TicTacToe(ArrayList<ArrayList<Cross_Dots>> grid) {
      for(int i = 0; i < MAX_ROW; i++){
          grid.add(new ArrayList<>());
          for(int j = 0; j < MAX_ROW; j++){
              grid.get(i).add(Cross_Dots.NONE);
          }
      }
    }

}
