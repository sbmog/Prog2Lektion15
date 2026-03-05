package opgave04;

import opgave04.models.PostFixEvaluator;

public class Opgave04 {
    public static void main(String[] args) {
        PostFixEvaluator evaluator = new PostFixEvaluator();
        System.out.println(evaluator.evaluate("12 2 5 + - 4 * 2 /")); // 10
        System.out.println(evaluator.evaluate("3 4 + 2 * 7 /")); // 2
        System.out.println(evaluator.evaluate("5 1 2 + 4 * + 3 -")); // 14
    }
}
