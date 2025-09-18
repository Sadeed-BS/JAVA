import java.util.Scanner;

public class array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter the size of the array: ");
        int size = scanner.nextInt();
        int[] arr = new int[size];
        
        System.out.println("Enter " + size + " elements:");
        for (int i = 0; i < size; i++) {
            arr[i] = scanner.nextInt();
        }
		
		boolean running = true;
		
		while(running){
		
			System.out.println("For Display 1");
			System.out.println("For Insert 2");
			System.out.println("For Delete 3");
			System.out.println("For exit 4");
			System.out.println("Enter your choice");
			int choice = scanner.nextInt();
			switch (choice){
				
				case 1:
					System.out.println("Original Array:");
					displayArray(arr);
					break;
					
				case 2:
					System.out.print("Enter the element to insert: ");
					int element = scanner.nextInt();
					System.out.print("Enter the index to insert at: ");
					int insertIndex = scanner.nextInt();
					insertElement(arr, insertIndex, element);
					System.out.println("Array after insertion:");
					displayArray(arr);
					break;
				
				case 3:
					System.out.print("Enter the index to delete: ");
					int deleteIndex = scanner.nextInt();
					deleteElement(arr, deleteIndex);
					System.out.println("Array after deletion:");
					displayArray(arr);
					break;
					
				case 4:
					running = false;
					break;
				
			
			}
		
		}
		scanner.close();
    }
    
    public static void displayArray(int[] arr) {
        for (int num : arr) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
    
    public static void insertElement(int[] arr, int index, int element) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index");
        }
    
        for (int i = arr.length - 1; i > index; i--) {
            arr[i] = arr[i - 1];
        }
        arr[index] = element;
    }
    
    public static void deleteElement(int[] arr, int index) {
        if (index < 0 || index >= arr.length) {
            System.out.println("Invalid index");
        }
    
        for (int i = index; i < arr.length - 1; i++) {
            arr[i] = arr[i + 1];
        }
     
        arr[arr.length - 1] = 0;
    }
}
