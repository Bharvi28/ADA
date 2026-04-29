// Implement Linear search and Binary Search.
import java.util.*;

public class Search {

    // Linear Search
    public static int linearSearch(int[] arr, int target) {
        for(int i = 0; i < arr.length; i++) {
            if(arr[i] == target) {
                return i;
            }
        }
        return -1;
    }

    // Binary Search
    public static int binarySearch(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while(left <= right) {
            int mid = (left + right) / 2;

            if(arr[mid] == target) {
                return mid;
            }
            else if(arr[mid] < target) {
                left = mid + 1;
            }
            else {
                right = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter elements (sorted for binary search):");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter element to search: ");
        int target = sc.nextInt();

        int result1 = linearSearch(arr, target);
        if(result1 != -1)
            System.out.println("Linear Search: Element found at position " + (result1 + 1));
        else
            System.out.println("Linear Search: Element not found");

        int result2 = binarySearch(arr, target);
        if(result2 != -1)
            System.out.println("Binary Search: Element found at position " + (result2 + 1));
        else
            System.out.println("Binary Search: Element not found");

    }
}
/*
Enter number of elements: 5
Enter elements (sorted for binary search):
10 20 30 40 50
Enter element to search: 30
Linear Search: Element found at position 3
Binary Search: Element found at position 3

 */