package player;

import card.Deck;
import main.GamePanel;

public class Player extends Entity{

    public Player(Deck deck, GamePanel gp) {

        this.gp = gp;

        this.deck = deck;
    }

}
