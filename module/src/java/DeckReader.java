package module.src.java;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class DeckReader {

    String filePath;
    String content = "";

    public static String readFile(String filePath) throws FileNotFoundException {
    
        String content = "";
        Scanner scanner = null;
        
        scanner = new Scanner(new File(filePath));

        while (scanner.hasNext()) {
            content += scanner.next();
        }
        scanner.close();
        
        return content;
    }
}
