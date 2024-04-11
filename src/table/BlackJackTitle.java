package table;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BlackJackTitle extends Title{

    GamePanel gp;
    int titleWidth;
    int titleHeight;

    public BlackJackTitle(GamePanel gp) {

        this.gp = gp;
        getBJTitleImage();
        titleWidth = 300;
        titleHeight = 300;

    }

    public void getBJTitleImage() {

        try {
            titleImage = ImageIO.read(getClass().getResourceAsStream("/title/blackjacktitle.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {
        if(gp.stb.started) {
            titleImage = null;
        }
    }

    public void draw(Graphics2D g2) {

        g2.drawImage(titleImage, gp.screenWidth/2 - titleWidth/2 - 10, gp.screenHeight/2 - titleHeight/2 - 40,
                titleWidth, titleHeight, null);
    }
}
