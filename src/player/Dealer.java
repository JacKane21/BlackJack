package player;

import card.Deck;
import main.GamePanel;

public class Dealer extends Entity{

    public Dealer(Deck deck, GamePanel gp) {

        this.gp = gp;

        this.deck = deck;
    }


}
