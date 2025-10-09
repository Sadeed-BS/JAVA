import java.util.Scanner;

class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}

public class DoublyLinkedList {
    Node head;

    // Insertion at the beginning
    void insertAtBeginning(int data) {
        Node newNode = new Node(data);
        if (head != null) {
            newNode.next = head;
            head.prev = newNode;
        }
        head = newNode;
    }

    // Insertion at the end
    void insertAtEnd(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
    }

    // Insertion at a given position
    void insertAtPosition(int data, int pos) {
        if (pos == 1) {
            insertAtBeginning(data);
            return;
        }
        Node newNode = new Node(data);
        Node temp = head;
        for (int i = 1; i < pos - 1 && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        newNode.next = temp.next;
        newNode.prev = temp;
        if (temp.next != null)
            temp.next.prev = newNode;
        temp.next = newNode;
    }

    // Deletion at the beginning
    void deleteAtBeginning() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        head = head.next;
        if (head != null)
            head.prev = null;
    }

    // Deletion at the end
    void deleteAtEnd() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (head.next == null) {
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.prev.next = null;
    }

    // Deletion at a given position
    void deleteAtPosition(int pos) {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        if (pos == 1) {
            deleteAtBeginning();
            return;
        }
        Node temp = head;
        for (int i = 1; i < pos && temp != null; i++) {
            temp = temp.next;
        }
        if (temp == null) {
            System.out.println("Invalid position!");
            return;
        }
        if (temp.next != null)
            temp.next.prev = temp.prev;
        if (temp.prev != null)
            temp.prev.next = temp.next;
    }

    // Display the list
    void display() {
        if (head == null) {
            System.out.println("List is empty!");
            return;
        }
        Node temp = head;
        System.out.print("Doubly Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " <-> ");
            temp = temp.next;
        }
        System.out.println("NULL");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        DoublyLinkedList list = new DoublyLinkedList();
        int choice, data, pos;

        while (true) {
            System.out.println("\n--- Doubly Linked List Menu ---");
            System.out.println("1. Insert at Beginning");
            System.out.println("2. Insert at End");
            System.out.println("3. Insert at Position");
            System.out.println("4. Delete at Beginning");
            System.out.println("5. Delete at End");
            System.out.println("6. Delete at Position");
            System.out.println("7. Display");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter value: ");
                    data = sc.nextInt();
                    list.insertAtBeginning(data);
                    break;
                case 2:
                    System.out.print("Enter value: ");
                    data = sc.nextInt();
                    list.insertAtEnd(data);
                    break;
                case 3:
                    System.out.print("Enter value: ");
                    data = sc.nextInt();
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.insertAtPosition(data, pos);
                    break;
                case 4:
                    list.deleteAtBeginning();
                    break;
                case 5:
                    list.deleteAtEnd();
                    break;
                case 6:
                    System.out.print("Enter position: ");
                    pos = sc.nextInt();
                    list.deleteAtPosition(pos);
                    break;
                case 7:
                    list.display();
                    break;
                case 8:
                    System.out.println("Exiting...");
                    sc.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice!");
            }
        }
    }
}
