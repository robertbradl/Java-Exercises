package Exercise_1;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Interface for printing messages.
 * Classes that implement this interface should define how to print a message.
 */
interface MessagePrinter {
    /**
     * Prints a message.
     */
    void printMessage();
}

/**
 * Concrete implementation of the MessagePrinter interface.
 * This class prints a string passed to it.
 */
class StringPrinter implements MessagePrinter {
    private final String message;

    /**
     * Constructs a StringPrinter with a given message.
     *
     * @param message The message to be printed.
     */
    public StringPrinter(String message) {
        this.message = message;
    }

    /**
     * Prints the message to the console.
     */
    @Override
    public void printMessage() {
        System.out.println(message);
    }
}

/**
 * Class responsible for printing a message multiple times using recursion.
 */
class RepeatPrinter {
    private final MessagePrinter printer;

    /**
     * Constructs a RepeatPrinter with a given MessagePrinter.
     *
     * @param printer The MessagePrinter object responsible for printing the message.
     */
    public RepeatPrinter(MessagePrinter printer) {
        this.printer = printer;
    }

    /**
     * Recursively prints the message a specified number of times.
     *
     * @param times The number of times to print the message.
     */
    public void printTimes(int times) {
        if (times > 0) {
            printer.printMessage();
            printTimes(times - 1);
        }
    }
}

/**
 * Wrapper to allow asynchronous printing using multithreading.
 */
class AsyncPrinter {
    private final RepeatPrinter repeatPrinter;
    private final ExecutorService executor;

    /**
     * Constructs an AsyncPrinter with a given RepeatPrinter.
     *
     * @param repeatPrinter The RepeatPrinter object responsible for printing the message multiple times.
     */
    public AsyncPrinter(RepeatPrinter repeatPrinter) {
        this.repeatPrinter = repeatPrinter;
        this.executor = Executors.newFixedThreadPool(1);
    }

    /**
     * Prints the message asynchronously a specified number of times.
     *
     * @param times The number of times to print the message.
     */
    public void printAsync(int times) {
        // Submit the task to be executed by the thread pool asynchronously
        executor.submit(() -> repeatPrinter.printTimes(times));
        // Gracefully shut down the executor after the task is done
        executor.shutdown();
    }
}