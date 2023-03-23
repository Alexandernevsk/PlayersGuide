package Week1.Day1.Day21_22;

public enum StandardArrows {
    BEGINNER(Arrowhead.WOOD, FeatherType.GOOSE, 75),
    MARKSMAN(Arrowhead.STEEL, FeatherType.GOOSE, 65),
    ELITE(Arrowhead.STEEL, FeatherType.PLASTIC, 95);
    private final Arrowhead head;
    private final FeatherType feather;
    private final ArrowShaft shaft;
    private double priceCost;

    public double getPrice() {
        return head.getCost() + feather.getCost();
    }

    StandardArrows(Arrowhead head, FeatherType feather, double length) {
        this.head = head;
        this.feather = feather;
        this.shaft = new ArrowShaft();
        this.shaft.setLength(length);
    }

    public double getLength() {
        return shaft.getLength();
    }

    public Arrowhead getHead() {
        return head;
    }

    public FeatherType getFeather() {
        return feather;
    }
    public double getPriceCost(String choose) {
        for (StandardArrows e : StandardArrows.values()) {
            if (choose.equalsIgnoreCase(e.toString())) {
                ArrowShaft shaft = new ArrowShaft();
                shaft.setLength(e.getLength());
                shaft.setShaftCost(shaft.getLength());
                priceCost = shaft.getShaftCost() + e.getHead().getCost() + e.getFeather().getCost();
                return priceCost;
            }
        }
        return 0;
    }

    public static double getPriceCost(StandardArrows choice) {
        for (StandardArrows e : StandardArrows.values()) {
            if (choice == e) {
                ArrowShaft shaft = new ArrowShaft();
                shaft.setLength(e.getLength());
                shaft.setShaftCost(shaft.getLength());
                double priceCost = shaft.getShaftCost() + e.getHead().getCost() + e.getFeather().getCost();
                return priceCost;
            }
        }
        return 0;
    }
}
