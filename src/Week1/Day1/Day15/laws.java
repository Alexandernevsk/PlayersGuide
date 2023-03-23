package Week1.Day1.Day15;
import Week1.Day1.Day14.Replicator;

import java.util.Arrays;

public class laws {
    //Voor de opdracht de replicator-methode geleend om variabele lengte lijsten en inputs te verwerken
    public static void main(String[] args) {
        averageAndMinimum(Replicator.listInputParamater());
    }
    public static void averageAndMinimum(int [] arr){
       int currentSmallest = Integer.MAX_VALUE;
       int totalCost = 0;
       double average = 0;

       for(int c: arr){
           if(c < currentSmallest){
               currentSmallest = c;
           }
       }
       for(int c: arr){
           totalCost += c;
           average =(double) totalCost/arr.length;
       }
       System.out.println(Arrays.toString(arr));
       System.out.println(currentSmallest);
       System.out.println(average);
    }
}

