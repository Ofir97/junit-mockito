package mocks;

import java.util.ArrayList;
import java.util.List;

public class HotelDao {

    public List<String> fetchAvailableRooms() {
        List<String> availableRooms = new ArrayList<>();
        for (int i = 1; i < 50; i++) {
            availableRooms.add("Room number " + i);
        }
        return availableRooms;
    }
}
