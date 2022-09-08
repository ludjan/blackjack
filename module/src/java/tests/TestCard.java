import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.Suit;

public class TestCard {
    
    @Test
    public void valueOfNumberedCard_isItsNumber() {
        Card card = new Card(Suit.S, "5");
        assertEquals(5, card.getValue());
    }

    @Test
    public void valueOfQueen_isTen() {
        Card card = new Card(Suit.D, "Q");
        assertEquals(10, card.getValue());
    }

    @Test
    public void valueOfAce_isEleven() {
        Card card = new Card(Suit.H, "A");
        assertEquals(11, card.getValue());
    }

    @Test
    public void sameSuitSameValue_areEqual() {
        Card card = new Card(Suit.H, "A");
        Card otherCard = new Card(Suit.H, "A");
        assertTrue(card.equals(otherCard));
    }

    @Test
    public void sameSuitDifferentValue_areNotEqual() {
        Card card = new Card(Suit.H, "A");
        Card otherCard = new Card(Suit.H, "4");
        assertFalse(card.equals(otherCard));
    }
    @Test
    public void differentSuitSameValue_areNotEqual() {
        Card card = new Card(Suit.D, "3");
        Card otherCard = new Card(Suit.H, "3");
        assertFalse(card.equals(otherCard));
    }

    @Test
    public void differentSuitDifferentSuit_areNotEqual() {
        Card card = new Card(Suit.H, "A");
        Card otherCard = new Card(Suit.D, "4");
        assertFalse(card.equals(otherCard));
    }

    @Test
    public void stringFormat_isSuitValue() {
        Card card = new Card(Suit.C, "9");
        String cardRepr = card + "";
        assertEquals("C9", cardRepr);
    }
}
