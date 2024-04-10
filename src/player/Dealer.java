package player;

import card.Deck;
import card.Hand;

public class Dealer extends Entity{

    public Dealer(Deck deck) {

        hand = new Hand(deck);

        System.out.println(hand);

        System.out.println(hand.getValue());

    }
}
