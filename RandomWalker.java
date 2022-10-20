public class RandomWalker {
    public static void main(String[] args) {
        int r = Integer.parseInt(args[0]);
        int manhattan = 0;
        int steps = 0;
        int x = 0;
        int y = 0;
        System.out.println("("+x+", "+y+")");
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
            System.out.println("("+x+", "+y+")");
            manhattan = Math.abs(x) + Math.abs(y);
        }
        System.out.println("Steps = "+steps);

    }
}
