import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class RaceReportProcessorTest {

    @Spy
    RaceReportProcessor reportProcessor;

    @Test
    public void generateReportDriverFileThrowsFileNotFound() throws Exception {
        String driverFile = "drivers/driver.csv";
        String raceFile = "racePerformance/race.csv";

        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> reportProcessor.generateReport(driverFile, raceFile));

        String expectedMessage = "driver.csv";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        verify(reportProcessor, never()).combineDriverAndRaceToReport(any(), any());
    }

    @Test
    public void generateReportRacePerformanceFileThrowsFileNotFound() {
        String driverFile = "drivers/drivers.csv";
        String raceFile = "racePerformance/races.csv";

        FileNotFoundException exception = assertThrows(FileNotFoundException.class,
                () -> reportProcessor.generateReport(driverFile, raceFile));

        String expectedMessage = "races.csv";
        String actualMessage = exception.getMessage();
        assertTrue(actualMessage.contains(expectedMessage));
        verify(reportProcessor, never()).combineDriverAndRaceToReport(any(), any());
    }

}