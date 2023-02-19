
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Answers;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import static org.mockito.Mockito.*;

public class AnimalTest {

    // annotated mock uses 'answer' key-value pair to change default behavior
    @Mock(answer = Answers.RETURNS_DEFAULTS)
    Animal animal;

    @Test
    public void testAnimal() {
        System.out.println("--- Returns Defaults ---");
        Animal lion = mock(Animal.class);
        System.out.println(lion.age);
        System.out.println(lion.getZooKeeper());

        Animal lion2 = mock(Animal.class, RETURNS_DEFAULTS); // default behavior
        System.out.println(lion2.getZooKeeper());
        System.out.println(lion2.age);

        System.out.println("--- Returns Smart Nulls ---");
        Animal lion3 = mock(Animal.class, RETURNS_SMART_NULLS); // checks for possible null values because of not stubbing
        when(lion3.getZooKeeper()).thenReturn(new ZooKeeper("John"));
        System.out.println(lion3.getZooKeeper());
        System.out.println(lion3.getZooKeeper().getName());

        System.out.println("--- Returns Mock ---"); // replaces objects with mocked instances to avoid a possible NPE
        Animal lion4 = mock(Animal.class, RETURNS_MOCKS);
        System.out.println(lion4.age);
        System.out.println(lion4.getZooKeeper());
        when(lion4.getZooKeeper().getName()).thenReturn("John");
        System.out.println(lion4.getZooKeeper().getName()); // not printing anything because calling a method on mocked ZooKeeper

        System.out.println("--- Returns Deep Stubs ---");
        Animal lion5 = mock(Animal.class, RETURNS_DEEP_STUBS);
        when(lion5.getZooKeeper().getName()).thenReturn("Steve");
        System.out.println(lion5.getZooKeeper().getName()); // Steve is printed.
    }

}