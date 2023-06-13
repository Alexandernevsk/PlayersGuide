package Week1.Day1.Day37;

public enum Gem  {
    AMBER, BITSTONE, DIAMOND, EMERALD, SAPPHIRE;


    @Override
    public String toString() {
        return this.name().toLowerCase();
    }
}
