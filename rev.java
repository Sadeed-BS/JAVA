import java.util.Scanner;
import java.util.Stack;

public class rev {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of elements to reverse: ");
        int n = scanner.nextInt();

        
        Stack<Integer> stack = new Stack<>();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        System.out.println("Reversed elements:");
        while (!stack.isEmpty()) {
            int num = stack.pop();
            System.out.println(num);
        }

        scanner.close();
    }
}
