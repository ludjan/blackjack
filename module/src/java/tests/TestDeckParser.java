import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.DeckParser;
import module.src.java.Suit;
import module.src.java.Exceptions.InvalidCardFileContentException;

public class TestDeckParser {
    
    @Test
    public void parseCard_validInput_returnsExpectedCard() throws InvalidCardFileContentException {

        Card parsedCard = DeckParser.parseCard("H5", 0);
        Card regularCard = new Card(Suit.H, "5");

        assertTrue(parsedCard.equals(regularCard));
    }

    @Test(expected = InvalidCardFileContentException.class)
    public void parseCard_validButExtraComma_throwsException() throws InvalidCardFileContentException {

        Card parsedCard = DeckParser.parseCard("H5,", 0);
    }

    @Test (expected = InvalidCardFileContentException.class)
    public void parseCard_invalidSuit_throwsException() throws InvalidCardFileContentException {

        Card parsedCard = DeckParser.parseCard("G5", 0);
    }

    @Test (expected = InvalidCardFileContentException.class)
    public void parseCard_invalidValue_throwsException() throws InvalidCardFileContentException {
        Card parsedCard = DeckParser.parseCard("H11", 0);
    }

    @Test
    public void getCardArrayListFromString_validInput_returnsArrayList() {
        String cardsString =  "CA, D5, H9, HQ, S8";
        try {
            ArrayList<Card> cards = DeckParser.getCardArrayListFromString(cardsString);
            
            Card actualCard = cards.get(1);
            Card expectedCard = new Card(Suit.D, "5");
            
            assertEquals(expectedCard.suit, actualCard.suit);
            assertEquals(expectedCard.getValue(), actualCard.getValue());
        } catch (Exception e) {
            assertTrue(false);
        }

    }

    @Test (expected = InvalidCardFileContentException.class)
    public void getCardArrayListFromString_badInput_throwsException() throws InvalidCardFileContentException {
        ArrayList<Card> cards = 
            DeckParser.getCardArrayListFromString("CA, D5, H9, HQ, S8.");

    }


}
