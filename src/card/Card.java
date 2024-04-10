package card;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class Card {


    public String[] Faces = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    public String[] Suit = new String[]{"spades", "clubs", "diamonds", "hearts"};

    public String face, suit;

    public BufferedImage cardImage;

    int cardWidth = 50;

    int cardHeight = 78;

    public Card(String suit, String face) {

        this.face = face;
        this.suit = suit;
        getCardImage();

    }

    public Card() {

        this.face = "";
        this.suit = "";
    }

    public void getCardImage() {
        try {
            cardImage = ImageIO.read(getClass().getResourceAsStream("/cards/"+toString() + ".png"));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public int getValue(Card card) {
        String face = card.face;
        switch (face) {
            case "1","2","3","4","5","6","7","8","9","10":
                return Integer.parseInt(face);
            case "jack","queen","king":
                return 10;
            case "ace":
                return 11;
        }
        return 0;
    }

    public String toString() {
        return face + "_of_" + suit;
    }

}
