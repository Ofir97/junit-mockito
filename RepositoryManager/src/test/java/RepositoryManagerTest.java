import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class RepositoryManagerTest {

    @Test
    public void getAllStudents() {
        EntityManager emMocked = mock(EntityManager.class);
        RepositoryManager repositoryManager = new RepositoryManager(emMocked);
        Query mockedQuery = mock(Query.class);

        Student student1 = new Student(1, "Parker");
        Student student2 = new Student(2, "Mary");
        Student student3 = new Student(3, "Ben");
        List<Student> studentList = Arrays.asList(student1, student2, student3);

        when(mockedQuery.getResultList()).thenReturn(studentList);
        when(emMocked.createNamedQuery(RepositoryManager.GET_ALL_STUDENTS)).thenReturn(mockedQuery);

        List<Student> actualStudents = repositoryManager.getAllStudents();
        assertEquals(studentList, actualStudents);
    }

}