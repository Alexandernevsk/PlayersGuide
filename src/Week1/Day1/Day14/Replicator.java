package Week1.Day1.Day14;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Replicator {
    public static void main(String[] args) {
        listinput();
        System.out.println(Arrays.toString(listInputParamater()));
    }
    public static void listinput(){
        Scanner input = new Scanner(System.in);
        int [] array = new int[5];
        for(int i = 0; i <= 4; i++){
           array[i] += input.nextInt();
        }
        System.out.println(Arrays.toString(array));
       replicate(array);
    }
    public static void replicate(int [] arr){
        int [] newArray = new int[5];
        for(int i = 0; i < arr.length; i++){
            newArray[i] += arr[i];
        }
        System.out.println(Arrays.toString(newArray));
    }
    public static int [] listInputParamater(){
        Scanner input = new Scanner(System.in);
        int [] list = new int[input.nextInt()];
        for(int i = 0; i < list.length; i++){
            list[i] += input.nextInt();
        }
        return list;
    }

}
