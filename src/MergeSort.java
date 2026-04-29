/*
To implement Merge Sort on a sufficiently large dataset and measure its execution
time to analyze its performance.
 */
import java.util.Random;
import java.util.Scanner;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;

            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);

            merge(arr, left, mid, right);
        }
    }

    public static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; i++)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; j++)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }
        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
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

        mergeSort(data, 0, data.length - 1);

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
5943 29850 10030
Sorted array
5943 10030 29850
Execution Time: 4600 nanoseconds

 */