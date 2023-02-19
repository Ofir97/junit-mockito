package spies;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class NewsletterSenderTest {

    @Test
    public void constructorAssignsDatabase() {
        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        SubscribersDatabase subscribersDatabase = new SubscribersDatabase();
        NewsletterSender newsletterSender = new NewsletterSender(subscribersDatabase, messagingEngine);

        assertEquals(subscribersDatabase, newsletterSender.getSubscribersDatabase());
    }

    @Test
    public void numberOfSubscribers() {
        SubscribersDatabase subscribersDatabase = mock(SubscribersDatabase.class);
        MessagingEngine messagingEngine = mock(MessagingEngine.class);
        NewsletterSender sender = new NewsletterSender(subscribersDatabase, messagingEngine);
        List<String> subscribersList = List.of("email1", "email2", "email3");

        when(subscribersDatabase.getSubscribers()).thenReturn(subscribersList);

        assertEquals(3, sender.numberOfSubscribers());
    }

    // Spy: when you require both the class logic & stub one or more of its methods

    @Test
    public void zeroSubscribersThrown() {
        NewsletterSender sender = spy(new NewsletterSender(new SubscribersDatabase(), new MessagingEngine()));

        when(sender.numberOfSubscribers()).thenReturn(0);

        assertThrows(ZeroSubscribersException.class, () -> sender.sendNewsletter("SUBJECT"));

    }
}