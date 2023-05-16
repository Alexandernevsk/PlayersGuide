package Week1.Day1.Day29;

import java.util.ArrayList;
import java.util.Scanner;

public class RunTheBoard {
    public static void main(String[] args) {
        Board goalBoard = new Board(3, new ArrayList<>());
        goalBoard.setBoardState();
        Player player = new Player(new Board(3, new ArrayList<>()), "Alexander");
        player.getBoard().setBoardState();
        player.getBoard().shuffleBoard();
        while(!Board.isSolvable(player.getBoard().getBoardState())){
            player.getBoard().shuffleBoard();
        }
        Scanner scanner = new Scanner(System.in);


        while(!(goalBoard.getBoardState().equals(player.getBoard().getBoardState()))){
            player.getBoard().displayBoard();
            try {
                player.chooseOptions(scanner.nextLine());
            }catch (IndexOutOfBoundsException outOfBoundsException){
                System.out.println("Not a valid option");
            }
        }
        System.out.println("You win.");
    }



}
