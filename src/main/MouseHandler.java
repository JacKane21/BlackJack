package main;

import table.HitButton;
import table.StartButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    public boolean startButtonClicked;

    StartButton startButton;
    GamePanel gp;
    HitButton hitButton;

    public MouseHandler(GamePanel gp, StartButton startButton, HitButton hitButton) {
        this.gp = gp;
        this.startButton = startButton;
        this.hitButton = hitButton;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();

        if(startButton.solidArea != null) {
            if (startButton.solidArea.contains(point)) {
                System.out.println("Click");
                gp.started = true;
                startButtonClicked = true;
            }
        }

        if(hitButton.solidArea != null) {
            if (hitButton.hittable) {
                if (hitButton.solidArea.contains(point)) {
                    System.out.println("Hit");
                    gp.player.hit();
                    System.out.println(gp.player.hand.getValue());
                }
            }
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
