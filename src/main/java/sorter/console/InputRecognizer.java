package sorter.console;

import java.util.Arrays;

enum InputRecognizer {

    EMPTY("^$"),
    INSTRUCTIONS("(?i)(numbers|words|lines)\\s+(ascending|descending|occurrences)"),
    HELP("(?i)/\\s*help"),
    EXIT("(?i)/\\s*exit"),
    INCORRECT(".*");

    private final String PATTERN;

    InputRecognizer(String pattern) {
        this.PATTERN = pattern;
    }

    static InputRecognizer recognize(String line) {
        return Arrays.stream(InputRecognizer.values())
                .filter(x -> line.matches(x.PATTERN))
                .findFirst()
                .get();
    }
}
