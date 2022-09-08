package module.src.java;

import module.src.java.Exceptions.OutOfCardsException;

public class Blackjack implements Playable {

    private BlackjackPlayer player;
    private BlackjackDealer dealer;
    private BlackjackPlayer winner = null;


    // Dealer should be subclass of dealer
    public Blackjack(Deck deck, BlackjackPlayer player) {
        this.player = player;
        this.dealer = new BlackjackDealer("dealer", deck, player);
    }

    @Override
    public void play() throws OutOfCardsException {

        dealStartingHand();
        if (winner == null) dealToPlayer(player);
        if (winner == null) dealToPlayer(dealer);
        if (winner == null) forceDetermineWinner();
    }

    private void dealStartingHand() throws OutOfCardsException {

        // each player is given two cards in order [player, dealer, player, dealer]
        dealer.dealTo(player);
        dealer.dealTo(dealer);
        dealer.dealTo(player);
        dealer.dealTo(dealer);
        checkStartingHandAndSetWinner();
    }

    // if player has 21, it wins.
    // if dealer has 21 when player has not, dealer wins    
    private void checkStartingHandAndSetWinner() {
        if (player.hasBlackjack()) {
            winner = player;
        } else if (player.hasLost()) {
            winner = dealer;
        }
    }

    private void dealToPlayer(BlackjackPlayer p) throws OutOfCardsException {
        while (p.wantsMoreCards()) {
            dealer.dealTo(p);
        }
        checkScoreSetOppositeWinner(p);
    }

    private void checkScoreSetOppositeWinner(BlackjackPlayer p) {
        if (p.hasLost())
            winner = getOpponent(p);
    }
    
    private BlackjackPlayer getOpponent(BlackjackPlayer p) {
        if (p == player) 
            return dealer;
        else 
            return player;
    }

    private void forceDetermineWinner() {
        if (player.getScore() > dealer.getScore()) 
            winner = player;
        else if (player.getScore() < dealer.getScore()) 
            winner = dealer;
        // score cannot be the same, since dealer pulls if they are equal
    }

    @Override
    public String getResultString() {
        String resultString = "";
        resultString += winner.name + "\n";
        resultString += player + "\n";
        resultString += dealer + "";
        return resultString;
    }
    
}