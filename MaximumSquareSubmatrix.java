public class MaximumSquareSubmatrix {
    public static int size(int[][] a) {
        int n = a.length;
        int[][] count = new int[n][n];
        int maxMat = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i > 0 && j > 0) {
                    int left = count[i][j - 1];
                    int up = count[i - 1][j];
                    int diagonal = count[i - 1][j - 1];
                    int min = Math.min(Math.min(up, left), diagonal);
                    if (a[i][j] == 1) {
                        count[i][j] = min + 1;
                    }
                } else {
                    count[i][j] = a[i][j];
                }
                maxMat = Math.max(maxMat, count[i][j]);
            }
        }
        return maxMat;
    }

    public static void main(String[] args) {
        int n = StdIn.readInt();
        int a[][] = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = StdIn.readInt();
            }
        }
        StdOut.println(size(a));
    }
}