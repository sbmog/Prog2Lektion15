package opgave03;

import opgave03.models.DropOutStack;

public class Opgave03 {
    public static void main(String[] args) {
        DropOutStack<Integer> stack = new DropOutStack<>(3);

        stack.push(1);
        stack.push(2);
        stack.push(3);
        System.out.println(stack.peek()); // 3

        stack.push(4); // 1 forsvinder (drop-out)
        System.out.println(stack.pop()); // 4
        System.out.println(stack.pop()); // 3
        System.out.println(stack.pop()); // 2
        System.out.println(stack.isEmpty()); // true
    }
}
