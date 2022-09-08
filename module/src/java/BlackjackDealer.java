package module.src.java;

import module.src.java.Exceptions.OutOfCardsException;

public class BlackjackDealer extends BlackjackPlayer {

    Deck deck;
    BlackjackPlayer opponent;

    public BlackjackDealer(String name, Deck deck, BlackjackPlayer opponent) {
        super(name);
        this.deck = deck;
        this.opponent = opponent;
    }

    public void dealTo(BlackjackPlayer target) throws OutOfCardsException {
        target.addCard(deck.pull());
    }

    @Override
    public boolean wantsMoreCards() {
        return (opponent.getScore() > getScore());
    }
}
