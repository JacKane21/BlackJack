package card;

import java.awt.*;
import java.util.ArrayList;

public class Hand extends Card{

    int handX, handY;

    public ArrayList<Card> ciHand;

    Deck deck;

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

    public void draw(int x, int y, Graphics2D g2) {
        handX = x;
        handY = y;
        for(int i = 0; i < ciHand.size(); i++) {
            g2.drawImage(ciHand.get(i).cardImage, handX, handY, cardWidth, cardHeight, null);
            handX += cardWidth + 10;
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < ciHand.size(); i++) {
            output += ciHand.get(i).face + " " + ciHand.get(i).suit + " | ";
        }
        return output;
    }
}
