package table;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class StartButton extends Button{

    GamePanel gp;

    public StartButton(GamePanel gp){

        solidAreaWidth = 200;
        solidAreaHeight = 100;
        this.gp = gp;
        solidArea = new Rectangle(gp.screenWidth/2 - solidAreaWidth/2 + 10,
                gp.screenHeight/2 - solidAreaHeight/2 + 90, solidAreaWidth, solidAreaHeight - 40);
        getStartButtonImage();
    }

    public void getStartButtonImage() {
        try {
            buttonImage = ImageIO.read(getClass().getResourceAsStream("/button/startbutton.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void startGame() {
        started = true;
        solidArea = null;
    }

    public void update() {
        if(started) {
            buttonImage = null;
        }
    }

    public void draw(Graphics2D g2) {
        g2.drawImage(buttonImage, gp.screenWidth/2 - solidAreaWidth/2 + 10,
                gp.screenHeight/2 - solidAreaHeight/2 + 80, solidAreaWidth, solidAreaHeight, null);
    }

}
