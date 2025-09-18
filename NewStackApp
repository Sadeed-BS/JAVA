import java.util.*;

class Stack{
	private int[] arr;
	private int top;
	private int capacity;
	
	Stack(int size){
		arr = new int[size];
		capacity = size;
		top = -1;
	}
	
	public void push(int x){
		if (isFull()){
			System.out.println("Stack Overflow");
			return;
		}
		
		System.out.print("Inserting " + x);
		arr[++top] = x;
	}
	
	public int pop(){
		if (isEmpty()){
			System.out.println("Stack Underflow");
			return -1;
		}
		
		int removed = arr[top--];
		System.out.print("Removing " + removed);
		return removed;
	}
	
	public int peek(){
		if(!isEmpty()){
			return arr[top];
		}else{
			System.out.println("Stack is Empty");
			return -1;
		}
	}
	
	public void display() {
		if (isEmpty()) {
			System.out.println("Stack is Empty");
			return;
		}
		System.out.print("Stack elements: ");
		for (int i = top; i >= 0; i--) {
			System.out.print(arr[i] + " ");
		}
		System.out.println();
	}
	
	public int size(){
		return top + 1;
	}
	
	public boolean isEmpty(){
		return top == -1;
	}
	
	public boolean isFull(){
		return top == capacity-1;
	}
	
	
}

public class StackApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack stack = new Stack(5);

        while (true) {
            System.out.println("\nChoose an operation:");
            System.out.println("1. Push");
            System.out.println("2. Pop");
            System.out.println("3. Display");
            System.out.println("4. Check if Empty");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value to push: ");
                    int value = scanner.nextInt();
                    stack.push(value);
                    break;

                case 2:
                    stack.pop();
                    break;

                case 3:
					stack.display();
					break;
					
                case 4:
                    System.out.println("Stack is " + (stack.isEmpty() ? "empty" : "not empty"));
                    break;

                case 5:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 7.");
            }
        }
    }
}
