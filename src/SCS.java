//Solve Shortest Common Supper sequence (SCS) using Dynamic Programming.
import java.util.*;

class SCS {

    public static void findSCS(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        int dp[][] = new int[m + 1][n + 1];

        // Step 1: Build LCS table
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0)
                    dp[i][j] = 0;
                else if (s1.charAt(i - 1) == s2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }

        StringBuilder scs = new StringBuilder();
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                scs.append(s1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                scs.append(s1.charAt(i - 1));
                i--;
            } else {
                scs.append(s2.charAt(j - 1));
                j--;
            }
        }

        while (i > 0) {
            scs.append(s1.charAt(i - 1));
            i--;
        }

        while (j > 0) {
            scs.append(s2.charAt(j - 1));
            j--;
        }

        System.out.println("Shortest Common Supersequence: " + scs.reverse().toString());
        System.out.println("Length: " + (m + n - dp[m][n]));
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter first string: ");
        String s1 = sc.nextLine();

        System.out.print("Enter second string: ");
        String s2 = sc.nextLine();

        findSCS(s1, s2);

    }
}
/*
Enter first string: ABCDEF
Enter second string: QAZXCD
Shortest Common Supersequence: QABZXCDEF
Length: 9
 */