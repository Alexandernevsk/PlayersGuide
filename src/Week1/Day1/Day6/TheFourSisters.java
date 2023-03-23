package Week1.Day1.Day6;

import java.util.Scanner;
public class TheFourSisters {
        public static void main(String[] args) {
            System.out.println("How many eggs did you gather today?");
            Scanner userInput = new Scanner(System.in);
            int duckBear = 0;
            int fourSisters = 0;
            int collectedEggs = userInput.nextInt();
            fourSisters += collectedEggs / 4;
            duckBear += collectedEggs % 4;
            System.out.println("Every sister has: " + fourSisters + " eggs");
            System.out.println("The duckbear has: " + duckBear + " eggs");
            System.out.println("Total count when duckBear has more eggs is: " + duckBearMore());
        }
        public static int duckBearMore() {
            int result = 0;
            for(int eggs = 0; eggs < 20; eggs++){
                int collectedeggs = eggs;
                int duckBear = 0;
                int fourSisters = 0;
                duckBear += collectedeggs%4;
                fourSisters += collectedeggs/4;
                if(duckBear == fourSisters && collectedeggs !=0){
                    result++;
                }
            }
            return result;
        }
}
