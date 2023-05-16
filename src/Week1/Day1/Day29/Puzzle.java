package Week1.Day1.Day29;


import java.util.*;
import java.util.List;

public class Puzzle {
    private final int maxShuffleSteps;
    private static final String GAP = "";
    private final Map<Coordinates, String> board = new HashMap<>();
    private Coordinates gapCoordinate;
    private final int size;
    private final int textWidth;

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle(3);
        puzzle.shuffle();
        Scanner scanner = new Scanner(System.in);
        while(!puzzle.winCondition(puzzle)){
            System.out.println(puzzle);
            puzzle.action(scanner.nextLine());
        }
    }

    public Puzzle(int size){
        this.size = size;
        for(int x = 0; x < size; x++){
            for(int y = 0; y < size; y++){
                int value = 1 + x + (y * size); //isn't necessary, but I like to annotate the separation of operators nonetheless;
                board.put(new Coordinates(x,y), String.valueOf(value));
            }
        }
        textWidth = String.valueOf(size * size -1).length() + 1;
        //Seems only necessary from the power of ten onwards so that the last place is preserved for the largest number
        //But I like the generic solution for formatting the puzzle of size n.
        gapCoordinate = new Coordinates(size-1, size-1);
        board.put(gapCoordinate, GAP);
        maxShuffleSteps = 1000;
    }

    @Override
    public String toString(){
        var result = new StringBuilder();
        /*
        From what I understand from the previous for loop, is that this loop formats it in such a way,
        that the gap is placed in the right corner.
        This doesn't happen in the constructor, if the ordering is preserved in the Hashmap by way of first to last added.
        the puzzle would be turned 45 degrees counterclockwise.
         */
        for(int y = 0; y < size; y++){
            for(int x = 0; x < size; x++){
                result.append(("%" + textWidth + "s").formatted(board.get(new Coordinates(x,y))));
            }
            result.append("\n");
        }
        return result.toString();
    }

    public void shuffle(){
        var random = new Random();
        for(int i = 0; i < maxShuffleSteps; i++){
            List<Coordinates> possibleCoordinates = new ArrayList<>();
            for(var direction : Directions.values()){
                var potentialNewCoordinateGap = new Coordinates(gapCoordinate.x() + direction.dx,
                        gapCoordinate.y() + direction.dy);
                if(board.containsKey(potentialNewCoordinateGap)){
                    possibleCoordinates.add(potentialNewCoordinateGap);
                }
            }
            var newGapCoordinate = possibleCoordinates.get(random.nextInt(possibleCoordinates.size()));
            var valueToMove = board.get(newGapCoordinate);
            board.put(gapCoordinate, valueToMove);
            board.put(newGapCoordinate, GAP);
            gapCoordinate = newGapCoordinate;
        }
    }

    public void setGapCoordinate(Directions directions) {
        var newGapCoordinate = Directions.moveCoordinate(directions, gapCoordinate);
        var valueToMove = board.get(newGapCoordinate);
        if(board.containsKey(newGapCoordinate)){
            board.put(gapCoordinate, valueToMove);
            board.put(newGapCoordinate, GAP);
            gapCoordinate = newGapCoordinate;
        }
    }

    public void action (String input){
        char key = input.charAt(0);
        switch(key){
            case 'w' -> setGapCoordinate(Directions.DOWN);
            case 's' -> setGapCoordinate(Directions.UP);
            case 'a' -> setGapCoordinate(Directions.LEFT);
            case 'd' -> setGapCoordinate(Directions.RIGHT);
        }
    }

   public boolean winCondition(Puzzle puzzle){
      Puzzle goalboard =  new Puzzle(puzzle.size);
      if(goalboard.board.equals(puzzle.board)){
          return true;
      }
      else return false;
   }
}
