import java.io.FileNotFoundException;

import org.junit.Test;

import module.src.java.DeckReader;

public class TestDeckReader {
    
    @Test (expected = FileNotFoundException.class)
    public void readFile_badFileInput_throwsFileNotFound () throws FileNotFoundException {
        DeckReader.readFile("badPath");
    }
    
    // Never got this test working :-()
    // @Test
    // public void readFile_goodFileInput_returnsContentString() throws FileNotFoundException {
    //     DeckReader.readFile("inputs/deck_in_assignment.txt");
    // }
}
