package card;

import java.util.ArrayList;

public class Hand extends Card{

    int handX, handY;

    public ArrayList<Card> ciHand;

    public Deck deck;

    public Hand(Deck deck) {

        this.deck = deck;

        ciHand = new ArrayList<Card>();

        for(int i = 0; i < 2; i++) {
            ciHand.add(deck.deck.remove(deck.deck.size() - 1));
        }
    }


    public int getValue() {
        int value = 0;
       for (int i = 0; i < ciHand.size(); i++) {
           value += ciHand.get(i).getValue(ciHand.get(i));
       }
       return value;
    }

    public void addCard() {
        ciHand.add(deck.deck.remove(deck.deck.size() - 1));
    }


    public void update() {

    }


    public String toString() {
        String output = "";
        for (int i = 0; i < ciHand.size(); i++) {
            output += ciHand.get(i).face + " " + ciHand.get(i).suit + " | ";
        }
        return output;
    }
}
