import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import org.junit.Test;

import module.src.java.Suit;

public class TestSuit {
    
    @Test 
    public void getSuitFromSymbol_getHSDC_returnTrue() {
        Suit hearts = Suit.getSuitFromSymbol("H");
        Suit spades = Suit.getSuitFromSymbol("S");
        Suit diamonds = Suit.getSuitFromSymbol("D");
        Suit clubs = Suit.getSuitFromSymbol("C");

        assertEquals(Suit.H, hearts);
        assertEquals(Suit.S, spades);
        assertEquals(Suit.D, diamonds);
        assertEquals(Suit.C, clubs);
    }

    @Test 
    public void getSuitFromSymbol_InvalidInput_returnsFalse() {
        Suit y = Suit.getSuitFromSymbol("y");
        Suit l = Suit.getSuitFromSymbol("L");
        Suit a = Suit.getSuitFromSymbol("A");
        Suit r = Suit.getSuitFromSymbol("r");

        assertNull(y);
        assertNull(l);
        assertNull(a);
        assertNull(r);
    }
}
