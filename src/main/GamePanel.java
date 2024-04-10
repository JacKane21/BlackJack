package main;

import card.Card;
import card.Deck;
import player.Dealer;
import player.Player;
import table.BlackJackTable;
import table.BlackJackTitle;
import table.StartButton;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public final int screenWidth = 960;
    public final int screenHeight = 540;

    public boolean started = false;
    public BlackJackTable bjTable = new BlackJackTable(this);
    Thread gameThread;
    public StartButton sb = new StartButton(this);
    public BlackJackTitle bjTitle = new BlackJackTitle(this);
    public MouseHandler mouseH = new MouseHandler(this,sb);
    Card card;
    Deck deck;
    Player player;
    Dealer dealer;


    public GamePanel() {

        setLayout(null);
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setFocusable(true);
        setDoubleBuffered(true);
        this.addMouseListener(mouseH);
    }



    public void startGameThread() {

        gameThread = new Thread(this);
        gameThread.start();

    }

    @Override
    public void run() {

        double drawInterval = 1000000000/60;
        double delta = 0;
        long lastTime = System.nanoTime();
        long curretTime;

        while(gameThread != null) {

            curretTime = System.nanoTime();

            delta += (curretTime - lastTime) / drawInterval;

            lastTime = curretTime;

            if(delta >= 1) {
                update();
                repaint();
                delta--;
            }

        }
    }

    public void setupGame() {
        if (started) {
            this.card = new Card();
            this.deck = new Deck(card);
            deck.shuffle();

            this.player = new Player(deck);
            this.dealer = new Dealer(deck);
        }
        started = false;
    }

    public void drawPlayer(Graphics2D g2) {
        if (player != null) {
            player.hand.draw(370, 320, g2);
        }
    }

    public void update() {

        sb.update();

        bjTitle.update();

        setupGame();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        bjTable.draw(g2);

        sb.draw(g2);

        bjTitle.draw(g2);

        drawPlayer(g2);

        g2.dispose();
    }

}

