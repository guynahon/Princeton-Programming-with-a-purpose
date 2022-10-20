public class DiscreteDistribution {
    public static void main(String[] args) {
        int m = Integer.parseInt(args[0]);
        int[] s = new int[args.length];
        for (int i = 0; i < args.length - 1; i++) {
            int t = Integer.parseInt(args[i+1]);
            s[i+1] = t + s[i];
        }
        for (int i = 0; i < m; i++) {
            int random = (int) (Math.random() * (s[args.length - 1]));
            for (int j = 0; j < args.length - 1; j++) {
                if (random >= s[j] && random < s[j+1]) {
                    System.out.print(j+1+" ");
                }
            }
        }
    }
}
