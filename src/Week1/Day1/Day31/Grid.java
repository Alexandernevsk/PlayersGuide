package Week1.Day1.Day31;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grid {
    private static final String IN_BETWEEN_GRID = "\n-+-+-\n";
    private final ArrayList<DotCross> _grid = new ArrayList<>();
    private final DotCross empty = DotCross.NONE;
    private final static int MAX_SIZE = 9;
    private final DotCross [] players = {DotCross.CROSS, DotCross.DOT};

    public Grid() {
        for(int i = 0; i < MAX_SIZE; i++){
            _grid.add(empty);
        }
    }

    @Override
    public String toString() {
        var gridDisplay = new StringBuilder();
       for(int i = 0; i < _grid.size(); i++){
           if(i < 2){
               gridDisplay.append(("%s|").formatted(_grid.get(i)));
           }else if(i % 3 == 0 ){
               gridDisplay.append(IN_BETWEEN_GRID);
               gridDisplay.append(("%s|").formatted(_grid.get(i)));
           }else if (i % 3 < 2){
               gridDisplay.append(("%s|").formatted(_grid.get(i)));
           }else gridDisplay.append(("%s").formatted(_grid.get(i)));
       }
       return gridDisplay.toString();
    }

    public boolean isSquareEmpty (int coordinate){
        return _grid.get(coordinate).equals(empty);
    }

    public void setMove(int move, int player){
        if (isSquareEmpty(move)) {
            _grid.set(move, players[player]);
        } else {
            System.out.println("not a valid move");
        }
    }
    public boolean checkWin(int player) {
        int[][] winningCombinations = {
                {0, 1, 2}, {3, 4, 5}, {6, 7, 8}, // rows
                {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, // columns
                {0, 4, 8}, {2, 4, 6} // diagonals
        };

        for (int[] combination : winningCombinations) {
            if (comparingElements(combination[0], combination[1], combination[2], player)) {
                return true;
            }
        }

        return false;
    }
    public boolean comparingElements(int x, int y, int z, int player){
      if(_grid.get(x).equals(players[player]))
        if((_grid.get(x).equals(_grid.get(y)))){
            return _grid.get(y).equals(_grid.get(z));
        }
      return false;
    }

    public boolean checkDraw(){
        return !_grid.contains(empty);
    }

    public  void runGrid(Grid grid){
       boolean endGame = false;
       while(!endGame){
           System.out.println(grid);
           System.out.println("Player 1 your turn");
           setMove(inputScanner()-1,0);
           System.out.println(grid);
           System.out.println("Player 2 your turn");
           setMove(inputScanner()-1,1);
           System.out.println(grid);
           if(checkWin(0)){
               System.out.println("player 1 wins!");
               endGame = checkWin(0);
           }else if(checkWin(1)){
               System.out.println("player 2 wins");
               endGame = checkWin(1);
           }else {
               System.out.println("its a draw");
               endGame = checkDraw();
           }
       }
    }

    public int inputScanner(){
        Scanner scanner = new Scanner(System.in);
        int move =0;
        try{
            move = scanner.nextInt();
            if(move < 1 || move > 9){
                System.out.println("not a valid number");
                inputScanner();
            }
        } catch (InputMismatchException e){
            System.out.println("not a valid input");
            inputScanner();
        }
        return move;
    }
}
