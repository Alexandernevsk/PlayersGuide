package Day8;

import java.awt.*;
import java.util.Scanner;

public class Consolas {
    public static void main(String[] args) {
        Consolas target = new Consolas();
        Scanner rowInput = new Scanner(System.in);
        Scanner columnInput = new Scanner(System.in);
        target.Coordinates(rowInput.nextInt(), columnInput.nextInt());
        Toolkit.getDefaultToolkit().beep();
    }
    /*Vraag? voor de verdediging van deze stad is het noodzakkelijk dat
         de magische barrière wordt bemand door 4?
         Want de hoek-gevallen hangen daar van af.
         Er staat in het verhaal dat de stad is opgedeeld als een schaakbord. Dat betekent een 8*8 bord.
         Dus het lijkt me dat je rekening mee moet houden.
         Maakt de opdrach wel moeilijker.
         */
    public void Coordinates (int row, int column){
        System.out.println("Target is: (" + row + " "  + column  + ")" );
        if (row > 8 || row < 1) {
            System.out.println("Row out of bounds, please pick a number between 1 to 8.");
        } else if (column > 8 || column < 1) {
            System.out.println("Row out of bounds, please pick a number between 1 to 8.");
        }
        int north = column + 1;
        int south = column - 1;
        int west = row - 1;
        int east = row + 1;
        if (north == 9 && west != 0) {
            if (east == 9) {
                System.out.println("(" + row + "," + south + ")\n(" + west + "," + column + ")");
            } else System.out.println("(" + south + " " + row + ")\n(" + west + " " + column + ")\n " +
                    "(" + east + " " + column + ")");
        } else if (south == 0 && west != 0) {
            if (east == 9) {
                System.out.println("(" + west + " " + column + ")\n(" + row + " " + north + ")");
            } else System.out.println("(" + west + " " + column + ")\n(" + row + " " + north + ")\n("
                    + east + " " + column + ")");
        } else if (west == 0) {
            if (north == 9) {
                System.out.println("(" + row + ", " + south + ")\n(" + east + ", " + column + ")");
            } else if (south == 0) {
                System.out.println("(" + row + " " + north + ")\n(" + east + " " + column + ")");
            } else System.out.println(row + " " + south + ")\n(" + row + " " + north + ")\n" +
                    "(" + east + " " + column + ")");
        } else if (east == 9) {
            System.out.println("(" + row + " " + south + ")\n(" + west + " " + column +
                    ")\n(" + row + " " + north + ")");
        } else System.out.println("(" + row + " " + south + ")\n(" + west + " " + column +
                ")\n(" + row + " " + north
                + ")\n(" + east + " " + column + ")");
    }
}
