package sorter.console;

import sorter.sorters.DataSorter;
import sorter.sorters.LinesSorter;
import sorter.sorters.NumbersSorter;
import sorter.sorters.WordsSorter;

import java.util.List;

public class ConsoleInterface {

    public void open() {
        while (true) {
            String line = ConsoleInput.getLine();
            switch (InputRecognizer.recognize(line)) {
                case INSTRUCTIONS -> sort(line.split("\\s+"));
                case INCORRECT -> System.out.println("Incorrect input type. Type /help for more info");
                case HELP -> printHelpMessage();
                case EXIT -> {
                    return;
                }
            }
        }
    }

    private void sort(String[] dataType_sorTypePair) {
        DataSorter dataSorter = switch (dataType_sorTypePair[0]) {
            case "lines" -> new LinesSorter();
            case "words" -> new WordsSorter();
            case "numbers" -> new NumbersSorter();
            default -> null;
        };
        System.out.printf("Enter %s you want to sort and end your input by typing /end (line with /end will be omitted):%n", dataType_sorTypePair[0]);
        dataSorter.loadData(ConsoleInput.getDataToSort());
        List<String> sortedItems = switch (dataType_sorTypePair[1]) {
            case "ascending" -> dataSorter.sortAscending();
            case "descending" -> dataSorter.sortDescending();
            case "occurrences" -> dataSorter.sortByOccurrence();
            default -> null;
        };
        System.out.printf("Total %s: %d.%nSorted data:%n", dataType_sorTypePair[0], dataSorter.getLoadedItemsSize());
        sortedItems.forEach(System.out::println);
    }

    private void printHelpMessage() {
        System.out.println("""
                Correct input form: DATA_TYPE SORT_TYPE
                Available data types:
                - numbers
                - words
                - lines
                Available sort types:
                - ascending
                - descending
                - occurrences
                """);
    }
}
