package sorter.arguments;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class SortTypeValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.toLowerCase().matches("ascending|descending|occurrences")) {
            throw new ParameterException("""
                    Sorting type not specified or invalid. Available types:
                    ascending
                    descending
                    occurrences
                    """);
        }
    }
}
