import java.util.Scanner;

public class infix {

    static class ArrayStack {
        private char[] stack;
        private int top;
        private int capacity;

        public ArrayStack(int size) {
            stack = new char[size];
            capacity = size;
            top = -1;
        }

        public void push(char c) {
            if (top >= capacity - 1) {
                throw new IllegalStateException("Stack Overflow");
            }
            stack[++top] = c;
        }

        public char pop() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack Underflow");
            }
            return stack[top--];
        }

        public char peek() {
            if (isEmpty()) {
                throw new IllegalStateException("Stack is empty");
            }
            return stack[top];
        }

        public boolean isEmpty() {
            return top == -1;
        }
    }

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
				return 1;
            case '-':
                return 1;
            case '*':
				return 2;
            case '/':
                return 2;
            default:
                return -1;
        }
    }

    private static boolean isOperator(char c) {
        return c == '+' || c == '-' || c == '*' || c == '/';
    }

    public static String infixToPostfix(String expression) {
        StringBuilder result = new StringBuilder();
        ArrayStack stack = new ArrayStack(100);

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } else if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Remove '('
                }
            } else if (isOperator(c)) {
                while (!stack.isEmpty() && stack.peek() != '(' &&
                       precedence(c) <= precedence(stack.peek())) {
                    result.append(stack.pop());
                }
                stack.push(c);
            }
        }

        while (!stack.isEmpty()) {
            if (stack.peek() == '(') {
                return "Invalid Expression";
            }
            result.append(stack.pop());
        }

        return result.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter an infix expression: ");
        String expression = scanner.nextLine();
        scanner.close();

        System.out.println("Infix Expression: " + expression);
        System.out.println("Postfix Expression: " + infixToPostfix(expression));
    }
}
