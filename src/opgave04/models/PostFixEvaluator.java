package opgave04.models;

import java.util.Stack;

public class PostFixEvaluator {
    public int evaluate(String input) {
        Stack<Integer> stack = new Stack<>();
        String[] tokens = input.split("\\s+");

        for (String token : tokens) {
            if (isNumeric(token)) stack.push(Integer.parseInt(token));
            else if (isOperator(token)) {
                if (stack.size() < 2) throw new RuntimeException("Ugyldig postfixudtryk: for få operander");
                int b = stack.pop();
                int a = stack.pop();
                stack.push(applyOperator(a, b, token));
            } else throw new RuntimeException("Ugyldigt sympol i udtryk: " + token);
        }
        if (stack.size() != 1) throw new RuntimeException("Ugyldigt postfixudtryk: forkert antal operander");

        return stack.pop();
    }

    private Integer applyOperator(int a, int b, String token) {
        return switch (token) {
            case "+" -> a + b;
            case "-" -> a - b;
            case "*" -> a * b;
            case "/" -> {
                if (b == 0) throw new ArithmeticException("Division med nul");
                yield a / b;
            }
            default -> throw new RuntimeException("Ukendt operator: " + token);
        };
    }

    private boolean isOperator(String token) {
        return token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/");
    }

    private boolean isNumeric(String token) {
        return token.matches("-?\\d+");
    }
}
