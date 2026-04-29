//Solve 0/1 Knapsack Problem Using Dynamic Programming.
import java.util.*;

class Knapsack01 {

    public static void knapsack(int wt[], int val[], int n, int W) {
        int dp[][] = new int[n + 1][W + 1];

        // Build DP table
        for (int i = 0; i <= n; i++) {
            for (int w = 0; w <= W; w++) {
                if (i == 0 || w == 0)
                    dp[i][w] = 0;
                else if (wt[i - 1] <= w)
                    dp[i][w] = Math.max(
                            val[i - 1] + dp[i - 1][w - wt[i - 1]],
                            dp[i - 1][w]
                    );
                else
                    dp[i][w] = dp[i - 1][w];
            }
        }

        System.out.println("Maximum value: " + dp[n][W]);

        System.out.print("Items selected (weight:value): ");
        int w = W;
        for (int i = n; i > 0 && w > 0; i--) {
            if (dp[i][w] != dp[i - 1][w]) {
                System.out.print("(" + wt[i - 1] + ":" + val[i - 1] + ") ");
                w -= wt[i - 1];
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        int wt[] = new int[n];
        int val[] = new int[n];

        System.out.println("Enter weights:");
        for (int i = 0; i < n; i++) {
            wt[i] = sc.nextInt();
        }

        System.out.println("Enter values:");
        for (int i = 0; i < n; i++) {
            val[i] = sc.nextInt();
        }

        System.out.print("Enter capacity of knapsack: ");
        int W = sc.nextInt();

        knapsack(wt, val, n, W);

    }
}
/*
Enter weights:
10 20 30
Enter values:
60 100 120
Enter capacity of knapsack: 50
Maximum value: 220
Items selected (weight:value): (30:120) (20:100)
 */