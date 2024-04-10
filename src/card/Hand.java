package card;

public class Hand {

    public Card[] ciHand;

    Deck deck;

    public Hand(Deck deck) {

        this.deck = deck;

        ciHand = new Card[2];

        for(int i = 0; i < ciHand.length; i++) {
            ciHand[i] = deck.deck.remove(deck.deck.size() - 1);
        }
    }

    public int getValue() {
        int value = 0;
       for (int i = 0; i < ciHand.length; i++) {
           value += ciHand[i].getValue(ciHand[i]);
       }
       return value;
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < ciHand.length; i++) {
            output += ciHand[i].face + " " + ciHand[i].suit + " | ";
        }
        return output;
    }
}
