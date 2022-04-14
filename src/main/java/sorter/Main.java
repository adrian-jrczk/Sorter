package sorter;

import sorter.arguments.ArgumentsExecutor;
import sorter.console.ConsoleInterface;

public class Main {

    public static void main(String[] args) {
        if (args.length == 0) {
            new ConsoleInterface().open();
        } else {
            new ArgumentsExecutor().run(args);
        }
    }
}