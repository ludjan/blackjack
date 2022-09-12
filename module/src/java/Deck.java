package module.src.java;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import module.src.java.Exceptions.InvalidCardFileContentException;
import module.src.java.Exceptions.OutOfCardsException;
import module.src.java.utils.DeckUtil;

public class Deck {

    public ArrayList<Card> cards;
    int pulledCards = 0;

    public Deck () {
        this.cards = DeckUtil.generateFullDeckAndShuffle();
    }

    /**
     * Constructor used for testing when generating controlled decks
     * @param cards
     */
    public Deck (ArrayList<Card> cards) {
        this.cards = cards;
    }

    public Deck (String filePath) throws InvalidCardFileContentException, FileNotFoundException {
        this.cards = createDeckFromFile(filePath);
    }

    public ArrayList<Card> createDeckFromFile(String filePath) throws InvalidCardFileContentException, FileNotFoundException {
        String fileContent = DeckReader.readFile(filePath);
        return DeckParser.getCardArrayListFromString(fileContent);
    }

    public Card pull() throws OutOfCardsException {
        if (cards.size() <= 0) {
            throw new OutOfCardsException(pulledCards);
        } 
        pulledCards++;
        return cards.remove(0);
    }
}
