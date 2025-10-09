import java.util.Scanner;

class Queue {
    private int[] queue;
    private int front, rear, capacity;

    public Queue(int size) {
        capacity = size;
        queue = new int[capacity];
        front = 0;
        rear = -1;
    }

    public void enqueue(int value) {
        if (rear == capacity - 1) {
            System.out.println("Queue is full! Cannot enqueue " + value);
        } else {
            queue[++rear] = value;
            System.out.println("Enqueued: " + value);
        }
    }

    public int dequeue() {
        if (front > rear) {
            System.out.println("Queue is empty! Cannot dequeue.");
            return -1;
        }
        return queue[front++];
    }

    public void display() {
        if (front > rear) {
            System.out.println("Queue is empty!");
            return;
        }
        System.out.print("Queue elements: ");
        for (int i = front; i <= rear; i++) {
            System.out.print(queue[i] + " ");
        }
        System.out.println();
    }
}

public class QueueArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Queue queue = new Queue(5);

        while (true) {
            System.out.println("\nQueue Operations Menu:");
            System.out.println("1. Enqueue");
            System.out.println("2. Dequeue");
            System.out.println("3. Display Queue");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter the value to enqueue: ");
                    int value = scanner.nextInt();
                    queue.enqueue(value);
                    break;

                case 2:
                    int dequeuedValue = queue.dequeue();
                    if (dequeuedValue != -1) {
                        System.out.println("Dequeued: " + dequeuedValue);
                    }
                    break;

                case 3:
                    queue.display();
                    break;

                case 4:
                    System.out.println("Exiting program.");
                    scanner.close();
                    return;

                default:
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
