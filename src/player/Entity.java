package player;

import card.Deck;
import card.Hand;
import main.GamePanel;
import table.HitButton;
import table.StandButton;

import java.awt.*;

public class Entity {

    public Hand hand;

    public Deck deck;

    public GamePanel gp;

    public boolean handCreated = false;

    public void hit(){
        hand.addCard();
    }

    public void checkVS(Entity other) {
        if(this.hand.getValue() > 21 || other.hand.getValue() > this.hand.getValue() && other.hand.getValue() <= 21){
            System.out.println("Dealer Wins");
        }
         else if(this.hand.getValue() > other.hand.getValue() || other.hand.getValue() > 21){
            System.out.println("Player Wins");
        }
    }

    public void finishHand(){
        while (hand.getValue() < 17) {
            hit();
        }
    }

    public void result(StandButton sb, HitButton hb, Entity other){
        sb.setDisabled();
        hb.setDisabled();
        other.finishHand();
        System.out.println("player: " + hand.getValue());
        System.out.println("dealer: " + other.hand.getValue());
        this.checkVS(other);
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


    public void draw(Graphics2D g2, int x, int y) {
        if (hand != null) {
            int handX = x;
            for (int i = 0; i < hand.ciHand.size(); i++) {
                g2.drawImage(hand.ciHand.get(i).cardImage, handX, y, 50, 78, null);
                handX += 50 + 10;
            }
        }
    }
}

