package table;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class HitButton extends Button{

    GamePanel gp;

    StartButton sb;

    boolean playing = false;

    public boolean hittable = true;
    public HitButton(GamePanel gp, StartButton sb){

        solidAreaWidth = 50;
        solidAreaHeight = 50;
        this.gp = gp;
        this.sb = sb;
        solidArea = new Rectangle(370,368,solidAreaWidth,solidAreaHeight);
        getHitButtonImage();
    }

    public void getHitButtonImage() {
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/Hit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {

        if (gp.mouseH.startButtonClicked) {
            playing = true;
        }
        if(gp.player != null) {
            if (gp.player.hand.getValue() >= 21) {
                hittable = false;
                try {
                    buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/HitDisabled.png"));
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }

    public void draw(Graphics2D g2) {
        if(playing) {
            g2.drawImage(buttonImage, 370, 368, solidAreaWidth, solidAreaHeight, null);
        }
    }
}
