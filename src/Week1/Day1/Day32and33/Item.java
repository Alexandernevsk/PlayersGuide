package Week1.Day1.Day32and33;

public abstract class Item {
    /**
     * Has several child classes:
     * Arrow with weight 0.1 and volume 0.05
     * Bow with weight of 1 and volume 4
     * Rope with weight of 1 and volume 1.5
     * Water with weight of 2 and volume of 3.5
     * Food Rations weight of 1 and volume of 0.5
     * Sword weight of 5 and volume of 3
     */

    private final double decimalWeight;
    private final double decimalVolume;

    public Item(double decimalWeight, double decimalVolume) {
        this.decimalWeight = decimalWeight;
        this.decimalVolume = decimalVolume;
    }

    public Item(int weight, int volume){
        this.decimalWeight =  weight;
        this.decimalVolume = volume;
    }

    public double getDecimalWeight() {
        return decimalWeight;
    }

    public double getDecimalVolume() {
        return decimalVolume;
    }



    @Override
    public String toString() {
        return this.getClass().getSimpleName();
    }
}

class Arrow extends Item {
    public Arrow (){
        super(0.1,0.05);
    }
}
class Bow extends Item{
    public Bow (){
        super(1,4);
    }
}
class Rope extends Item {
    public Rope (){
        super(1,1.5);
    }
}
class Water extends Item {
    public Water () {
        super(2,3);
    }
}
class FoodRations extends Item {
    public FoodRations () {
        super(1,0.5);
    }
}
class Sword extends Item {
    public Sword () {
        super(5,3);
    }
}
