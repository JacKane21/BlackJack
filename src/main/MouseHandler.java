package main;

import table.StartButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public boolean startButtonClicked;

    StartButton startButton;
    GamePanel gp;

    public MouseHandler(GamePanel gp, StartButton startButton) {
        this.gp = gp;
        this.startButton = startButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();

        if(startButton.solidArea.contains(point)) {
            System.out.println("Click");
            startButtonClicked = true;
        }


    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }
}
