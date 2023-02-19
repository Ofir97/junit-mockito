import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class BookingServiceTest {

    @Mock private BookingRepository bookingRepository;
    @InjectMocks BookingService bookingService;

    @Test
    public void buyTicketTest() {
        BookingService bookingServiceSpy = spy(this.bookingService);
        bookingServiceSpy.buyTicket("ABC123");
        Mockito.verify(bookingServiceSpy).bookSeat(any(Ticket.class)); // must use on mock or spy
    }

    @Test
    public void bookSeatTest() {
        Ticket ticket = new Ticket("TICKET:ID_1");
        List<String> availableSeatsForShow = List.of("TICKET:ID_1", "TICKET:ID_2", "TICKET:ID_3");

        // anyString() - flexible (if method logic is changed)
        when(bookingRepository.getSeats(anyString())).thenReturn(availableSeatsForShow);
        assertTrue(bookingService.bookSeat(ticket));
    }

}