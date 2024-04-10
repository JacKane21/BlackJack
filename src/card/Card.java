package card;

public class Card {


    public String[] Suit = new String[]{"ace", "2", "3", "4", "5", "6", "7", "8", "9", "10", "jack", "queen", "king"};

    public String[] Faces = new String[]{"spades", "clubs", "diamonds", "hearts"};

    public String face, suit;

    public Card(String face, String suit) {

        this.face = face;
        this.suit = suit;

    }

    public Card() {

        this.face = "";
        this.suit = "";

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
        return suit + "_of_" + face;
    }

}
