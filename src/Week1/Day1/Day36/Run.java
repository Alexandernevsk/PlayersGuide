package Week1.Day1.Day36;

public class Run {
    public static void main(String[] args) {
        RoomCoordinate roomCoordinate = new RoomCoordinate(1,1);
        RoomCoordinate roomCoordinate1 = new RoomCoordinate(2,1);
        System.out.println(roomCoordinate.isNear(roomCoordinate1));
    }


}
