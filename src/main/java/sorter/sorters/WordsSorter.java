package sorter.sorters;

import java.util.*;

public class WordsSorter extends DataSorter {

    private final List<String> words = new ArrayList<>();

    @Override
    public void loadData(String data) {
        Scanner scanner = new Scanner(data);
        try {
            while (scanner.hasNext()) {
                words.add(scanner.next());
            }
        } catch (NoSuchElementException ignore) {
        }
    }

    @Override
    public List<String> sortAscending() {
        return words.stream()
                .sorted()
                .toList();
    }

    @Override
    public List<String> sortDescending() {
        return words.stream()
                .sorted(Comparator.reverseOrder())
                .toList();
    }

    @Override
    public List<String> sortByOccurrence() {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String word : words) {
            if (occurrences.containsKey(word)) {
                continue;
            }
            occurrences.put(word, Collections.frequency(words, word));
        }
        return occurrences
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(x -> x.getKey().length()))
                .map(x -> {
                    int percent = x.getValue() * 100 / words.size();
                    return String.format("%d occ (%d%%) : %s", x.getValue(), percent, x.getKey());
                })
                .toList();
    }

    @Override
    public int getLoadedItemsSize() {
        return words.size();
    }
}
