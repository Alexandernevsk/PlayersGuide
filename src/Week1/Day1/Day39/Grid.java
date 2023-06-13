package Week1.Day1.Day39;

import java.util.Random;
import java.util.Scanner;

public class Grid {
    private final Room [][] map;
    private final MapSize size;
    public Grid(MapSize size) {
        this.size = size;
        map = new Room[size.squareSize][size.squareSize];

       for(int i = 0; i < size.squareSize; i++){
           for(int j = 0; j < size.squareSize; j++){
                 map[i][j] = new EmptyRoom();
           }
       }
       switch (size){
           case DEFAULT -> {
               map[0][0] = new EntranceAndExitRoom();
               map[2][0] = new FountainRoom();
               map[1][1] = new PitRoom();
           }
           case MEDIUM -> {
               map[2][2] = new EntranceAndExitRoom();
               map[4][0] = new FountainRoom();
               map[3][2] = new PitRoom();
           }
           case LARGE -> {
               map [5][0] = new EntranceAndExitRoom();
               map [7][2] = new FountainRoom();
               map[3][3] = new PitRoom();
           }
       }
       getEntrance().setRoom(getFountainRoom());
    }

    public static void main(String[] args) {
        Grid grid = new Grid(MapSize.DEFAULT);
        System.out.println(grid.getPitRoom().getRoomDescription());
    }


    /**
     * This method is way too hard to implement
     * I need some kind of shuffle path that keeps record of all classes that are in that array
     * As for now i haven't cracked the nut.
     */

    /** public void setPitRoom(){
        var random = new Random();
        //Initializing the pit room
        //How can initialize a randomizer that overlooks the two values?
        //Would be even more complex the further you go with types.
        for(int row = 0; row < size.squareSize; row++){
            for(int column = 0; column < size.squareSize; column++){
                while(!(map[row][column] instanceof EntranceAndExitRoom) && !(map[row][column] instanceof FountainRoom)){
                    map[random.nextInt(size.squareSize)][random.nextInt(size.squareSize)] = new PitRoom();
                }
            }
        }
    }
    **/

    public PitRoom getPitRoom(){
     for(Room[] rooms : map){
         for(int j = 0; j < map.length; j++){
             if(rooms[j] instanceof PitRoom ){
                 return (PitRoom) rooms[j];
                }
            }
        }
     return null;
    }
    public EntranceAndExitRoom getEntrance(){
        for (Room[] rooms : map) {
            for (int j = 0; j < map.length; j++) {
                if (rooms[j] instanceof EntranceAndExitRoom) {
                    return (EntranceAndExitRoom) rooms[j];
                }
            }
        }
        return null;
    }
    public FountainRoom getFountainRoom () {
        for (Room[] rooms : map) {
            for (int j = 0; j < map.length; j++) {
                if (rooms[j] instanceof FountainRoom) {
                    return (FountainRoom) rooms[j];
                }
            }
        }
        return null;
    }

    public Room[][] getMap() {
        return map;
    }

    enum MapSize {
        LARGE(8), MEDIUM(6), DEFAULT(4);
        public final int squareSize;
        MapSize(int size) {
            this.squareSize = size;
        }

        public static MapSize chooseSize() {
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            for(var size : MapSize.values()){
                if(input.equalsIgnoreCase(size.toString())){
                    return size;
                }
            }
            System.out.println("not valid");
            return chooseSize();
        }
    }
    public int getSizeNumber() {
        return size.squareSize;
    }



    public Room getRoom(int row, int colum) {
      return map[row][colum];
    }
}
