import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    // Constructor to initialize the stack
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    // Utility function to add an element `x` to the stack
    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    // Utility function to pop a top element from the stack
    public int pop() {
        // check for stack underflow
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + peek());

        // decrease stack size by 1 and (optionally) return the popped element
        return arr[top--];
    }

    // Utility function to return the top element of the stack
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }

        return -1;
    }

    // Utility function to return the size of the stack
    public int size() {
        return top + 1;
    }

    // Utility function to check if the stack is empty or not
    public boolean isEmpty() {
        return top == -1;
    }

    // Utility function to check if the stack is full or not
    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class Reverse {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of elements to reverse: ");
        int n = scanner.nextInt();

        Stack stack = new Stack(n);

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int element = scanner.nextInt();
            stack.push(element);
        }

        System.out.println("Reversed elements:");
        int i = 0;
        int arr[] = new int[stack.size()];
        while (!stack.isEmpty()) {

            int num = stack.pop();
            System.out.println(num);
            arr[i] = num;
            i++;
        }

        // Print the reversed array
        for (int j = 0; j < i; j++) {
            System.out.println(arr[j]);
        }

        scanner.close();
    }
}
