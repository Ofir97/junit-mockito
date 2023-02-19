import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class) // enable the use of annotations with Mockito tests.
public class BookManagerTest {

    @Mock private BooksRepository booksRepository;
    @InjectMocks private BookManager bookManager;
    private Set<String> booksDatabaseSet;

    @BeforeEach
    public void setUp() {
        booksDatabaseSet = new HashSet<>();
        booksDatabaseSet.add("Harry Potter");
        booksDatabaseSet.add("Hunger Games");
    }

    @Test
    public void testGetBookInventoryCount() {
        when(booksRepository.getBooks()).thenAnswer(new GetBooks());
        assertEquals(2, bookManager.getBookInventoryCount());
    }

    @Test
    public void testAddBook() {
        String newBook = "Lord of the Rings";

        when(booksRepository.getBooks()).thenAnswer(new GetBooks());
        when(booksRepository.addBook(newBook)).thenAnswer(new AddBook());

        bookManager.addBook(newBook);
        assertEquals(3, bookManager.getBookInventoryCount());
    }


    class GetBooks implements Answer<Object> {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            return booksDatabaseSet;
        }
    }

    class AddBook implements Answer<Object> {
        @Override
        public Object answer(InvocationOnMock invocation) throws Throwable {
            String book = (String) invocation.getArguments()[0];
            booksDatabaseSet.add(book);
            return book;
        }
    }
}