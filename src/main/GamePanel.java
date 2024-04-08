package main;

import table.TableManager;

import javax.swing.*;
import java.awt.*;

public class GamePanel extends JPanel {

    public final int screenWidth = 960;
    public final int screenHeight = 540;

    public GamePanel() {

        setLayout(null);
        setPreferredSize(new Dimension(screenWidth,screenHeight));
        setFocusable(true);
        setDoubleBuffered(true);
    }

    TableManager tableM = new TableManager(this);

    public void paintComponent(Graphics g) {

        super.paintComponent(g);

        Graphics2D g2 = (Graphics2D)g;

        tableM.draw(g2);

        g2.dispose();
    }

}

