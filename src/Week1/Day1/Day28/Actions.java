package Week1.Day1.Day28;

public enum Actions  {
    ROCK, PAPER, SCISSOR;

    @Override
    public String toString() {
        return this.name();
    }

    public static Actions choose (String input){
        for(Actions a: Actions.values()){
            if(input.equalsIgnoreCase(a.toString())){
                return a;
            }
        }
        return null;
    }
}
