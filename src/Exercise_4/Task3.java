package Exercise_4;

public class Task3 {
    public static void main(String[] args) {
        int num = 0;
        try {
            num = (args.length > 0 && args[0] != null) ? Integer.parseInt(args[0]) : 53146134;
        } catch (NumberFormatException e) {
            System.out.println("Please enter a valid integer!");
            System.exit(0);
        }

        if (num < 1) {
            System.out.println("Please enter a positive number!");
            System.exit(0);
        }
        int count = 0;
        while (num > 1) {
            count++;
            num = num / 10;
        }
        System.out.println(count);
    }
}
