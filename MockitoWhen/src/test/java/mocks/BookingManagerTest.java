package mocks;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class BookingManagerTest {

    private HotelDao hotelDao;
    private BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        hotelDao = mock(HotelDao.class);
        bookingManager = new BookingManager(hotelDao);
    }

    @Test
    public void checkRoomAvailabilityReturnTrue() {
        List<String> availableRooms = Arrays.asList("A", "B", "C");
        when(hotelDao.fetchAvailableRooms()).thenReturn(availableRooms);

        assertTrue(bookingManager.checkRoomAvailability("A"));
    }

    @Test
    public void checkRoomAvailabilityReturnFalse() {
        List<String> availableRooms = Arrays.asList("A", "B", "C");
        when(hotelDao.fetchAvailableRooms()).thenReturn(availableRooms);

        assertFalse(bookingManager.checkRoomAvailability("E"));
    }

}