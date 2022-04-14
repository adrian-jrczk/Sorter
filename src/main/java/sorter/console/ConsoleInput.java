package sorter.console;

import java.util.Scanner;

class ConsoleInput {

    private static final Scanner SCANNER = new Scanner(System.in);

    static String getLine() {
        System.out.print(" > ");
        return SCANNER.nextLine();
    }

    static String getDataToSort() {
        StringBuilder builder = new StringBuilder();
        while (true) {
            String line = SCANNER.nextLine();
            if (line.endsWith("/end")) {
                return builder.toString();
            }
            builder.append(line).append("\n");
        }
    }
}
