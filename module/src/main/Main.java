package module.src.main;

import module.src.java.Blackjack;
import module.src.java.BlackjackDealer;
import module.src.java.Deck;
import module.src.java.BlackjackPlayer;
import module.src.java.utils.StringUtil;
import module.src.java.Playable;
import module.src.java.Exceptions.InvalidInputArgumentException;

public class Main {
    
    public static void main(String[] args) {
        
        String fileName; 
        Deck deck;
        BlackjackPlayer player;
        BlackjackDealer dealer;
        Playable game;
        
        try {

            fileName = getFileName(args);
            if (fileName == null) deck = new Deck();
            else deck = new Deck(fileName);

            player = new BlackjackPlayer("sam");
            dealer = new BlackjackDealer("dealer", deck, player);

            game = new Blackjack(player, dealer);
            
            game.play();
            
            System.out.println(game.getResultString());

        } catch(InvalidInputArgumentException e) {
            System.out.println(e);
            printRunExamples();
        }
        catch (Exception e) {
            System.out.println(e);
        }
    } 

    public static String getFileName(String [] args) throws InvalidInputArgumentException {
        if (args.length == 0) return null;
        if (args.length > 1) 
            throw new InvalidInputArgumentException("0 or 1 arguments", args.length + " arguments");

        String filename = args[0]; // there is exactly one argument input
        if (!StringUtil.endsWithSubstring(filename, ".txt")) {
            throw new InvalidInputArgumentException(".txt file", filename);
        }
        return filename;
    }

    public static void printRunExamples() {
        System.out.println("");
        System.out.println("Valid run examples:");
        System.out.println("java -jar finn-case.jar");
        System.out.println("java -jar finn-case.jar inputs/exampleFile.txt");
        System.out.println("");
    }
}