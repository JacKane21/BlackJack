package card;

import java.util.ArrayList;
import java.util.Random;

public class Deck {

    public ArrayList<Card> deck;

    public Card card;

    public int numFaces;

    public int numSuits;

    public Deck(Card card) {

        this.card = card;

        numFaces = card.Faces.length;

        numSuits = card.Suit.length;

        deck = new ArrayList<Card>();

        int index = 0;

        for(int i = 0; i < numSuits; i++) {
            for (int j = 0; j < numFaces; j++) {
                deck.add(index, new Card(card.Suit[i], card.Faces[j]));
            }
        }
    }

    public void shuffle() {
        Random num = new Random();
        for (int i = deck.size() - 1; i > 0; i--){
            int j = num.nextInt(i + 1);
            Card temp = deck.get(i);
            deck.set(i, deck.get(j));
            deck.set(j, temp);
        }
    }

    public String toString() {
        String output = "";
        for (int i = 0; i < deck.size(); i++) {
            output += deck.get(i).face + " " + deck.get(i).suit + " | " ;
        }
        return output;
    }
}
