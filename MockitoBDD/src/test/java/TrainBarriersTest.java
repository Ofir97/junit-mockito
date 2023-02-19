import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.BDDMockito.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.spy;

@ExtendWith(MockitoExtension.class)
public class TrainBarriersTest {

    private final static int PASSENGER_ID = 3829482;
    @Mock PassengerRepository passengerRepository;
    @Mock EmailService emailService;
    @InjectMocks TrainBarriers trainBarriers;

    @Test
    public void passengerEntryTest() throws Exception {
        // given: setup for test
        TrainBarriers trainBarriersSpy = spy(this.trainBarriers);
        given(trainBarriersSpy.passengerIsEligible(PASSENGER_ID))
                .willReturn(true);

        // when: method invocation
        trainBarriersSpy.passengerEntry(PASSENGER_ID);

        // then: what we expect
        then(passengerRepository)
                .should()
                .registerPassengerOnTrain(PASSENGER_ID);
        then(emailService)
                .should()
                .notifyPassenger(PASSENGER_ID);

    }

}