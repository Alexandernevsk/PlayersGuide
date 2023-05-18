package Week1.Day1.Day31;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

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
    public boolean checkWin(int player){
        return false;
    }

    public ArrayList<DotCross> getWinningCombinations(){
     return null;
    }

    public static void main(String[] args) {
        Grid grid = new Grid();

    }
}
