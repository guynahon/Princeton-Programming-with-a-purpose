public class Checkerboard {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        StdDraw.setScale(0, n);
        double x ,y;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                x = i;
                y = j;
                if ((i + j) % 2 == 0) {
                    StdDraw.setPenColor(StdDraw.BLUE);
                    StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                }
                else {
                    StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
                    StdDraw.filledSquare(x + 0.5, y + 0.5, 0.5);
                }
            }
        }
    }
}

