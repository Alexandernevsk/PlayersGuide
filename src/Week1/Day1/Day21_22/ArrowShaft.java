package Week1.Day1.Day21_22;
import java.util.Scanner;
public class ArrowShaft {
    private double length = 0;
    private final static double costPerLength = 0.05;
    private double shaftCost;

    public void costForShaft(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nChoose a length between 60 and 100 in cm");
        setLength(scanner.nextDouble());
        if(inBounds()) {
            System.out.println("Choose a valid length for the shaft.");
            costForShaft();
        }
        else {
                setShaftCost(getLength());
                System.out.println("The length is : " + getLength());
                System.out.println("The cost is : " + getShaftCost());
            }
        }

    public void setShaftCost(double length) {
      shaftCost = this.length * costPerLength;
    }
    public double getLength() {
        return length;
    }
    public void setLength(double length) {
        this.length = length;
    }
    //Rewrite inbounds is inverted
    public boolean inBounds() {
        return length < 60 || length > 100;
    }
   public double getShaftCost(){
        return shaftCost;
   }
   public double buy(){
       System.out.println("Type in the length of the shaft you want to buy");
       setLength(Integer.parseInt(TheShop.costumerResponse()));
     while (!inBounds()) {
         System.out.println("please type in a valid length between 60 and 100 cm");
         setLength(Integer.parseInt(TheShop.costumerResponse()));
     }
     setShaftCost(getLength());
     return getShaftCost();
   }

}
