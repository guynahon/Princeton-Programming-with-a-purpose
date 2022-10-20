public class ThueMorse {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] a = new boolean[n];

        for (int t = 0; (int) Math.pow(2, t) <= n; t++) {
            int pow = (int) Math.pow(2, t);
            int lastIndex = pow;
            for (int i = 1; i <= pow && lastIndex < n; i++) {
                a[lastIndex] = !a[lastIndex - pow];
                lastIndex++;
            }
        }
        for (int j = 0; j < n; j++) {
                if (!a[j]) {
                    for (int i = 0; i < n; i++) {
                        if (!a[i]) {
                            System.out.print("+  ");
                        } else {
                            System.out.print("-  ");
                        }
                    }
                } else {
                    for (int i = 0; i < n; i++) {
                        if (a[i]) {
                            System.out.print("+  ");
                        } else {
                            System.out.print("-  ");
                        }
                    }

                }
                System.out.println();
            }
        }
   }





