package table;

import main.GamePanel;

import javax.imageio.ImageIO;
import java.awt.*;
import java.io.IOException;

public class TableManager extends Table{

    public Table table;
    GamePanel gp;

    public TableManager(GamePanel gp) {
        table = new Table();
        this.gp = gp;
        this.screenWidth = gp.screenWidth;
        this.screenHeight = gp.screenHeight;
        prompt = "start";

        getTableImage();

    }

    public void getTableImage() {

        try {

            table.image = ImageIO.read(getClass().getResourceAsStream("/table/StarterTable.png"));

        } catch (IOException e) {

            throw new RuntimeException(e);
        }
    }

    public void promptImage() {

        try {


            switch (prompt) {
                case "start":
                    table.promptImage = ImageIO.read(getClass().getResourceAsStream("/table/BlackJackLabel.png"));
                    break;
            }

        } catch (IOException e){

            throw new RuntimeException(e);
        }

    }


    public void draw(Graphics2D g2) {

        g2.drawImage(table.image, screenX, screenY, screenWidth, screenHeight, null);
        g2.drawImage(table.promptImage, screenX + 500, screenY + 300, 200, 200, null);
    }

}
