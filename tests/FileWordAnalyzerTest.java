import com.codecool.filepartreader.FilePartReader;
import com.codecool.filepartreader.FileWordAnalyzer;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class FileWordAnalyzerTest {

    @Test
    public void testGetWordsOrderedAlphabetically() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/testWordAnalyzer.txt", 1, 1);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("me", "put", "they"));
        assertEquals(expected, fileWordAnalyzer.getWordsOrderedAlphabetically());
    }

    @Test
    public void testGetWordsContainingSubstring() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/testWordAnalyzer.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("they", "hey."));
        assertEquals(expected, fileWordAnalyzer.getWordsContainingSubstring("hey"));
    }

    @Test
    public void testGetStringsWhichPalindromes() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/testWordAnalyzer.txt", 1, 3);
        FileWordAnalyzer fileWordAnalyzer = new FileWordAnalyzer(filePartReader);

        ArrayList<String> expected = new ArrayList<String>(Arrays.asList("madam"));
        assertEquals(expected, fileWordAnalyzer.getStringsWhichPalindromes());
    }
}
