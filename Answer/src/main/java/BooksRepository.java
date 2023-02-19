import java.util.HashSet;
import java.util.Set;

public class BooksRepository {

    public Set<String> getBooks(){
        System.out.println("fetching books from db");
        //connects to database and returns books
        return new HashSet<String>();
    }

    public String addBook(String book){

        //adds book to database
        return book;
    }
}
