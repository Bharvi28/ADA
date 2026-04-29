/*
To develop and execute Quick Sort for large input values and evaluate the
algorithm’s execution time.
 */
import java.util.Random;
import java.util.Scanner;

public class QuickSort{

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);

            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high]; // choose last element as pivot
        int i = low - 1;

        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
                i++;
                // Swap arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }

        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;

        return i + 1;
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

        quickSort(data, 0, data.length - 1);

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
43419 42111 47949
Sorted array
42111 43419 47949
Execution Time: 3600 nanoseconds
 */