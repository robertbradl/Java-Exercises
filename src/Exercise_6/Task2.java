package Exercise_6;

import java.util.Stack;

public class Task2 {
    public static void main(String[] args) {
        String expression = "5 1 2 + 4 * + 3 -";

        try {
            int result = PostfixInterpreter.evaluatePostfix(expression);
            System.out.println("Result: " + result);
        }
        catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

class PostfixInterpreter{
    public static int evaluatePostfix(String expression) throws Exception {
        Stack<String> stack = new Stack<>();
        String[] tokens = expression.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) {
                stack.push(token); // Push numbers to the stack
            } else {
                // Pop operands for the operator
                if (stack.size() < 2) {
                    throw new Exception("Invalid postfix expression.");
                }

                int operand2 = Integer.parseInt(stack.pop());
                int operand1 = Integer.parseInt(stack.pop());

                int result = performOperation(operand1, operand2, token);
                stack.push(String.valueOf(result)); // Push result back to the stack
            }
        }

        // Final result should be the only element left in the stack
        if (stack.size() != 1) {
            throw new Exception("Invalid postfix expression.");
        }

        return Integer.parseInt(stack.pop());
    }

    private static boolean isNumeric(String str) {
        try {
            Integer.parseInt(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static int performOperation(int operand1, int operand2, String operator) throws Exception {
        return switch (operator) {
            case "+" -> operand1 + operand2;
            case "-" -> operand1 - operand2;
            case "*" -> operand1 * operand2;
            case "/" -> {
                if (operand2 == 0) {
                    throw new Exception("Division by zero.");
                }
                yield operand1 / operand2;
            }
            default -> throw new Exception("Unsupported operator: " + operator);
        };
    }
}