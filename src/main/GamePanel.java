package main;

import table.BlackJackTable;
import table.StartButton;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel implements Runnable{

    public final int screenWidth = 960;
    public final int screenHeight = 540;

    public BlackJackTable bjTable = new BlackJackTable(this);
    Thread gameThread;
    public StartButton sb = new StartButton(this);
    public MouseHandler mouseH = new MouseHandler(this,sb);


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

    public void update() {

        sb.update();
    }

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        bjTable.draw(g2);

        sb.draw(g2);

        g2.dispose();
    }

}

