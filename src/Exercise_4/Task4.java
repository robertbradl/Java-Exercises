package Exercise_4;

public class Task4 {
    public static void main(String[] args) {
        int i = 0;
        try {
            i = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 7;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer!");
            System.exit(0);
        }

        subA_alt(i);
        if (i % 2 == 1) {
            subB_alt(i);
            subC_alt(i);
        } else {
            subB(i + 1);
            subC(i + 1);
        }
    }

    public static void subA(int i) {
        System.out.println("Art section A:");
        for (int x = 1; x <= i; x++) {
            System.out.println("*".repeat(x));
        }
        System.out.println();
    }

    public static void subA_alt(int i) {
        System.out.println("Art section A:");
        int x = 0;
        do {
            x++;
            System.out.println("*".repeat(x));
        } while (x < i);
        System.out.println();
    }

    public static void subB(int i) {
        System.out.println("Art section B:");
        for (int x = 0; x < i / 2; x++)
            System.out.println(" ".repeat(i / 2 - x) + "*".repeat(2 * x + 1));
        for (int x = i / 2; x >= 0; x--)
            System.out.println(" ".repeat(i / 2 - x) + "*".repeat(2 * x + 1));
        System.out.println();
    }

    public static void subB_alt(int i) {
        System.out.println("Art section B:");
        int x = 0;
        do {
            System.out.println(" ".repeat(i / 2 - x) + "*".repeat(2 * x + 1));
            x++;
        } while (x < i / 2);
        x = i / 2;
        do {
            System.out.println(" ".repeat(i / 2 - x) + "*".repeat(2 * x + 1));
            x--;
        } while (x >= 0);
        System.out.println();
    }

    public static void subC(int i) {
        System.out.println("Art section C:");
        for (int x = 1; x < i; x++) {
            if (x == 1) System.out.println(" ".repeat(i - x) + "*");
            else System.out.println(" ".repeat(i - x) + "*" + " ".repeat(2 * x - 3) + "*");
        }
        System.out.println("*".repeat(i * 2 - 1));
    }

    public static void subC_alt(int i) {
        System.out.println("Art section C:");
        int x = 0;
        while (x < i - 1) {
            x++;
            if (x == 1) System.out.println(" ".repeat(i - x) + "*");
            else System.out.println(" ".repeat(i - x) + "*" + " ".repeat(2 * x - 3) + "*");
        }
        System.out.println("*".repeat(i * 2 - 1));
        System.out.println();
    }
}
