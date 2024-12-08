package Exercise_1;

public class Main {
    public static void main(String[] args) {
        MessagePrinter helloWorldPrinter = new StringPrinter("Hello World");
        RepeatPrinter repeatPrinter = new RepeatPrinter(helloWorldPrinter);
        AsyncPrinter asyncPrinter = new AsyncPrinter(repeatPrinter);

        asyncPrinter.printAsync(10);
    }
}
