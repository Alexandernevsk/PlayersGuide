package Week1.Day1.Day29;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;


//Make shuffle path, to guarantee the solvability of the boardstate.
public class Board {
    private static int area;

    private ArrayList<Integer> boardState;

    //make arraylist within arraylist;
    ArrayList<ArrayList<Integer>> twodimensionalBoard;

    //make a coordinate class with value of the value is the tileNumber;
    HashMap<String, Integer> keyValueBoard;
    public Board(int area, ArrayList<Integer> boardState) {
        Board.area = area;
        this.boardState = boardState;
    }

    public ArrayList<Integer> getBoardState() {
        return boardState;
    }

    public void setBoardState() {
        for(int i = 0; i < area*area; i++){
            boardState.add(i);
        }
    }


    public void shuffleBoard(){
        Collections.shuffle(getBoardState());
    }
    public static int getArea(){
        return area;
    }

    public static boolean isSolvable(ArrayList<Integer> board){
        int inversions = 0;
        for(int i = 0; i < board.size(); i++){
            for(int j = i+1; j < board.size(); j++) {
                if (board.get(i) != 9 && board.get(j) != 9) {
                    if (board.get(i) > board.get(j)) {
                        inversions++;
                    }
                }
            }
        }
       return inversions % 2 == 0;
    }

    public void displayBoard(){
        for(int j = 0; j < getBoardState().size(); j++){
            if(getBoardState().get(j) == 8){
                System.out.printf("  ");
            }else if(j % area > 0) {
                System.out.printf("%2d", getBoardState().get(j) +1);
            } else System.out.printf("%2d", getBoardState().get(j) +1);
            if(j % 3 == 2){
                System.out.println();
            }
        }
    }



    //Een methode voor het maken van geldige random transformaties die kijken naar de oplosbaarheid van de bordtoestand.
    public void makeRandomMoves(){

    }

}
