import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.CardSuit;
import module.src.java.CardValue;

public class TestCard {
    
    @Test
    public void valueOfNumberedCard_isItsNumber() {
        Card card = new Card(CardSuit.S, CardValue.FIVE);
        assertEquals(5, card.getValue());
    }

    @Test
    public void valueOfQueen_isTen() {
        Card card = new Card(CardSuit.D, CardValue.QUEEN);
        assertEquals(10, card.getValue());
    }

    @Test
    public void valueOfAce_isEleven() {
        Card card = new Card(CardSuit.H, CardValue.ACE);
        assertEquals(11, card.getValue());
    }

    @Test
    public void sameSuitSameValue_areEqual() {
        Card card = new Card(CardSuit.H, CardValue.ACE);
        Card otherCard = new Card(CardSuit.H, CardValue.ACE);
        assertTrue(card.equals(otherCard));
    }

    @Test
    public void sameSuitDifferentValue_areNotEqual() {
        Card card = new Card(CardSuit.H, CardValue.ACE);
        Card otherCard = new Card(CardSuit.H, CardValue.FOUR);
        assertFalse(card.equals(otherCard));
    }
    @Test
    public void differentSuitSameValue_areNotEqual() {
        Card card = new Card(CardSuit.D, CardValue.THREE);
        Card otherCard = new Card(CardSuit.H, CardValue.THREE);
        assertFalse(card.equals(otherCard));
    }

    @Test
    public void differentSuitDifferentSuit_areNotEqual() {
        Card card = new Card(CardSuit.H, CardValue.ACE);
        Card otherCard = new Card(CardSuit.D, CardValue.FOUR);
        assertFalse(card.equals(otherCard));
    }

    @Test
    public void stringFormat_isSuitValue() {
        Card card = new Card(CardSuit.C, CardValue.NINE);
        String cardRepr = card + "";
        assertEquals("C9", cardRepr);
    }
}
