public class AudioCollage {
    // Returns a new array that rescales a[] by a multiplicative factor of alpha.
    public static double[] amplify(double[] a, double alpha) {
        double b[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[i] * alpha;
        }
        return b;
    }
    // Returns a new array that is the reverse of a[].
    public static double[] reverse(double[] a) {
        double b[] = new double[a.length];
        for (int i = 0; i < a.length; i++) {
            b[i] = a[a.length - i - 1];
        }
        return b;
    }
    // Returns a new array that is the concatenation of a[] and b[].
    public static double[] merge(double[] a, double[] b) {
        double c[] = new double[a.length + b.length];
        for (int i = 0; i < c.length; i++) {
            if (i <= a.length - 1) {
                c[i] = a[i];
            } else {
                c[i] = b[i - a.length];
            }
        }
        return c;
    }
    // Returns a new array that is the sum of a[] and b[],
    // padding the shorter arrays with trailing 0s if necessary.
    public static double[] mix(double[] a, double[] b) {
        if (a.length == b.length) {
            double c[] = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + b[i];
            }
            return c;
        }
        else if (a.length > b.length) {
            double t[] = new double[a.length];
            double c[] = new double[a.length];
            for (int i = 0; i < b.length; i++) {
                t[i] = b[i];
            }
            for (int i = 0; i < a.length; i++) {
                c[i] = a[i] + t[i];
            }
            return c;
        }
        else {
            double t[] = new double[b.length];
            double c[] = new double[b.length];
            for (int i = 0; i < a.length; i++) {
                t[i] = a[i];
            }
            for (int i = 0; i < b.length; i++) {
                c[i] = t[i] + b[i];
            }
            return c;
        }
    }
    // Returns a new array that changes the speed by the given factor.
    public static double[] changeSpeed(double[] a, double alpha) {
        double t[] = new double[(int) (a.length / alpha)];
        for (int i = 0; i < t.length; i++) {
            t[i] = a[(int) (i * alpha)];
        }
        return t;
    }
    // Creates an audio collage and plays it on standard audio.
    // See below for the requirements.
    public static void main(String[] args) {
        double s1[] = StdAudio.read("cow.wav");
        double s2[] = StdAudio.read("dialup.wav");
        double s3[] = StdAudio.read("piano.wav");
        double s4[] = StdAudio.read("beatbox.wav");
        double s5[] = StdAudio.read("exposure.wav");
        double e1[] = amplify(s1, 0.5);
        double e2[] = amplify(s5, 0.2);
        double e3[] = merge(e2, e1);
        double e4[] = reverse(s3);
        double e5[] = mix(e4, e3);
        double e6[] = changeSpeed(s2, 3);
        double e7[] = changeSpeed(s4, 3);
        double e8[] = mix(e6, e7);
        double e9[] = merge(e8, e5);
        StdAudio.play(e9);
    }
}