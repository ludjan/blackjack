import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.Exceptions.InvalidInputArgumentException;
import module.src.main.Main;

public class TestMain {

    @Test
    public void readFileName_noInput_returnsNull() throws InvalidInputArgumentException {
        String [] args = {};
        String fileName = Main.getFileName(args);
        assertTrue(fileName == null);
    }

    @Test (expected = InvalidInputArgumentException.class)
    public void readFileName_isNotTxt_doesNotReturn() throws InvalidInputArgumentException {
        String [] args = {"fileName"};
        Main.getFileName(args);
        
        // expect Exception thrown        
    }

    @Test
    public void readFileName_SingleInputWithoutPath_returnsFileName() throws InvalidInputArgumentException {
        String [] args = {"fileName.txt"};
        String fileName = Main.getFileName(args);
        assertTrue(fileName.equals("fileName.txt"));
    }

    @Test
    public void readFileName_SingleInputWithPath_returnsFileName() throws InvalidInputArgumentException {
        String [] args = {"src/firstFolder/secondFolder/fileName.txt"};
        String fileName = Main.getFileName(args);
        assertTrue(fileName.equals("src/firstFolder/secondFolder/fileName.txt"));
    }

    @Test (expected = InvalidInputArgumentException.class)
    public void readFileName_doubleInput_returnsNull() throws InvalidInputArgumentException {
        String [] args = {"firstFileName.txt", "secondFileName.txt"};
        Main.getFileName(args);

        // expect Exception thrown
    }
}
