package main;

import card.Card;
import card.Deck;
import player.Dealer;
import player.Player;
import table.*;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public final int screenWidth = 960;
    public final int screenHeight = 540;

    public BlackJackTable bjTable = new BlackJackTable(this);
    Thread gameThread;
    public StartButton stb = new StartButton(this);
    public BlackJackTitle bjTitle = new BlackJackTitle(this);
    public HitButton hb = new HitButton();
    public StandButton sb = new StandButton();
    public MouseHandler mouseH = new MouseHandler(stb, hb, sb);
    public Card card;
    public Deck deck;
    public Player player;
    public Dealer dealer;


    public GamePanel() {

        setLayout(null);
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setFocusable(true);
        setDoubleBuffered(true);
        this.addMouseListener(mouseH);
        setupGame();
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

            this.card = new Card();
            this.deck = new Deck(card);
            deck.shuffle();

            this.player = new Player(deck, this);
            this.dealer = new Dealer(deck, this);
        }

    public void update() {

        player.update();

        sb.update();

        bjTitle.update();

        stb.update();

        hb.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        bjTable.draw(g2);

        stb.draw(g2);

        bjTitle.draw(g2);

        hb.draw(g2);

        sb.draw(g2);

        player.draw(g2);

        g2.dispose();
    }

}

