package sorter.arguments;

import com.beust.jcommander.IParameterValidator;
import com.beust.jcommander.ParameterException;

public class DataTypeValidator implements IParameterValidator {

    @Override
    public void validate(String name, String value) throws ParameterException {
        if (!value.toLowerCase().matches("numbers|words|lines")) {
            throw new ParameterException("Data type not specified or invalid. Available types: numbers, words, lines");
        }
    }
}
