package Exercise_6;

public class Task3 {
    public static void main(String[] args) {
        // Create complex numbers
        ComplexNumber z1 = new ComplexNumber(3, 4);
        ComplexNumber z2 = new ComplexNumber(1, -2);

        // Test addition
        ComplexNumber sum = ComplexNumber.add(z1, z2);
        System.out.println("z1: " + z1);
        System.out.println("z2: " + z2);
        System.out.println("Sum: " + sum);

        // Test square root calculation
        double positiveNumber = 9;
        double negativeNumber = -16;

        ComplexNumber sqrtPositive = ComplexNumber.sqrt(positiveNumber);
        ComplexNumber sqrtNegative = ComplexNumber.sqrt(negativeNumber);

        System.out.println("Square root of " + positiveNumber + ": " + sqrtPositive);
        System.out.println("Square root of " + negativeNumber + ": " + sqrtNegative);
    }
}

/**
 * @param real      Real part
 * @param imaginary Imaginary part
 */
record ComplexNumber(double real, double imaginary) {

    // Method to output the complex number as a string
    @Override
    public String toString() {
        if (imaginary >= 0) {
            return real + " + " + imaginary + "i";
        } else {
            return real + " - " + (-imaginary) + "i";
        }
    }

    // Method to add two complex numbers
    public static ComplexNumber add(ComplexNumber z1, ComplexNumber z2) {
        double realPart = z1.real() + z2.real();
        double imaginaryPart = z1.imaginary() + z2.imaginary();
        return new ComplexNumber(realPart, imaginaryPart);
    }

    // Method to calculate the square root (sqrt) of a number (including for negative numbers)
    public static ComplexNumber sqrt(double x) {
        if (x >= 0) {
            return new ComplexNumber(Math.sqrt(x), 0);
        } else {
            return new ComplexNumber(0, Math.sqrt(-x));
        }
    }
}