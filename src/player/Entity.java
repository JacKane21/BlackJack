package player;

import card.Hand;

public class Entity {

    public Hand hand;

    public void hit(){
        hand.addCard();
    }

}
