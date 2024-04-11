package table;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class HitButton extends Button{


    public HitButton(){

        solidAreaWidth = 50;
        solidAreaHeight = 50;
        solidArea = new Rectangle(370,368,solidAreaWidth,solidAreaHeight);
    }

    public void getHitButtonImage() {
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/Hit.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setDisabled() {
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/HitDisabled.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void setButton() {
        setHitButton = true;
    }

    public void update() {
        if(setHitButton) {
            getHitButtonImage();
        }
    }


    public void draw(Graphics2D g2) {

        g2.drawImage(buttonImage, 370, 368, solidAreaWidth, solidAreaHeight, null);
    }
}
