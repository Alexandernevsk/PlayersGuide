package Week1.Day1.Day31;

import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;



public class TicTacToe {
  private  Map<GridCoordinate, DotCross> board = new HashMap<>();
  //finding the square number not the whole size of the board;

  public TicTacToe (){
      for(int x = 0; x < 3; x++){
          for(int y = 0; y < 3; y++){
              board.put(new GridCoordinate(x,y), DotCross.NONE);
            }
          }
      }

    @Override
    public String toString() {
        var grid = new StringBuilder();
        for(int y = 0; y < 3; y++){
            for(int x = 0; x < 3; x++){
                if(x == 2){
                    grid.append(("%" + 2 + "s ").formatted(board.get(new GridCoordinate(x,y))));
                } else grid.append(("%" + 2 + "s |").formatted(board.get(new GridCoordinate(x,y))));
            }
            if(y < 2) {
                grid.append("\n-----------\n");
            }
        }
        return grid.toString();
    }
    //Lots of options to play tictactoe via the computer, and not very clean to get the results through the command line.
    //One would be with combination of enums (up, down, right, left, middle)
    //Another would ask for the coordinates;
    //Nicest way would be a GUI, unfortunately a bit of an overreach for me now.

    public  boolean isSquareEmpty(GridCoordinate gridCoordinate){
       return board.get(gridCoordinate) == DotCross.NONE;
    }

    public boolean checkWinCondition() {
        var combinations = winningCombinations();
        for (ArrayList<GridCoordinate> combination : combinations) {
            DotCross firstSymbol = board.get(combination.get(0));
            boolean win = combination.stream()
                    .map(board::get)
                    .allMatch(symbol -> symbol != DotCross.NONE && symbol == firstSymbol);

            if (win) {
                if(firstSymbol == DotCross.CROSS){
                    System.out.println("You win");
                    return true;
                }else System.out.println("you lose");
            }
        }
        return false;
    }

    public ArrayList<ArrayList<GridCoordinate>> winningCombinations(){
        ArrayList<ArrayList<GridCoordinate>> winningCombinations = new ArrayList<>();
        for (int i = 0; i < 8; i++) {
            winningCombinations.add(new ArrayList<>());
        }
        for (int x = 0; x < 3; x++) {
            for (int y = 0; y < 3; y++) {
                if (y == 0) {
                    winningCombinations.get(y).add(new GridCoordinate(x, y));
                    winningCombinations.get(y + 3).add(new GridCoordinate(y, x));
                    winningCombinations.get(6).add(new GridCoordinate(x,x));
                    winningCombinations.get(7).add(new GridCoordinate(x,2-x));
                } else if (y == 1) {
                    winningCombinations.get(y).add(new GridCoordinate(x, y));
                    winningCombinations.get(y + 3).add(new GridCoordinate(y, x));
                } else {
                    winningCombinations.get(y).add(new GridCoordinate(x, y));
                    winningCombinations.get(y + 3).add(new GridCoordinate(y, x));
                }
            }
        }
        return winningCombinations;
    }

    public Map<GridCoordinate, DotCross> getBoard() {
        return board;
    }


}
