public class ActivationFunction {
    public static double heaviside(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x < 0.0)
            return 0.0;
        else if (x == 0.0)
            return 0.5;
        return 1.0;
    }
    public static double sigmoid(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        return 1.0 / (1.0 + Math.exp(-x));
    }
    public static double tanh(double x) {
        double j = Math.exp(x);
        double i = Math.exp(-x);
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x >= 20.0)
            return 1.0;
        else if (x <= -20.0)
            return -1.0;
        else
            return (j - i) / (j + i);
    }
    public static double softsign(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x == Double.POSITIVE_INFINITY)
            return 1.0;
        else if (x == Double.NEGATIVE_INFINITY)
            return -1.0;
        return x / (1.0 + Math.abs(x));
    }
    public static double sqnl(double x) {
        if (Double.isNaN(x))
            return Double.NaN;
        else if (x <= -2.0)
            return -1.0;
        else if (x > -2.0 && x < 0.0)
            return x + x * x / 4.0;
        else if (x >= 0.0 && x < 2.0)
            return x - x * x / 4.0;
        return 1.0;
    }
    public static void main(String[] args) {
        double x = Double.parseDouble(args[0]);
        StdOut.println("heaviside("+x+") = "+heaviside(x));
        StdOut.println("sigmoid("+x+") = "+sigmoid(x));
        StdOut.println("tanh("+x+") = "+tanh(x));
        StdOut.println("softsign("+x+") = "+softsign(x));
        StdOut.println("sqnl("+x+") = "+sqnl(x));
    }
}
