import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import module.src.java.Blackjack;
import module.src.java.BlackjackDealer;
import module.src.java.BlackjackPlayer;
import module.src.java.Card;
import module.src.java.Deck;
import module.src.java.DeckParser;
import module.src.java.Exceptions.OutOfCardsException;

public class TestBlackjack {
    
    @Test
    public void play_bothPlayersGet22_dealerWins() throws Exception {
        ArrayList<Card> cards = DeckParser.getCardArrayListFromString("HA, DA, SA, CA");
        Deck deck = new Deck(cards);
        BlackjackPlayer player = new BlackjackPlayer("player");
        BlackjackDealer dealer = new BlackjackDealer("dealer", deck, player);
        Blackjack game = new Blackjack(player, dealer);
        
        game.play();
    
        assertEquals(dealer, game.getWinner());
    }

    @Test
    public void play_bothPlayersGet21_playerWins() throws Exception {
        ArrayList<Card> cards = DeckParser.getCardArrayListFromString("HA, DA, SK, CK");
        Deck deck = new Deck(cards);
        BlackjackPlayer player = new BlackjackPlayer("player");
        BlackjackDealer dealer = new BlackjackDealer("dealer", deck, player);
        Blackjack game = new Blackjack(player, dealer);
        
        game.play();
    
        assertEquals(player, game.getWinner());
    }

    @Test (expected = OutOfCardsException.class)
    public void play_playingWithTooSmallDeck_throwsOutOfCardsException() throws Exception {
        ArrayList<Card> cards = DeckParser.getCardArrayListFromString("HA");
        Deck deck = new Deck(cards);
        BlackjackPlayer player = new BlackjackPlayer("player");
        BlackjackDealer dealer = new BlackjackDealer("dealer", deck, player);
        Blackjack game = new Blackjack(player, dealer);
        
        game.play();
    
        // should throw OutOfCardsException
    }
}
