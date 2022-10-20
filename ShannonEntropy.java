public class ShannonEntropy {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] x = new int[m];
        double[] p = new double[m];
        int k;
        int counter = 0;
        double allP = 0.0;
        while (!StdIn.isEmpty()) {
            k = StdIn.readInt();
            x[k - 1]++;
            counter++;
        }
        for (int i = 1; i <= m; i++) {
            p[i - 1] = (double) x[i - 1] / counter;
            if (p[i - 1] == 0.0) {
                allP += 0.0;
            } else {
                allP += -(p[i - 1] * (Math.log(p[i - 1]) / Math.log(2)));
            }
        }
        StdOut.printf("%.4f", allP);
    }
}

