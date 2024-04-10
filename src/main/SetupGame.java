package main;

import card.Card;
import card.Deck;
import player.Dealer;
import player.Player;

public class SetupGame {

    Card card;
    Deck deck;
    Player player;
    Dealer dealer;

    public SetupGame() {

        this.card = new Card();
        this.deck = new Deck(card);
        deck.shuffle();

        this.player = new Player(deck);
        this.dealer = new Dealer(deck);

        System.out.println(deck);
    }

}
