import java.util.Arrays;

public class BarChartRacer {
    public static void main(String[] args) {
        StdDraw.setCanvasSize(1000, 700);
        StdDraw.enableDoubleBuffering();
        String filename = args[0];
        int k = Integer.parseInt(args[1]);
        In in = new In(filename);
        String title = in.readLine();
        String xAxis = in.readLine();
        String source = in.readLine();
        in.readLine();
        BarChart chart = new BarChart(title, xAxis, source);
        while (in.hasNextLine()) {
            int n = Integer.parseInt(in.readLine());
            Bar bars[] = new Bar[n];
            String date = "";
            for (int i = 0; i < n; i++) {
                String record = in.readLine();
                String recorder[] = record.split(",");
                date = recorder[0];
                String name = recorder[1];
                String country = recorder[2];
                int value = Integer.parseInt(recorder[3]);
                String category = recorder[4];
                bars[i] = new Bar(name, value, category);
            }
            Arrays.sort(bars);
            chart.setCaption(date);
            for (int i = bars.length - 1; i > bars.length - 1 - k; i--) {
                chart.add(bars[i].getName(),bars[i].getValue(),bars[i].getCategory());
            }
            StdDraw.clear();
            chart.draw();
            StdDraw.show();
            StdDraw.pause(100);
            chart.reset();
            in.readLine();
        }
        chart.reset();
    }
}