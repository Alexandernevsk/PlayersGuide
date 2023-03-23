package Week1.Day1.Day21_22;

public enum FeatherType {
    PLASTIC(10),
    TURKEY(5),
    GOOSE(3);
    private final int cost;
    FeatherType(int cost){
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public static int loop(String choose){
        for(FeatherType e: FeatherType.values()){
            if(choose.equalsIgnoreCase(e.toString())){
                return e.getCost();
            }
        }
        return 0;
    }
    public static void allValues(){
        for(FeatherType e: FeatherType.values()){
            String enum_to_String = e.toString().charAt(0) + e.toString().substring(1).toLowerCase();
            System.out.println("Prices for arrowhead's are: " + enum_to_String + " " + e.getCost());
        }
    }
}
