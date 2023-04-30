package Week1.Day1.Day18;

import java.util.Scanner;
public class Manticore  {

    private int manticoreHealthPoints = 10;

    public int displayManticoreHp(){
        return manticoreHealthPoints;
    }

    public void reduceManticoreHp(int specialAttack){
        if(specialAttack % 15 == 0){
            System.out.println("This turn the manticore loses all his hp (Combined blast).");
            manticoreHealthPoints -= 10;
        }else if(specialAttack % 5 == 0){
            System.out.println("This turn the manticore loses 3 hp (Eletric blast).");
            manticoreHealthPoints -= 3;
        }else if (specialAttack % 3 == 0){
            System.out.println("This turn the manticore loses 3 hp (Fire blast).");
            manticoreHealthPoints -= 3;
        }else manticoreHealthPoints--;
    }
}




