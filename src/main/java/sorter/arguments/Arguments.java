package sorter.arguments;

import com.beust.jcommander.Parameter;

public class Arguments {

    @Parameter(names = {"--data-type", "-d"}, validateWith = DataTypeValidator.class)
    public String dataType = "numbers";

    @Parameter(names = {"--sort-type", "-s"}, validateWith = SortTypeValidator.class)
    public String sortType = "ascending";

    @Parameter(names = {"--input-file", "-i"}, required = true)
    public String inputFileName;

    @Parameter(names = {"--output-file", "-o"})
    public String outputFileName = "output.txt";
}
