package sorter.arguments;

import com.beust.jcommander.JCommander;
import sorter.sorters.DataSorter;
import sorter.sorters.LinesSorter;
import sorter.sorters.NumbersSorter;
import sorter.sorters.WordsSorter;
import sorter.utils.FileUtils;
import java.util.List;

public class ArgumentsExecutor {

    public void run(String[] args) {
        try {
            Arguments arguments = new Arguments();
            JCommander.newBuilder().addObject(arguments).build().parse(args);
            DataSorter dataSorter;
            switch (arguments.dataType) {
                case "lines" -> dataSorter = new LinesSorter();
                case "words" -> dataSorter = new WordsSorter();
                case "numbers" -> dataSorter = new NumbersSorter();
                default -> {
                    return;
                }
            }
            String data = FileUtils.loadData(arguments.inputFileName);
            dataSorter.loadData(data);
            List<String> sortedItems;
            switch (arguments.sortType) {
                case "ascending" -> sortedItems = dataSorter.sortAscending();
                case "descending" -> sortedItems = dataSorter.sortDescending();
                case "occurrences" -> sortedItems = dataSorter.sortByOccurrence();
                default -> {
                    return;
                }
            }
            FileUtils.saveResults(sortedItems, arguments, dataSorter.getLoadedItemsSize());
        } catch (Exception exception) {
            System.out.println(exception.getMessage());
        }
    }
}
