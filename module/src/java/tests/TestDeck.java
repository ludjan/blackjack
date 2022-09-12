import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.ArrayList;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.Deck;
import module.src.java.CardSuit;
import module.src.java.CardValue;
import module.src.java.Exceptions.OutOfCardsException;
import module.src.java.utils.DeckUtil;

public class TestDeck {

    @Test
    public void generateFullDeck_returns52Cards() {
        assertEquals(52, DeckUtil.generateFullDeck().size());
    }

    @Test
    public void generateDeck_firstAndLastCard() {

        ArrayList<Card> cards = DeckUtil.generateFullDeck();

        Card firstCard = cards.get(0);
        Card lastCard = cards.get(51);

        assertEquals(CardSuit.H, firstCard.suit);
        assertEquals(CardValue.TWO, firstCard.value);
        
        assertEquals(CardSuit.C, lastCard.suit);
        assertEquals(CardValue.ACE, lastCard.value);
    }


    // We expect this to pass due to chances of shuffling a deck to it's original order is 8.0658175e+67
    @Test
    public void shuffleDeck_returnsAShuffledDeck() {

        // create a new deck, and get a shuffled copy
        ArrayList<Card> cards = DeckUtil.generateFullDeck();
        ArrayList<Card> shuffledCards = DeckUtil.shuffleCards(cards);

        // iterate and check for a difference in any of the places
        boolean cardsAreEqual = true;
        for (int i = 0; i < 52; i++) {
            cardsAreEqual = cards.get(i).equals(shuffledCards.get(i));
            if (!cardsAreEqual) break; // we can stop searching
        }
        assertFalse(cardsAreEqual);
    }

    @Test(expected = OutOfCardsException.class)
    public void pullingCardFromEmptyDeck_throwsOutOfCardsException() throws OutOfCardsException {
        Deck deck = new Deck();

        while(deck.cards.size() >= 0) {
            deck.pull();
        }
    }
}
