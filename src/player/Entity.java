package player;

import card.Deck;
import card.Hand;
import main.GamePanel;

import java.awt.*;

public class Entity {

    public Hand hand;

    public Deck deck;

    public GamePanel gp;

    public boolean handCreated = false;

    public void hit(){
        hand.addCard();
    }

    public void createHand() {
        hand = new Hand(deck);
    }

    public void update() {
        if(gp.stb.started && !handCreated) {
            createHand();
            handCreated = true;
        }
    }


    public void draw(Graphics2D g2) {
        if (hand != null) {
            int handX = 200;
            for (int i = 0; i < hand.ciHand.size(); i++) {
                g2.drawImage(hand.ciHand.get(i).cardImage, handX, 200, 50, 78, null);
                handX += 50 + 10;
            }
        }
    }
}

