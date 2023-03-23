package Week1.Day1.Day13;

public class MagicCanon {
    public static void main(String[] args) {
        Canon();
    }

    public static void Canon(){
        for(int i = 1; i <= 100; i++){
            if(i % 15 == 0){
                System.out.println(i + ": Combined");
            }else if(i % 5 == 0){
                System.out.println(i + ": Electric");
            }else if (i % 3 == 0){
                System.out.println(i + ": Fire");
            }else System.out.println(i + ": Normal");
        }
    }
}
