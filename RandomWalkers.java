public class RandomWalkers {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int trials = Integer.parseInt(args[1]);
        double sum = 0;
        for (int i = 0; i < trials; i++) {
            int manhattan = 0;
            double steps = 0;
            int x = 0;
            int y = 0;
            while (manhattan != r) {
                double random = Math.random();
                if (random < 0.25) {
                    x++;
                } else if (random < 0.5) {
                    x--;
                } else if (random < 0.75) {
                    y++;
                } else {
                    y--;
                }
                steps++;
                manhattan = Math.abs(x) + Math.abs(y);
            }
            sum += steps;
        }
        double average = sum / trials;
        System.out.println("average number of steps = " + average);
    }
}
