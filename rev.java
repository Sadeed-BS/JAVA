import java.util.Scanner;

class Stack {
    private int[] arr;
    private int top;
    private int capacity;

    
    Stack(int size) {
        arr = new int[size];
        capacity = size;
        top = -1;
    }

    
    public void push(int x) {
        if (isFull()) {
            System.out.println("Overflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Inserting " + x);
        arr[++top] = x;
    }

    
    public int pop() {
        
        if (isEmpty()) {
            System.out.println("Underflow\nProgram Terminated");
            System.exit(1);
        }

        System.out.println("Removing " + peek());

        return arr[top--];
    }

    
    public int peek() {
        if (!isEmpty()) {
            return arr[top];
        } else {
            System.exit(1);
        }

        return -1;
    }

    public int size() {
        return top + 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == capacity - 1;
    }
}

public class rev {
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
