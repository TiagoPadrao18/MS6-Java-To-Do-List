package src;

public class Logger {

    public void log(String log) {
        System.out.printf("\u001B[38;5;15m%s \u001B[0m%n", log);
    }

    public void warning(String log) {System.out.printf("\n\u001b[33;1m%s \u001B[0m%n", log);}
    public void error(String log) {
        System.out.printf("\n\u001B[31;1m%s \u001B[0m%n", log);
    }
    public void logInsert(String log) {
        System.out.printf("\n\u001b[38;5;15m%s \u001b[0m", log);
    }
}
