package module.src.java;

public enum Suit {
    
    H, S, D, C;

    public static Suit getSuitFromSymbol(String symbol) {
        switch(symbol) {
            case "H": return Suit.H;
            case "S": return Suit.S;
            case "D": return Suit.D;
            case "C": return Suit.C;
            default: return null;
        }
    }

    public static String getAvailableSuits() {
        String repr = "[";
        for (Suit s: Suit.values()) {
            repr += s + "|";
        }
        repr = repr.substring(0, repr.length()-1) + "]";
        return repr;
    }
}
