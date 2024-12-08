package Exercise_2;

public class Task7 {
    private final Number num1;
    private final Number num2;

    public Task7(int num1, int num2) {
        this.num1 = new Number(num1);
        this.num2 = new Number(num2);
    }

    public static void main(String[] args) {
        int num1 = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 8;
        int num2 = (args.length > 1 && args[1] != null) ? Integer.parseInt(args[1]) : 3;
        Task7 task7 = new Task7(num1, num2);

        int result = task7.compare();
        if (result >= 0) {
            System.out.println("Equivalence found at: " + result + ". place");
        } else {
            System.out.println("No equivalence found.");
        }
    }

    int compare() {
        String bin1 = this.num1.getBinary();
        String bin2 = this.num2.getBinary();

        System.out.println("Bin1: " + bin1);
        System.out.println("Bin2: " + bin2);

        int length = Math.min(bin1.length(), bin2.length());

        for (int i = 0; i < length; i++) {
            if (bin1.charAt(bin1.length() - i - 1) == bin2.charAt(bin2.length() - i - 1)) {
                return i;
            }
        }
        return -1;
    }
}

class Number {
    private final int number;

    public Number(int number) {
        this.number = number;
    }

    public String getBinary() {
        return Integer.toBinaryString(number);
    }
}

class Task7Test {
    public static void main(String[] args) {
        // Running all tests
        testCompareWhenNumbersAreEqual();
        testCompareWhenNoEquivalence();
        testCompareWithPartialMatch();
        testCompareWithEdgeCaseMinValues();
        testCompareWithDifferentLengthBinaries();
        testGetBinaryForPositiveNumber();
        testGetBinaryForZero();
        testGetBinaryForNegativeNumber();

        System.out.println("All tests passed.");
    }

    public static void testCompareWhenNumbersAreEqual() {
        Task7 task = new Task7(8, 8);  // Binary of 8 is 1000
        int result = task.compare();
        if (result != 0) {
            throw new AssertionError("Expected equivalence at index 0, but got " + result);
        }
        System.out.println("testCompareWhenNumbersAreEqual passed.");
    }

    public static void testCompareWhenNoEquivalence() {
        Task7 task = new Task7(8, 3);  // Binary of 8 is 1000, binary of 3 is 11
        int result = task.compare();
        if (result != -1) {
            throw new AssertionError("Expected no equivalence, but got " + result);
        }
        System.out.println("testCompareWhenNoEquivalence passed.");
    }

    public static void testCompareWithPartialMatch() {
        Task7 task = new Task7(10, 2);  // Binary of 10 is 1010, binary of 2 is 10
        int result = task.compare();
        if (result != 0) {
            throw new AssertionError("Expected equivalence at index 1, but got " + result);
        }
        System.out.println("testCompareWithPartialMatch passed.");
    }

    public static void testCompareWithEdgeCaseMinValues() {
        Task7 task = new Task7(0, 0);  // Binary of 0 is 0
        int result = task.compare();
        if (result != 0) {
            throw new AssertionError("Expected equivalence at index 0 for zero values, but got " + result);
        }
        System.out.println("testCompareWithEdgeCaseMinValues passed.");
    }

    public static void testCompareWithDifferentLengthBinaries() {
        Task7 task = new Task7(15, 2);  // Binary of 15 is 1111, binary of 2 is 10
        int result = task.compare();
        if (result != 1) {
            throw new AssertionError("Expected equivalence at index 1, but got " + result);
        }
        System.out.println("testCompareWithDifferentLengthBinaries passed.");
    }

    public static void testGetBinaryForPositiveNumber() {
        Number num = new Number(8);
        String binary = num.getBinary();
        if (!binary.equals("1000")) {
            throw new AssertionError("Binary of 8 should be 1000, but got " + binary);
        }
        System.out.println("testGetBinaryForPositiveNumber passed.");
    }

    public static void testGetBinaryForZero() {
        Number num = new Number(0);
        String binary = num.getBinary();
        if (!binary.equals("0")) {
            throw new AssertionError("Binary of 0 should be 0, but got " + binary);
        }
        System.out.println("testGetBinaryForZero passed.");
    }

    public static void testGetBinaryForNegativeNumber() {
        Number num = new Number(-1);
        String binary = num.getBinary();
        String expectedBinary = Integer.toBinaryString(-1);  // Default Java binary representation
        if (!binary.equals(expectedBinary)) {
            throw new AssertionError("Binary of -1 should be " + expectedBinary + ", but got " + binary);
        }
        System.out.println("testGetBinaryForNegativeNumber passed.");
    }
}