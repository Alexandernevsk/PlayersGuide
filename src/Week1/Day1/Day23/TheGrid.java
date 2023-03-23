package Week1.Day1.Day23;

import Week1.Day1.Day21_22.ArrowShaft;

import java.util.ArrayList;

public class TheGrid {
    public static void main(String[] args) {
        CreatingGrid();
    }
    public static void CreatingGrid(){
        for(int i = 50; i >= -50; i--){
            for(int j = 50; j >= -50; j--) {
                if (i == 0 && j == 0) {
                    System.out.print("+");
                } else if (j == 0) {
                    System.out.print("|");
                }else if (i == 0){
                    System.out.print("~");
                }else if(i > 0){
                    System.out.print("-");
                }else if(j < 0){
                    System.out.print("-");
                }else if(j > 0){
                    System.out.print("-");
                }
                }
            System.out.println("");
            }
        }
}


