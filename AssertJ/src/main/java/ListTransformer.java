import java.util.List;
import java.util.stream.Collectors;

public class ListTransformer {

    public List<Item> containsLetter(CharSequence letter, List<Item> items) {
        return items.stream()
                .filter(item -> item.getDescription().contains(letter))
                .collect(Collectors.toList());
    }

    public List<Item> containsLetterAndSort(CharSequence letter, List<Item> items) {
        return items.stream()
                .filter(item -> item.getDescription().contains(letter))
                .sorted()
                .collect(Collectors.toList());
    }
}
