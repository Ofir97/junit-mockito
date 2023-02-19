package spies;

import java.util.ArrayList;
import java.util.List;

public class SubscribersDatabase {

    public List<String> getSubscribers() {

        // should fetch subscribers from db

        List<String> subscribers = new ArrayList<String>();

        for (int i = 1; i <= 50; i++) {
            subscribers.add("email" + i);
        }

        return subscribers;
    }
}
