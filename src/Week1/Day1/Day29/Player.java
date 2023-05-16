package Week1.Day1.Day29;

import java.util.Collections;

public class Player implements Moveable {
    private Board board;
    private String name;

    private int turns = 0;

    public Player(Board board, String name) {
        this.board = board;
        this.name = name;
    }

    public Board getBoard() {
        return board;
    }

    @Override
    public void up() {
        Collections.swap(getBoard().getBoardState(),getBoard().getBoardState()
                .indexOf(8)-Board.getArea(), getBoard().getBoardState().indexOf(8));
    }

    @Override
    public void down() {
        Collections.swap(getBoard().getBoardState(),getBoard().getBoardState()
                .indexOf(8)+Board.getArea(), getBoard().getBoardState().indexOf(8));
    }

    @Override
    public void left() {
        if(getBoard().getBoardState().indexOf(8) % Board.getArea() > 0) {
            Collections.swap(getBoard().getBoardState(), getBoard().getBoardState()
                    .indexOf(8) - 1, getBoard().getBoardState().indexOf(8));
        }else System.out.println("not a option");
    }

    @Override
    public void right() {
        if(getBoard().getBoardState().indexOf(8) % Board.getArea() < 2) {
            Collections.swap(getBoard().getBoardState(), getBoard().getBoardState()
                    .indexOf(8) + 1, getBoard().getBoardState().indexOf(8));
        }else System.out.println("not a option");

    }

    public int getTurns() {
        return turns;
    }

    public void chooseOptions(String choice) {
        turns++;
        switch (choice){
            case "up" -> up();
            case "down" -> down();
            case "left" -> left();
            case "right" -> right();
            default -> System.out.println("not a option");
        }
    }

}
