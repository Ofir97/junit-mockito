import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.InjectMocks;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class BookingManagerTest {

    // ArgumentCaptor: enables to extract Object passed into a method call

    @Spy BookingPersister bookingPersister;
    @InjectMocks BookingManager bookingManager;

    @Test
    public void addReservationTest() {
        ArgumentCaptor<Booking> capturedBooking = ArgumentCaptor.forClass(Booking.class);
        LocalDate reservationDate = LocalDate.of(2023, 2, 11);

        bookingManager.addReservation("John", 2, reservationDate);

        // capture() is used to obtain the argument passed into the method
        verify(bookingPersister).persistToDatabase(capturedBooking.capture());
        Booking capturedBookingValue = capturedBooking.getValue();

        assertEquals(capturedBookingValue.getTable().getName(), "John");
        assertEquals(capturedBookingValue.getTable().getNumber(), 2);
        assertEquals(capturedBookingValue.getTable().getTime(), reservationDate);
    }
}