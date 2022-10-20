public class Inversions {
    public static long count (int a[]) {
        long inversions = 0;
        for (int i = 0; i < a.length; i++) {
            for (int j = i + 1; j < a.length; j++) {
                if (a[i] > a[j]) {
                    inversions++;
                }
            }
        }
        return inversions;
    }
    public static int[] generate(int n, long k) {
        int a[] = new int[n];
        for (int i = 0, t = n - 1; i <= n - 1; i++) {
            if (k >= t) {
                a[i] = t;
                k = k - t;
                t--;
            } else {
                int x = (int) (n-1-k);
                a[x] = t;
                int m = 0;
                for (int j = i; j < x; j++) {
                    a[j] = m;
                    m++;
                }
                for (int j = x + 1; j < n; j++) {
                    a[j] = m;
                    m++;
                }
                break;
            }
        }
        return a;
    }

    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        long k = Long.parseLong(args[1]);
        int array[] = (generate(n,k));
        for (int i = 0; i < array.length; i++) {
            StdOut.print(array[i]+" ");
        }
    }
}
