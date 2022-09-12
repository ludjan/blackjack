import static org.junit.Assert.assertEquals;

import java.util.ArrayList;

import org.junit.Test;

import module.src.java.Blackjack;
import module.src.java.BlackjackDealer;
import module.src.java.BlackjackPlayer;
import module.src.java.Card;
import module.src.java.Deck;
import module.src.java.Playable;
import module.src.java.CardSuit;
import module.src.java.CardValue;

public class TestOutput {

    @Test
    public void thereIsAWinner_resultStringIsFormattedCorrectly () {

        ArrayList<Card> cards = new ArrayList<Card>();
        cards.add(new Card(CardSuit.H, CardValue.TEN));
        cards.add(new Card(CardSuit.S, CardValue.ACE));
        cards.add(new Card(CardSuit.H, CardValue.ACE));
        cards.add(new Card(CardSuit.S, CardValue.TEN));
        Deck deck = new Deck(cards);

        BlackjackPlayer player = new BlackjackPlayer("sam");
        BlackjackDealer dealer = new BlackjackDealer("dealer", deck, player);

        Playable game = new Blackjack(player, dealer);

        try {
            game.play();
        } catch (Exception e) {

        }

        String expected = "";
        expected += "sam\n";
        expected += "sam: H10, HA\n";
        expected += "dealer: SA, S10";

        assertEquals(expected, game.getResultString());
    }
}