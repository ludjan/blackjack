package module.src.java;
public class Card {
    
    public Suit suit;
    public String valueString;
    
    public Card(Suit suit, String valueString) {
        this.suit = suit;
        this.valueString = valueString;
    }

    public int getValue() {
        switch (valueString) {
            case "A": return 11;
            case "K": return 10;
            case "Q": return 10;
            case "J": return 10;
            default: return Integer.parseInt(valueString);
        }
    }

    public String toString() {
        return suit + valueString;
    }

    public boolean equals(Card otherCard) {
        return suit == otherCard.suit && valueString.equals(otherCard.valueString);
    }
}
