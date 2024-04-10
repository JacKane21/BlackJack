package card;

import java.awt.*;

public class Hand extends Card{

    int handX, handY;

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

    public void update() {

    }

    public void draw(int x, int y, Graphics2D g2) {
        handX = x;
        handY = y;
        for(int i = 0; i < ciHand.length; i++) {
            g2.drawImage(ciHand[i].cardImage, handX, handY, cardWidth, cardHeight, null);
            handX += cardWidth + 10;
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < ciHand.length; i++) {
            output += ciHand[i].face + " " + ciHand[i].suit + " | ";
        }
        return output;
    }
}
