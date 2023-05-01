package Week1.Day1.Day28;


import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Scanner;


public class Player implements Comparable<Actions> {
    private Actions playersAction;
    private final String name;
    private final HashMap<Result, Integer> outcome = new HashMap<>();



    public Player() {
        System.out.println("Choose a username");
        name = userInput();
        for(Result r: Result.values()){
            outcome.put(r, 0);
        }
    }

    public static String userInput(){
        Scanner scanner = new Scanner(System.in);
        return scanner.nextLine();
    }

    public static void chooseAction(Player player){
        System.out.println(player.name + " choose your action. (Rock, Paper or Scissor)");
           player.playersAction = Actions.choose(userInput());
      if(player.playersAction == null) {
          System.out.println("Not a valid action");
          chooseAction(player);
      }
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n");
    }
    @Override
    public int compareTo(@NotNull Actions o) {
        switch (playersAction){
            case ROCK -> { switch (o){
                case SCISSOR -> {return 1;}
                case PAPER ->   {return -1;}
                }
            }
            case PAPER -> { switch (o){
                case ROCK ->      {return 1;}
                case SCISSOR -> {return -1;}
                }
            }
            case SCISSOR -> { switch (o){
                case PAPER ->  {return 1;}
                case ROCK ->  {return -1;}
                }
            }
        }
        return 0;
    }


    public static void manageOutcomes(){
       Player player1 = new Player();
       Player player2 = new Player();
        while(true) {
            chooseAction(player1);
            chooseAction(player2);
            switch (player1.compareTo(player2.playersAction)){
                case 1 -> {player1.setOutcome(Result.WIN) ; player2.setOutcome(Result.LOSS);}
                case-1 -> {player1.setOutcome(Result.LOSS);player2.setOutcome(Result.WIN);}
                case 0 -> {player1.setOutcome(Result.DRAW); player2.setOutcome(Result.DRAW);}
            }
            System.out.println(player1);
            System.out.println(player2);
            System.out.println("Done? Type no to exit");
            if(userInput().equalsIgnoreCase("no")){
                return;
            }
        }
    }

    @Override
    public String toString() {
        return this.name + " " + this.outcome ;
    }
    public void setOutcome(Result result){
        this.outcome.put(result, outcome.get(result)+1);
    }

}
