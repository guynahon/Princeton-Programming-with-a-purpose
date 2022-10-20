public class TrinomialDP {
    public static long trinomial(int n, int k) {
        n = Math.abs(n);
        k = Math.abs(k);
        long matrix[][] = new long[n + 2][n + 2];
        if (n == 0 && k == 0) {
            return 1;
        } else if (k > n) {
            return 0;
        }
        matrix[0][0] = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                if (j == 0) {
                    long value1 = matrix[i - 1][j];
                    long value2 = (matrix[i - 1][j + 1]) * 2;
                    matrix[i][j] = value1 + value2;
                } else {
                    long value1 = matrix[i - 1][j - 1];
                    long value2 = matrix[i - 1][j];
                    long value3 = matrix[i - 1][j + 1];
                    matrix[i][j] = value1 + value2 + value3;
                }
            }
        }
        return matrix[n][k];
    }
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int k = Integer.parseInt(args[1]);
           StdOut.println(trinomial(n, k));
    }
}
