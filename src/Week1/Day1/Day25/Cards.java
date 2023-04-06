package Week1.Day1.Day25;

import java.util.ArrayList;
/* The main difference between this assignment and the previous one, is that color as expressed in a color class aren't necessarily constants.
 * The reason for that is that you want the Color class to have a certain amount of flexibility in choosing which color you want to represent,
 * aside from some more common choices - which you can define as a final class-variable.
 * In this assignment there are 4 colors, these are constant, unless the Cards want to add additional features.
 * There are no 7 shades of red which you need to model in this program, only 4. And this is more fitting for a enum than a class.
 * That's I think crucial for the difference between the two assignments.
 */
public class Cards {
    private final CardRanks rank;
    private final CardColor color;


    public static void main(String[] args) {
        Cards cards = new Cards();
        System.out.println(cards.createDeck()+ "\n");
        System.out.println(cards.showCard(cards.createDeck(), 20 )+ "\n");
        cards.isItaSymbol(cards.createDeck(), 9);
        System.out.println();
        Cards cards1 = new Cards(CardRanks.N2, CardColor.BLUE);
        System.out.println(cards1);

    }
    public ArrayList<Cards> createDeck() {
        ArrayList<Cards> deck = new ArrayList<>();
        for(int i = 0; i < CardColor.values().length; i++){
            for(int j = 0; j < CardRanks.values().length; j++){
                deck.add(new Cards(CardRanks.displayall(j), CardColor.displayall(i)));
            }
        }
        return deck;
    }
    public Cards showCard(ArrayList<Cards> card, int i){
        return card.get(i);
    }
    public void isItaSymbol(ArrayList<Cards> cards, int index){
           try{
               Integer.parseInt(cards.get(index).rank.getSymbols());
               System.out.println("The " + cards.get(index).rank.getSymbols() + " is a number.");
           }
           catch (NumberFormatException nfe){
               System.out.println("The " + cards.get(index).rank.getSymbols() + " is a symbol.");
           }
    }
    public Cards() {
        rank = null;
        color = null;
    }
    public Cards(CardRanks rank, CardColor color) {
        this.rank = rank;
        this.color = color;
    }
    @Override
    public String toString() {
        assert rank != null;
        assert color != null;
        return "Card ("
                + color.toString().charAt(0) + color.toString().substring(1).toLowerCase() +
                "," +
                rank.getSymbols() +
                ')';
    }
}
