package Week1.Day1.Day31;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Grid {
    private static final String IN_BETWEEN_GRID = "\n-+-+-\n";
    private final ArrayList<DotCross> _grid = new ArrayList<>();
    private final DotCross empty = DotCross.NONE;
    private final static int MAX_SIZE = 9;
    private static int turn = 0;
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

    public boolean isSquareEmpty(int coordinate){
       return _grid.get(coordinate).equals(empty);
    }

    public void setMove(int move, int player){
       _grid.set(move,players[player]);
    }

    public void checkLegalMove(int player){
        int move = check();
        while(!isSquareEmpty(move)){
            System.out.println("not a valid move!");
            move = check();
        }
        setMove(move, player);
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
        if (_grid.get(x).equals(players[player]))
            if ((_grid.get(x).equals(_grid.get(y)))) {
                return _grid.get(y).equals(_grid.get(z));
            }
      return false;
    }

    public boolean checkDraw(){
        return !_grid.contains(empty);
    }

    public void turnCounter(Grid grid){
        System.out.println(grid);
        if(turn != 0){
                turn = 0;
        }else turn++;
    }

    public void runGrid(Grid grid){
        System.out.println("Welcome to the classic tic tac toe game.");
        System.out.println("You make a move by typing a coordinate between 1 and 9.");
        System.out.println("1 is the upper left corner, and 9 is the upper right corner.");
        System.out.println("All the other move in a zig-zig pattern across the grid.");
        System.out.println();
        System.out.println("Have fun!");
        System.out.println();
        System.out.println(grid);
        System.out.println();
        while(allConditions()) {
            System.out.println("player " + (turn +1 ) + " its your turn");
           checkLegalMove(turn);
            turnCounter(grid);
        }
        System.out.println(grid);
    }

    public boolean allConditions(){
        if(checkWin(0)){
            System.out.println("\nplayer " + 1 + " wins!");
            return false;
        } else if(checkWin(1)){
            System.out.println("\nplayer " + 2 + " wins!");
            return false;
        } else if(checkDraw()){
            System.out.println("\nIt's a draw");
            return false;
        }else return true;
    }

    public int inputScanner(){
        Scanner scanner = new Scanner(System.in);
        int move = scanner.nextInt();
            if(move < 1 || move > 9){
                System.out.println("not a valid number");
                return inputScanner();
            }
            return move-1;
        }

    public int check(){
        try{
           return inputScanner();
        }
        catch (InputMismatchException e){
            System.out.println("not a valid input");
        }
        return check();
    }
}
