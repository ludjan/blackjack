import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.Hand;
import module.src.java.CardSuit;
import module.src.java.CardValue;

public class TestHand {

    @Test
    public void newHand_isEmpty() {
        Hand hand = new Hand();
        assertTrue(hand.cards.size() == 0);
    }

    @Test
    public void handWithAceAndJack_isWorth21() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardSuit.H, CardValue.ACE));
        hand.addCard(new Card(CardSuit.S, CardValue.JACK));
        assertEquals(21, hand.determineScore());
    }

    @Test
    public void handWithTwoAces_isWorth22() {
        Hand hand = new Hand();
        hand.addCard(new Card(CardSuit.H, CardValue.ACE));
        hand.addCard(new Card(CardSuit.S, CardValue.ACE));
        assertEquals(22, hand.determineScore());
    }
    
}
