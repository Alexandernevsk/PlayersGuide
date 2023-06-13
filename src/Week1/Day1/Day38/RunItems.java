package Week1.Day1.Day38;


public class RunItems {
    public static void main(String[] args) {
        ColoredItem<Axe> axeColoredItem = new ColoredItem<>( new Axe(), "green");
        axeColoredItem.display();
        ColoredItem<Bow> bowColoredItem = new ColoredItem<>(new Bow(), "RED");
        bowColoredItem.display();
        ColoredItem<Sword> swordColoredItem = new ColoredItem<>(new Sword(), "BlUe");
        swordColoredItem.display();
    }
}
