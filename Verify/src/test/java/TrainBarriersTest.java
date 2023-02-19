import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class TrainBarriersTest {

    // mocked class instances store information about all method calls it has made

    @Mock PassengerRepository passengerRepository;
    @Mock EmailService emailService;
    @InjectMocks TrainBarriers trainBarriers;

    @Test
    public void passengerEntry() {
        final int PASSENGER_ID = 3;
        trainBarriers.passengerEntry(PASSENGER_ID);
        verify(passengerRepository).registerPassengerOnTrain(PASSENGER_ID);
        verify(emailService).notifyPassenger(PASSENGER_ID);
    }

}