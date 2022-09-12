package module.src.java;

public enum CardSuit {
    
    H, S, D, C;

    public static CardSuit getSuitFromSymbol(String symbol) {
        switch(symbol) {
            case "H": return CardSuit.H;
            case "S": return CardSuit.S;
            case "D": return CardSuit.D;
            case "C": return CardSuit.C;
            default: return null;
        }
    }

    public static String getAvailableSuits() {
        String repr = "[";
        for (CardSuit s: CardSuit.values()) {
            repr += s + "|";
        }
        repr = repr.substring(0, repr.length()-1) + "]";
        return repr;
    }
}
