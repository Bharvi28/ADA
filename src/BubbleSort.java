/*
To implement Bubble Sort on a sufficiently large dataset and measure its execution
time to analyze its performance.
 */
import java.util.Random;
import java.util.Scanner;

public class BubbleSort {

    public static void bubbleSort(int[] arr) {
        int n = arr.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (arr[j] > arr[j + 1]) {
                    // Swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
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

        bubbleSort(data);

        long endTime = System.nanoTime();
        System.out.println("\nSorted array ");
        for(int i=0;i<size;i++){
            System.out.print(data[i]+" ");
        }

        long executionTime = endTime - startTime;

        System.out.println("\nExecution Time: " + executionTime + " nanoseconds");

    }
}
/*
Enter dataset size: 3
15068 11076 26872
Sorted array
11076 15068 26872
Execution Time: 5000 nanoseconds
 */