package sorter.sorters;

import java.util.*;

public class LinesSorter extends DataSorter {

    private final List<String> lines = new ArrayList<>();

    @Override
    public void loadData(String data) {
        Scanner scanner = new Scanner(data);
        try {
            while (scanner.hasNextLine()) {
                lines.add(scanner.nextLine());
            }
        } catch (NoSuchElementException ignore) {
        }
    }

    @Override
    public List<String> sortAscending() {
        return lines.stream()
                .sorted(Comparator.comparingInt(String::length))
                .toList();
    }

    @Override
    public List<String> sortDescending() {
        return lines.stream()
                .sorted((x, y) -> Integer.compare(y.length(), x.length()))
                .toList();
    }

    @Override
    public List<String> sortByOccurrence() {
        Map<String, Integer> occurrences = new HashMap<>();
        for (String line : lines) {
            if (occurrences.containsKey(line)) {
                continue;
            }
            occurrences.put(line, Collections.frequency(lines, line));
        }
        return occurrences
                .entrySet().stream()
                .sorted(Map.Entry.<String, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .map(x -> {
                    int percent = x.getValue() * 100 / lines.size();
                    return String.format("%d occ (%d%%) : %s", x.getValue(), percent, x.getKey());
                })
                .toList();
    }

    @Override
    public int getLoadedItemsSize() {
        return lines.size();
    }
}
