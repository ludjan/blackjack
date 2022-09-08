import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import module.src.java.utils.StringUtil;

public class TestStringHelper {
    @Test
    public void endsWithSubstring_expectedInput_returnsTrue() {
        boolean result = StringUtil.endsWithSubstring("example.txt", ".txt");
        assertTrue(result);
    }
    
    @Test
    public void endsWithSubstring_emptySubstring_returnsTrue() {
        boolean result = StringUtil.endsWithSubstring("example.txt", "");
        assertTrue(result);
    }

    @Test
    public void endsWithSubstring_tooLongSubstring_returnsFalse() {
        boolean result = StringUtil.endsWithSubstring("example.txt", "asdasdexample.txt");
        assertFalse(result);
    }

    @Test
    public void endsWithSubstring_emptyString_returnsFalse() {
        boolean result = StringUtil.endsWithSubstring("", "hexample.txt");
        assertFalse(result);
    }

}
