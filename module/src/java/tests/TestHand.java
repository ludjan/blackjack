import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.Hand;
import module.src.java.Suit;

public class TestHand {

    @Test
    public void newHand_isEmpty() {
        Hand hand = new Hand();
        assertTrue(hand.cards.size() == 0);
    }

    @Test
    public void handWithAceAndJack_isWorth21() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.H, "A"));
        hand.addCard(new Card(Suit.S, "J"));
        assertEquals(21, hand.determineScore());
    }

    @Test
    public void handWithTwoAces_isWorth22() {
        Hand hand = new Hand();
        hand.addCard(new Card(Suit.H, "A"));
        hand.addCard(new Card(Suit.S, "A"));
        assertEquals(22, hand.determineScore());
    }
    
}
