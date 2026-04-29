/*
To implement Selection Sort on a sufficiently large dataset and measure its
execution time to analyze its performance.
 */
import java.util.*;

public class SelectionSort{

    public static void selectionSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;

            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            int temp = arr[i];
            arr[i] = arr[minIndex];
            arr[minIndex] = temp;
        }
    }

    public static int[] generateData(int size) {
        Random rand = new Random();
        int[] arr = new int[size];

        for (int i = 0; i < size; i++) {
            arr[i] = rand.nextInt(100000);
        }

        return arr;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter dataset size: ");
        int size = sc.nextInt();

        int[] data = generateData(size);
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }

        long startTime = System.nanoTime();

        selectionSort(data);

        long endTime = System.nanoTime();
        System.out.println("Sorted array ");
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }

        long executionTime = endTime - startTime;

        System.out.println("\nExecution Time: " + executionTime + " nanoseconds");

    }
}
/*
Enter dataset size: 3
25830 88392 32484 Sorted array
25830 32484 88392
Execution Time: 2300 nanoseconds
 */