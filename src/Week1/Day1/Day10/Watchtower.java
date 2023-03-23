package Week1.Day1.Day10;

import java.util.Scanner;

public class Watchtower {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int[] locationWatchtower = {0, 0};
        int[] locationEnemy = {0, 0};
        int[] direction = {0, 0};
        System.out.println("Please provide x coordinates for the watchtower");
        locationWatchtower[0] = input.nextInt();
        System.out.println("Please provide y coordinates for the watchtower");
        locationWatchtower[1] = input.nextInt();
        System.out.println("Where did the watchmen spot the enemy? Please provide x coordinates");
        locationEnemy[0] = input.nextInt();
        System.out.println("Where did the watchmen spot the enemy? Please provide y coordinates");
        locationEnemy[1] = input.nextInt();
        direction[0] = locationWatchtower[0] + locationEnemy[0];
        direction[1] = locationWatchtower[1] + locationEnemy[1];
        if (direction[0] > 1 && direction[1] == 0) {
            System.out.println("The enemy is east of the city.");
        } else if (direction[0] > 1 && direction[1] > 1) {
            System.out.println("The enemy is north-east of the city.");
        } else if(direction [0] == 0 && direction[1] >= 1){
            System.out.println("The enemy is north of the city.");
        }else if(direction[0] < 1 && direction[1] > 1) {
            System.out.println("The enemy is north-west of the city.");
        }else if(direction[0] < 0 && direction[1] == 0){
            System.out.println("The enemy is west of the city.");
        }else if(direction[0] == 0 && direction[1] < 0){
            System.out.println("The enemy is south of the city.");
        }else if(direction[0] < 0 && direction[1] < 0){
            System.out.println("The enemy is south-west of the city.");
        }else if(direction[0] > 0 && direction[1] < 1){
            System.out.println("The enemy is south-east of the city.");
        }else System.out.println("The Enemy is at the gates!! I hope Gandalf will arive with Rohirrim in time!");
    }
}