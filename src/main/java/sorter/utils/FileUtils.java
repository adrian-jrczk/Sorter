package sorter.utils;

import sorter.arguments.Arguments;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class FileUtils {

    public static String loadData(String fileName) throws FileOperationException {
        try {
            return Files.readString(Path.of(fileName));
        } catch (Exception exception) {
            throw new FileOperationException("Could not load data from file: " + fileName);
        }
    }

    public static void saveResults(List<String> items, Arguments arguments, int loadedItemsSize) throws FileOperationException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(arguments.outputFileName))) {
            writer.write(String.format("Total %s: %d.\n", arguments.dataType, loadedItemsSize));
            writer.write("Sorted data:\n");
            for (String item : items) {
                writer.write(item + "\n");
            }
            writer.flush();
        } catch (Exception exception) {
            throw new FileOperationException("Could not save results to file: " + arguments.outputFileName);
        }
    }
}
