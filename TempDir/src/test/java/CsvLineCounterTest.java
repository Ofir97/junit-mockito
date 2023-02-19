
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import org.junit.rules.TemporaryFolder;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

public class CsvLineCounterTest {

    @TempDir
    private Path tempDir;

    @Test
    public void countLines() throws IOException {
        Path path = tempDir.resolve("./file.txt");

        String csvData = "a,b,c\nd,e,f\ng";
        BufferedWriter bw = new BufferedWriter(new FileWriter(path.toFile()));
        bw.write(csvData);
        bw.close();

        long actualLines = CsvLineCounter.countLinesFromFile(path);
        assertEquals(3, actualLines);

    }
}