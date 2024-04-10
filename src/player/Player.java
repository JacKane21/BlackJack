package player;

import card.Deck;
import card.Hand;

public class Player extends Entity{

    public Player(Deck deck) {

        hand = new Hand(deck);

        System.out.println(hand);

        System.out.println(hand.getValue());
    }

}
