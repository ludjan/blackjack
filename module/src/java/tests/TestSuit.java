import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import module.src.java.CardSuit;

public class TestSuit {
    
    @Test 
    public void getSuitFromSymbol_getHSDC_returnTrue() {
        CardSuit hearts = CardSuit.getSuitFromSymbol("H");
        CardSuit spades = CardSuit.getSuitFromSymbol("S");
        CardSuit diamonds = CardSuit.getSuitFromSymbol("D");
        CardSuit clubs = CardSuit.getSuitFromSymbol("C");

        assertEquals(CardSuit.H, hearts);
        assertEquals(CardSuit.S, spades);
        assertEquals(CardSuit.D, diamonds);
        assertEquals(CardSuit.C, clubs);
    }

    @Test 
    public void getSuitFromSymbol_InvalidInput_returnsFalse() {
        CardSuit y = CardSuit.getSuitFromSymbol("y");
        CardSuit l = CardSuit.getSuitFromSymbol("L");
        CardSuit a = CardSuit.getSuitFromSymbol("A");
        CardSuit r = CardSuit.getSuitFromSymbol("r");

        assertNull(y);
        assertNull(l);
        assertNull(a);
        assertNull(r);
    }
}
