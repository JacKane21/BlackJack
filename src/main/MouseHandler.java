package main;

import player.Dealer;
import player.Player;
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
    Player player;
    Dealer dealer;

    public MouseHandler(StartButton stb, HitButton hb, StandButton sb, Player player, Dealer dealer) {
        this.stb = stb;
        this.hb = hb;
        this.sb = sb;
        this.player = player;
        this.dealer = dealer;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Point point = e.getPoint();

        if(stb.solidArea != null) {
            if (stb.solidArea.contains(point)) {
                System.out.println("Click");
                stb.startGame();
                sb.setButton();
                hb.setButton();
            }
        }

        if(hb.solidArea != null) {
            if (hb.solidArea.contains(point) && player.hand.getValue() <= 21) {
                System.out.println("Hit");
                player.hit();
                if(player.hand.getValue() >= 21) {
                    player.result(sb, hb, dealer);
                }
                if(player.hand.getValue() == 21){
                    player.result(sb, hb, dealer);
                }
            }
        }

        if(sb.solidArea != null) {
            if (sb.solidArea.contains(point) && !sb.disabled) {
                System.out.println("Stand");
                player.result(sb, hb, dealer);
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
