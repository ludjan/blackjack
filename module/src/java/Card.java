package module.src.java;
public class Card {
    
    public CardSuit suit;
    public CardValue value;
    
    public Card(CardSuit suit, CardValue value) {
        this.suit = suit;
        this.value = value;
    }

    public int getValue() {
        switch (value) {
            case TWO: 
                return 2;
            case THREE: 
                return 3;
            case FOUR: 
                return 4;
            case FIVE: 
                return 5;
            case SIX: 
                return 6;
            case SEVEN: 
                return 7;
            case EIGHT: 
                return 8;
            case NINE: 
                return 9;
            case TEN: 
                return 10;
            case JACK: 
                return 10;
            case QUEEN: 
                return 10;
            case KING: 
                return 10;
            case ACE: 
                return 11;
            default: return 0;
        }
    }

    public String toString() {
        return suit + "" + value;
    }

    public boolean equals(Card otherCard) {
        return suit == otherCard.suit && value.equals(otherCard.value);
    }
}
