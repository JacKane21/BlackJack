package table;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StandButton extends Button{


    public boolean disabled = false;

    public StandButton(){

        solidAreaWidth = 50;
        solidAreaHeight = 45;
        solidArea = new Rectangle(430,371,solidAreaWidth,solidAreaHeight);
    }

    public void getHitButtonImage() {
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/StandButton.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setButton() {
        setStandButton = true;
    }

    public void setDisabled() {
        disabled = true;
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/StandDisabled.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if(setStandButton && !disabled) {
            getHitButtonImage();
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(buttonImage, 430, 371, solidAreaWidth, solidAreaHeight, null);
    }
}
