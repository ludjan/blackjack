package module.src.java;
import java.io.FileNotFoundException;
import java.util.ArrayList;

import module.src.java.Exceptions.InvalidCardFileContentException;
import module.src.java.Exceptions.OutOfCardsException;
import module.src.java.utils.CardUtil;

public class Deck {

    public ArrayList<Card> cards;
    int pulledCards = 0;

    public Deck () {
        this.cards = generateFullDeckAndShuffle();
    }

    public Deck (String filePath) throws InvalidCardFileContentException, FileNotFoundException {
        this.cards = createDeckFromFile(filePath);
    }

    public ArrayList<Card> generateFullDeckAndShuffle() {
        ArrayList<Card> localCards = generateFullDeck();
        return shuffleCards(localCards);
    }
    
    public static ArrayList<Card> generateFullDeck() {
        
        ArrayList<Card> localCards = new ArrayList<Card>();
        String [] values = CardUtil.getAllowedCardValues();

        for (Suit suit : Suit.values()) {
            for (String value: values) {
                localCards.add(new Card(suit, value));
            }
        }
        return localCards;
    }

    public static ArrayList<Card> shuffleCards(ArrayList<Card> localCards) {

        ArrayList<Card> localCardsCopy = new ArrayList<Card>(localCards);
        ArrayList<Card> shuffledCards = new ArrayList<Card>();

        while (localCardsCopy.size() > 0) {
            int maxNumber = localCardsCopy.size();
            int random = (int) (Math.random() * maxNumber);
            shuffledCards.add(localCardsCopy.remove(random));
        }
        return shuffledCards;
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
