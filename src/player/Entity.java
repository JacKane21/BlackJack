package player;

import card.Hand;

import java.awt.*;

public class Entity {

    public Hand hand;

    public void hit(){
        hand.addCard();
    }


    public void update() {

    }

    public void draw(Graphics2D g2) {
            int handX = 200;
            for (int i = 0; i < hand.ciHand.size(); i++) {
                g2.drawImage(hand.ciHand.get(i).cardImage, handX, 200, 50, 78, null);
                handX += 50 + 10;
            }
        }
}

