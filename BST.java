import java.util.Scanner;

class Node {
    int data;
    Node left, right;

    public Node(int item) {
        data = item;
        left = right = null;
    }
}

class BinarySearchTree {
    Node root;

    BinarySearchTree() {
        root = null;
    }

    // Insert a node
    public void insert(int data) {
        root = insertRec(root, data);
    }

    private Node insertRec(Node node, int data) {
        if (node == null) {
            node = new Node(data);
            return node;
        }
        if (data < node.data)
            node.left = insertRec(node.left, data);
        else if (data > node.data)
            node.right = insertRec(node.right, data);
        return node;
    }

    // Delete a node
    public void delete(int data) {
        root = deleteRec(root, data);
    }

    private Node deleteRec(Node node, int data) {
        if (node == null)
            return node;

        if (data < node.data)
            node.left = deleteRec(node.left, data);
        else if (data > node.data)
            node.right = deleteRec(node.right, data);
        else {
            // Node with one or no child
            if (node.left == null)
                return node.right;
            else if (node.right == null)
                return node.left;

            // Node with two children
            node.data = findMinValue(node.right);
            node.right = deleteRec(node.right, node.data);
        }
        return node;
    }

    private int findMinValue(Node node) {
        int minv = node.data;
        while (node.left != null) {
            minv = node.left.data;
            node = node.left;
        }
        return minv;
    }

    // Search for a value
    public boolean search(int data) {
        return searchRec(root, data);
    }

    private boolean searchRec(Node node, int data) {
        if (node == null)
            return false;
        if (node.data == data)
            return true;
        if (data < node.data)
            return searchRec(node.left, data);
        else
            return searchRec(node.right, data);
    }

    // Inorder Traversal
    public void inorder() {
        inorderRec(root);
        System.out.println();
    }

    private void inorderRec(Node node) {
        if (node != null) {
            inorderRec(node.left);
            System.out.print(node.data + " ");
            inorderRec(node.right);
        }
    }

    // Preorder Traversal
    public void preorder() {
        preorderRec(root);
        System.out.println();
    }

    private void preorderRec(Node node) {
        if (node != null) {
            System.out.print(node.data + " ");
            preorderRec(node.left);
            preorderRec(node.right);
        }
    }
}

public class BST {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BinarySearchTree bst = new BinarySearchTree();
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- Binary Search Tree Menu ---");
            System.out.println("1. Insert a value");
            System.out.println("2. Delete a value");
            System.out.println("3. Search for a value");
            System.out.println("4. Print tree (In-order traversal)");
            System.out.println("5. Print tree (Pre-order traversal)");
            System.out.println("6. Exit");
            System.out.print("Enter your choice (1-6): ");

            int choice = scanner.nextInt();
            int value;

            switch (choice) {
                case 1:
                    System.out.print("Enter value to insert: ");
                    value = scanner.nextInt();
                    bst.insert(value);
                    System.out.println(value + " was inserted.");
                    break;

                case 2:
                    System.out.print("Enter value to delete: ");
                    value = scanner.nextInt();
                    if (bst.search(value)) {
                        bst.delete(value);
                        System.out.println(value + " was deleted.");
                    } else {
                        System.out.println(value + " was not found in the tree.");
                    }
                    break;

                case 3:
                    System.out.print("Enter value to search for: ");
                    value = scanner.nextInt();
                    if (bst.search(value))
                        System.out.println(value + " was found in the tree.");
                    else
                        System.out.println(value + " was NOT found in the tree.");
                    break;

                case 4:
                    System.out.print("In-order traversal: ");
                    if (bst.root == null)
                        System.out.println("Tree is empty.");
                    else
                        bst.inorder();
                    break;

                case 5:
                    System.out.print("Pre-order traversal: ");
                    if (bst.root == null)
                        System.out.println("Tree is empty.");
                    else
                        bst.preorder();
                    break;

                case 6:
                    exit = true;
                    System.out.println("Exiting program. Goodbye!");
                    break;

                default:
                    System.out.println("Invalid choice. Please enter a number between 1 and 6.");
            }
        }
        scanner.close();
    }
}
