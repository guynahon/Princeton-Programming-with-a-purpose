public class GreatCircle {
    public static void main(String[] args) {
        Double x1 = Math.toRadians(Double.parseDouble(args[0]));
        Double y1 = Math.toRadians(Double.parseDouble(args[1]));
        Double x2 = Math.toRadians(Double.parseDouble(args[2]));
        Double y2 = Math.toRadians(Double.parseDouble(args[3]));
        int radius = 6371;
        Double distance = 2*radius*Math.asin(Math.sqrt(Math.sin((x2-x1)/2)*Math.sin((x2-x1)/2)+Math.cos(x1)*Math.cos(x2)*Math.sin((y2-y1)/2)*Math.sin((y2-y1)/2)));
        System.out.println(distance);
    }
}
