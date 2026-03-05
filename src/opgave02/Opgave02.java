package opgave02;

import java.util.ArrayList;
import java.util.Stack;

public class Opgave02 {
    public static void main(String[] args) {
        System.out.println(checkParantes("(3+{5{99{*}}[23[{67}67]]})")); // true
        System.out.println(checkParantes("(}){")); // false
        System.out.println(checkParantes("({[]})")); // true
        System.out.println(checkParantes("({[})]")); // false
    }

    public static boolean checkParantes(String s) {
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c); //tilføj til stack
            } else if (c == ')' || c == '}' || c == ']') {
                if (stack.isEmpty()) return false; //lukning foran åbning

                char last = stack.pop();
                if (!matches(last, c)) return false; //Ikke match
            }
        }
        return stack.isEmpty(); //True, hvis stack er tom. false hvis stack har elementer
    }

    private static boolean matches(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
