public class Ramanujan {
    public static boolean isRamanujan(long n) {
        double powThird = Math.cbrt(n);
        long a = 0, b = 0, c = 0, d = 0;
        boolean foundab = false, foundcd = false;
        for (long i = 1; i < powThird; i++) {
            double m = Math.cbrt(n - i * i * i);
            if (Math.floor(m) == m) {
                a = i;
                b =(int) Math.round(m);
                if ((a * a * a) + (b * b * b) == n && a != b) {
                    foundab = true;
                    break;
                }
            }
        }
        for (long j = a + 1; j < powThird; j++) {
            double m = Math.cbrt(n - j * j * j);
            if (Math.floor(m) == m) {
                c = j;
                d =(int) Math.round(m);
                if ((c * c * c) + (d * d * d) == n && c != d) {
                    foundcd = true;
                    break;
                }
            }
        }

        if (a != c && a != d && b !=c && b != d) {
            return foundcd & foundab;
        } else {
            return false;
        }
    }
    public static void main(String[] args) {
        long n = Long.parseLong(args[0]);
        StdOut.print(isRamanujan(n));

    }
}
