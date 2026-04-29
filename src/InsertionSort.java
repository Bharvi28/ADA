/*
To develop and execute Insertion Sort for large input values and evaluate the
algorithm’s execution time.
 */
import java.util.Random;
import java.util.Scanner;

public class InsertionSort{

    public static void insertionSort(int[] arr) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }

            arr[j + 1] = key;
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

        insertionSort(data);

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
60276 63461 11056
Sorted array
11056 60276 63461
Execution Time: 2300 nanoseconds

 */