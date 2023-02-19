import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Comparator;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
public class ListTransformerTest {

    @Spy
    private ListTransformer listTransformer;

    @Test
    public void containsLetterTest() {
        Item item1 = new Item(10, "raspberry");
        Item item2 = new Item(2, "banana");
        Item item3 = new Item(1, "apple");
        List<Item> items = List.of(item1, item2, item3);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.containsLetter(cs, items);
        List<Item> expectedItems = List.of(item1, item2);

        assertThat(itemsWithB).isNotNull();
        assertThat(itemsWithB.size()).isEqualTo(2);
        assertThat(itemsWithB).hasSameElementsAs(expectedItems);
    }

    @Test
    public void containsLetterAndSortTest() {
        Item item1 = new Item(10, "raspberry");
        Item item2 = new Item(2, "banana");
        Item item3 = new Item(1, "apple");
        List<Item> items = List.of(item1, item2, item3);

        CharSequence cs = "b";
        List<Item> itemsWithB = listTransformer.containsLetterAndSort(cs, items);
        List<Item> expectedItems = List.of(item2, item1);

        Comparator<Item> comparator = Comparator.comparing(Item::getDescription);

        assertThat(itemsWithB).isNotNull();
        assertThat(itemsWithB.size()).isEqualTo(2);
        assertThat(itemsWithB).hasSameElementsAs(expectedItems);
        assertThat(itemsWithB).isSortedAccordingTo(comparator);
        assertThat(itemsWithB).containsExactlyElementsOf(expectedItems);
    }
}