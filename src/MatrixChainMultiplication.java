//Solve Matrix Chain Multiplication Using Dynamic Programming.
import java.util.*;

class MatrixChainMultiplication {

    public static void printOptimal(int s[][], int i, int j) {
        if (i == j) {
            System.out.print("A" + i);
        } else {
            System.out.print("(");
            printOptimal(s, i, s[i][j]);
            printOptimal(s, s[i][j] + 1, j);
            System.out.print(")");
        }
    }

    public static void matrixChain(int p[], int n) {
        int m[][] = new int[n][n];
        int s[][] = new int[n][n];

        for (int i = 1; i < n; i++)
            m[i][i] = 0;

        for (int L = 2; L < n; L++) {
            for (int i = 1; i < n - L + 1; i++) {
                int j = i + L - 1;
                m[i][j] = Integer.MAX_VALUE;

                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];

                    if (q < m[i][j]) {
                        m[i][j] = q;
                        s[i][j] = k;
                    }
                }
            }
        }

        System.out.println("Minimum number of multiplications: " + m[1][n - 1]);

        System.out.print("Optimal Parenthesization: ");
        printOptimal(s, 1, n - 1);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of matrices: ");
        int n = sc.nextInt();

        int p[] = new int[n + 1];

        System.out.println("Enter dimensions array (size " + (n + 1) + "):");
        for (int i = 0; i <= n; i++) {
            p[i] = sc.nextInt();
        }

        matrixChain(p, n + 1);

    }
}
/*
Enter number of matrices: 3
Enter dimensions array (size 4):
10 15 20 25
Minimum number of multiplications: 8000
Optimal Parenthesization: ((A1A2)A3)
 */