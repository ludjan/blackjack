package module.src.java.utils;

import java.util.ArrayList;

import module.src.java.Card;
import module.src.java.CardSuit;
import module.src.java.CardValue;

public class DeckUtil {
    
    public static ArrayList<Card> generateFullDeckAndShuffle() {
        ArrayList<Card> localCards = generateFullDeck();
        return shuffleCards(localCards);
    }

    public static ArrayList<Card> generateFullDeck() {
        
        ArrayList<Card> localCards = new ArrayList<Card>();;

        for (CardSuit suit : CardSuit.values()) {
            for (CardValue value: CardValue.values()) {
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

}
