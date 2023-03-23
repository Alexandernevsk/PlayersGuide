package Week1.Day1.Day21_22;

public enum Arrowhead {
    STEEL(10),
    OBSIDIAN(5),
    WOOD(3);
    private final int cost;
    Arrowhead(int cost) {
        this.cost = cost;
    }
    public int getCost(){
        return cost;
    }
    public static int loop(String choose){
        for(Arrowhead e: Arrowhead.values()){
            if(choose.equalsIgnoreCase(e.toString())){
                return e.getCost();
            }
        }
        return 0;
    }
    public static void allValues(){
        for(Arrowhead e: Arrowhead.values()){
            String enum_to_String = e.toString().charAt(0) + e.toString().substring(1).toLowerCase();
            System.out.println("Prices for arrowhead's are: " + enum_to_String + " " + e.getCost());
        }
    }

}
