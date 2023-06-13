package Week1.Day1.Day37;

public enum Material{
    BINARIUM, BRONZE, IRON, STEEL, WOOD;


    //Comes first in the Sword.toString() object so reason why it always starts with capital letter at the beginning.
    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
