package Week1.Day1.Day31;

public class runTicTacToe {
    public static void main(String[] args) {
        TicTacToe ticTacToe = new TicTacToe();
        Player player = new Player(ticTacToe);
        System.out.println("Welcome to TicTacToe");
        System.out.println("You can place a Cross by typing, center top or bottom, and then choosing whether move left or right.");
        int turncounter = 0;
        while (!ticTacToe.checkWinCondition()){
            System.out.println(ticTacToe);
            System.out.println();
            player.changeBoardPlayer1();
            turncounter++;
            System.out.println(ticTacToe);
            player.changeBoardPlayer2();
            turncounter++;
            System.out.println(turncounter);
            if(turncounter  == 9){
                break;
            }
        }

    }

}
