public class Divisors {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (b == 0) {
            return a;
        }
        while (a % b != 0) {
            int t = a;
            a = b;
            b = t % b;
        }
        return b;
    }
    public static int lcm(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        if (a == 0 || b == 0){
            return 0;
        }
        return a/gcd(a,b)*b;
    }
    public static boolean areRelativelyPrime(int a, int b) {
        if (gcd(a,b) == 1) {
            return true;
        }
        return false;
    }
    public static int totient(int n) {
        int counter = 0;
        for (int i = 0; i < n; i++) {
            if(areRelativelyPrime(i, n)) {
                counter++;
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        StdOut.println("gcd("+a+","+b+") = "+gcd(a, b));
        StdOut.println("lcm("+a+","+b+") = "+lcm(a, b));
        StdOut.println("areRelativelyPrime("+a+","+b+") = "+areRelativelyPrime(a, b));
        StdOut.println("totient("+a+") = "+totient(a));
        StdOut.println("totient("+b+") = "+totient(b));
    }
}
