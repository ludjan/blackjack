import static org.junit.Assert.assertTrue;

import java.util.ArrayList;

import org.junit.Test;

import module.src.java.Card;
import module.src.java.DeckParser;
import module.src.java.CardSuit;
import module.src.java.CardValue;
import module.src.java.Exceptions.InvalidCardFileContentException;

public class TestDeckParser {
    
    @Test
    public void parseCard_validInput_returnsExpectedCard() throws InvalidCardFileContentException {

        Card parsedCard = DeckParser.parseCard("H5", 0);
        Card regularCard = new Card(CardSuit.H, CardValue.FIVE);

        assertTrue(parsedCard.equals(regularCard));
    }

    @Test(expected = InvalidCardFileContentException.class)
    public void parseCard_validButExtraComma_throwsException() throws InvalidCardFileContentException {
        DeckParser.parseCard("H5,", 0);
    }

    @Test (expected = InvalidCardFileContentException.class)
    public void parseCard_invalidSuit_throwsException() throws InvalidCardFileContentException {
        DeckParser.parseCard("G5", 0);
    }

    @Test (expected = InvalidCardFileContentException.class)
    public void parseCard_invalidValue_throwsException() throws InvalidCardFileContentException {
        DeckParser.parseCard("H11", 0);
    }

    @Test
    public void getCardArrayListFromString_validInput_returnsArrayList() throws InvalidCardFileContentException {
        
        String cardsString =  "CA, D5, H9, HQ, S8";
        ArrayList<Card> cards;
        Card expectedCard = new Card(CardSuit.D, CardValue.FIVE);
        Card actualCard;

        cards = DeckParser.getCardArrayListFromString(cardsString);
        actualCard = cards.get(1);
            
        assertTrue(actualCard.equals(expectedCard));
        
    }

    @Test (expected = InvalidCardFileContentException.class)
    public void getCardArrayListFromString_badInput_throwsException() throws InvalidCardFileContentException {
        DeckParser.getCardArrayListFromString("CA, D5, H9, HQ, S8.");
    }
}
