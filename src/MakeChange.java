//Solve Make a change problem Using Dynamic Programming.
import java.util.*;

class MakeChange {

    public static void minCoins(int coins[], int amount) {
        int dp[] = new int[amount + 1];
        int lastCoin[] = new int[amount + 1];

        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i && dp[i - coin] != Integer.MAX_VALUE) {
                    if (dp[i] > dp[i - coin] + 1) {
                        dp[i] = dp[i - coin] + 1;
                        lastCoin[i] = coin;
                    }
                }
            }
        }

        if (dp[amount] == Integer.MAX_VALUE) {
            System.out.println("Amount cannot be formed");
            return;
        }

        System.out.println("Minimum coins required: " + dp[amount]);

        System.out.print("Coins used: ");
        int temp = amount;
        while (temp > 0) {
            System.out.print(lastCoin[temp] + " ");
            temp -= lastCoin[temp];
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of coin denominations: ");
        int n = sc.nextInt();

        int coins[] = new int[n];

        System.out.println("Enter coin denominations:");
        for (int i = 0; i < n; i++) {
            coins[i] = sc.nextInt();
        }

        System.out.print("Enter amount: ");
        int amount = sc.nextInt();

        minCoins(coins, amount);

    }
}
/*
Enter number of coin denominations: 3
Enter coin denominations:
1 2 5
Enter amount: 13
Minimum coins required: 4
Coins used: 1 2 5 5
 */