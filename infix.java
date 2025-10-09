import java.util.Scanner;
import java.util.Stack;

public class infix {

    private static int precedence(char operator) {
        switch (operator) {
            case '+':
            case '-':
                return 1;
            case '*':
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
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);

            
            if (Character.isLetterOrDigit(c)) {
                result.append(c);
            } 
           
            else if (c == '(') {
                stack.push(c);
            } 
           
            else if (c == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    result.append(stack.pop());
                }
                if (!stack.isEmpty() && stack.peek() == '(') {
                    stack.pop(); // Discard '('
                }
            } 
           
            else if (isOperator(c)) {
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
