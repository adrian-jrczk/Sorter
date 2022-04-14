package sorter.sorters;

import java.util.*;

public class NumbersSorter extends DataSorter {

    private final List<Double> numbers = new ArrayList<>();

    @Override
    public void loadData(String data) {
        Scanner scanner = new Scanner(data);
        try {
            while (scanner.hasNext()) {
                String item = scanner.next();
                try {
                    numbers.add(Double.parseDouble(item));
                } catch (NumberFormatException exception) {
                    System.out.printf("%s is not a number. It will be skipped.\n", item);
                }
            }
        } catch (NoSuchElementException ignore) {
        }
    }

    @Override
    public List<String> sortAscending() {
        return numbers.stream()
                .sorted()
                .map(String::valueOf)
                .toList();
    }

    @Override
    public List<String> sortDescending() {
        return numbers.stream()
                .sorted(Comparator.reverseOrder())
                .map(String::valueOf)
                .toList();
    }

    @Override
    public List<String> sortByOccurrence() {
        Map<Double, Integer> occurrences = new HashMap<>();
        for (Double number : numbers) {
            if (occurrences.containsKey(number)) {
                continue;
            }
            occurrences.put(number, Collections.frequency(numbers, number));
        }
        return occurrences
                .entrySet().stream()
                .sorted(Map.Entry.<Double, Integer>comparingByValue().reversed().thenComparing(Map.Entry::getKey))
                .map(x -> {
                    int percent = x.getValue() * 100 / numbers.size();
                    return String.format("%d occ (%d%%) : %s", x.getValue(), percent, x.getKey());
                })
                .toList();
    }

    @Override
    public int getLoadedItemsSize() {
        return numbers.size();
    }
}
