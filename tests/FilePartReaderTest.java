import com.codecool.filepartreader.FilePartReader;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.junit.jupiter.api.Assertions.*;

public class FilePartReaderTest {

    @Test
    public void testIsFromLineBelow1ThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("/test.txt", 0, 2);
        });
    }

    @Test
    public void testIsToLineBelowFromLineThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        assertThrows(IllegalArgumentException.class, ()-> {
            filePartReader.setup("/test.txt", 3, 2);
        });
    }

    @Test
    public void testReadLinesFirstLine() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 1);
        String excepted = "They put me in the oven to bake.";
        assertEquals(excepted, filePartReader.readLines());
    }

    @Test
    public void testReadLinesFirstTwoLine() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 2);
        String excepted = "They put me in the oven to bake.\n" +
                "Me, a deprived and miserable cake.";
        assertEquals(excepted, filePartReader.readLines());
    }

    @Test
    public void TestReadPartGiveBackException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("valami", 1, 3);
        assertEquals("File not found!", filePartReader.readLines());
    }

    @Test
    public void testRead() throws IOException {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("resources/test.txt", 1, 3);
        String excepted = "They put me in the oven to bake.\n" +
                "Me, a deprived and miserable cake.\n" +
                "Feeling the heat, I started to bubble.\n" +
                "Watching the others, I knew I was in trouble.\n" +
                "\n" +
                "madam  please\n" +
                "\n" +
                "Source: https://www.familyfriendpoems.com/poem/the-life-of-a-cupcake";
        assertEquals(excepted, filePartReader.read());
    }

    @Test
    public void testReadIfThrowsException() {
        FilePartReader filePartReader = new FilePartReader();
        filePartReader.setup("notFound", 1, 2);
        assertThrows(IOException.class, ()-> filePartReader.read());
    }
}
