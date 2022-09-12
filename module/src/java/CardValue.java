package module.src.java;

public enum CardValue {
    
    TWO("2"), 
    THREE("3"), 
    FOUR("4"), 
    FIVE("5"), 
    SIX("6"), 
    SEVEN("7"), 
    EIGHT("8"), 
    NINE("9"), 
    TEN("10"), 
    JACK("J"), 
    QUEEN("Q"), 
    KING("K"), 
    ACE("A");

    String image;
    CardValue(String image) {
        this.image = image;
    }

    public static CardValue getValueFromSymbol(String symbol) {
        switch(symbol) {
            case "2": return CardValue.TWO;
            case "3": return CardValue.THREE;
            case "4": return CardValue.FOUR;
            case "5": return CardValue.FIVE;
            case "6": return CardValue.SIX;
            case "7": return CardValue.SEVEN;
            case "8": return CardValue.EIGHT;
            case "9": return CardValue.NINE;
            case "10": return CardValue.TEN;
            case "J": return CardValue.JACK;
            case "Q": return CardValue.QUEEN;
            case "K": return CardValue.KING;
            case "A": return CardValue.ACE;
            default: return null;
        }
    }

    public static String getAvailableValues() {
        String repr = "[";
        for (CardValue s: CardValue.values()) {
            repr += s + "|";
        }
        repr = repr.substring(0, repr.length()-1) + "]";
        return repr;
    }

    @Override
    public String toString() {
        return image;
    }

}
