public class Birthday {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        int[] count = new int[n + 1];
        for (int j = 0; j < trials; j++) {
            boolean[] b = new boolean[n + 1];
            for (int i = 0;; i++) {
                int randomB = (int) (Math.random() * n);
                if (!b[randomB]) {
                    b[randomB] = true;
                } else {
                    count[i]++;
                    break;
                }
            }
        }
        int sum = 0;
        for (int j = 0; (double) sum / trials < 0.5; j++) {
            sum += count[j];
            System.out.println(j+1 + "\t" + count[j] + "\t" + (double) sum / trials);
        }
    }
}