package Week1.Day1.Day31;

import java.util.Random;
import java.util.Scanner;

public class Player {
private TicTacToe ticTacToe;
    public Player(TicTacToe ticTacToe) {
        this.ticTacToe = ticTacToe;
    }

    public Actions[] registerAction(String input) {
        String[] commands = input.split(" ");
        if(commands.length > 2){
            throw new IllegalArgumentException("You can't choose more than two options");
        }
        Actions[] chosen_action = new Actions[commands.length];
        for(int i = 0; i < chosen_action.length; i++){
            for(Actions actions : Actions.values()){
                if(commands[i].equalsIgnoreCase(actions.toString())){
                    chosen_action[i] = actions;
                }
            }
        }
      return chosen_action;
    }

    public GridCoordinate getCoordinate(Actions[] players_action){
        GridCoordinate gridCoordinate = new GridCoordinate(0,0);
        for (Actions actions : players_action) {
         gridCoordinate = new GridCoordinate(gridCoordinate.x() + actions.getX(), gridCoordinate.y() + actions.getY());
        }
        return gridCoordinate;
    }


    public void changeBoardPlayer1(){
        GridCoordinate playerPosition = getCoordinate(registerAction(userInput()));
        boolean checkLegalMove = ticTacToe.isSquareEmpty(playerPosition);
        if(checkLegalMove){
            ticTacToe.getBoard().put(playerPosition, DotCross.CROSS);
        } else {
            System.out.println("Not a legal move");
            changeBoardPlayer1();
        }
   }
    public void changeBoardPlayer2(){
        GridCoordinate playerPosition = getCoordinate(registerAction(userInput()));
        boolean checkLegalMove = ticTacToe.isSquareEmpty(playerPosition);
        if(checkLegalMove){
            ticTacToe.getBoard().put(playerPosition, DotCross.DOT);
        } else {
            System.out.println("Not a legal move");
            changeBoardPlayer2();
        }
    }

  /**public void computerMove(){
        var random = new Random();
        GridCoordinate computerPosition = new GridCoordinate(random.nextInt(3), random.nextInt(3));
        boolean checkLegalMove = ticTacToe.isSquareEmpty(computerPosition);
        if(checkLegalMove){
            ticTacToe.getBoard().put(computerPosition, DotCross.DOT);
        } else if(ticTacToe.checkWinCondition()){
            return;
        }else computerMove();
   }
   **/

   public String userInput(){
       Scanner scanner = new Scanner(System.in);
       return scanner.nextLine();
   }

}


