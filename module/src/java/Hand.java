package module.src.java;
import java.util.ArrayList;

public class Hand {
    
    public ArrayList<Card> cards = new ArrayList<Card>();

    public void addCard(Card c) {
        cards.add(c);
    }

    public int determineScore() {
        int score = 0;
        for (Card c : cards) {
            score += c.getValue();
        }
        return score;
    }

    public String toString() {
        String repr = "";
        for (Card c : cards) {
            repr += c + " ";
        }
        return repr;
    }
}
