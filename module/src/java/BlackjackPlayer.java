package module.src.java;

public class BlackjackPlayer extends Player {
    
    public Hand hand = new Hand();

    public BlackjackPlayer(String name) {
        super(name);
    }

    public void addCard(Card c) {
        hand.addCard(c);
    }

    public boolean wantsMoreCards() {
        return getScore() < 17;
    }

    public boolean hasBlackjack() {
        return getScore() == 21;
    }

    @Override
    public int getScore() {
        return hand.determineScore();
    }

    @Override
    public String toString() {
        return name;
    }

}
