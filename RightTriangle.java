public class RightTriangle {
    public static void main(String[] args) {
        double a = Integer.parseInt(args[0]);
        double b = Integer.parseInt(args[1]);
        double c = Integer.parseInt(args[2]);
        System.out.println(c*c == a*a + b*b);
    }
}
