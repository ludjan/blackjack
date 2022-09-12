package module.src.java;

import java.util.ArrayList;

import module.src.java.Exceptions.InvalidCardFileContentException;

public class DeckParser {

    public static ArrayList<Card> getCardArrayListFromString(String cardsString) throws InvalidCardFileContentException {

        ArrayList<Card> newCardList = new ArrayList<Card>();
        String [] cardStringArray = cardsString.split(",");

        for (int i = 0; i < cardStringArray.length; i++) {
            String cardElement = cardStringArray[i].trim();
            newCardList.add(parseCard(cardElement, i));
        }

        return newCardList;
    }

    public static Card parseCard(String cardElement, int i) throws InvalidCardFileContentException {

        // a card representation must be 2 or 3 chars long
        if (cardElement.length() < 2 || cardElement.length() > 3) {
            throw new InvalidCardFileContentException(
                "card representation" ,
                "between 2-3 symbols", 
                cardElement.length(),
                i
            );
        }

        // suit must be one of the defined symbols in enum
        String inputSuitSymbol = cardElement.substring(0, 1);
        CardSuit cardSuit = CardSuit.getSuitFromSymbol(inputSuitSymbol);
        if (cardSuit == null) {
            throw new InvalidCardFileContentException(
                "Suit", 
                CardSuit.getAvailableSuits(), 
                cardElement.charAt(0),
                i
            );
        }

        String cardValueString 
            = cardElement.substring(1, cardElement.length()); // we must take value 10 into account

        CardValue cardValue = CardValue.getValueFromSymbol(cardValueString);
        if (cardValue == null) {
            throw new InvalidCardFileContentException(
                "cardvalue", 
                CardValue.getAvailableValues(), 
                cardValueString,
                i
            );

        }

        return new Card(cardSuit, cardValue);
    }

}
