package main;

import table.HitButton;
import table.StandButton;
import table.StartButton;

import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MouseHandler implements MouseListener {

    StartButton stb;
    HitButton hb;
    StandButton sb;

    public MouseHandler(StartButton stb, HitButton hb, StandButton sb) {
        this.stb = stb;
        this.hb = hb;
        this.sb = sb;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();

        if(stb.solidArea.contains(point)) {
            stb.startGame();
            sb.setButton();
            hb.setButton();
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
