package table;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class BlackJackTable extends Table{

    GamePanel gp;

    public BlackJackTable(GamePanel gp) {

        this.gp = gp;

        getBJTableImage();
    }

    public void getBJTableImage() {
        try {
            image = ImageIO.read(getClass().getResourceAsStream("/table/blackjacktable.png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void update() {

    }

    public void draw(Graphics2D g2) {

        g2.drawImage(image, screenX, screenY, gp.screenWidth, gp.screenHeight, null);
    }
}
