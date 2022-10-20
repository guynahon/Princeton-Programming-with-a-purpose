public class ColorHSB {
    private final int hue;
    private final int sat;
    private final int bri;

    public ColorHSB(int h, int s, int b) {
        hue = h;
        sat = s;
        bri = b;
    }

    public String toString() {
        return "("+hue+", "+sat+", "+bri+")";
    }
    public boolean isGrayscale() {
        return sat == 0 || bri == 0;
    }

    public int distanceSquaredTo(ColorHSB that) {
        return (int) ((Math.min(Math.pow((hue - that.hue), 2), Math.pow((360 - Math.abs(hue - that.hue)), 2)) + Math.pow(sat - that.sat, 2) + Math.pow(bri - that.bri, 2)));
    }


    public static void main(String[] args) {
        int h = Integer.parseInt(args[0]);
        int s = Integer.parseInt(args[1]);
        int b = Integer.parseInt(args[2]);
        if (h < 0 || h >= 360) {
            throw new IllegalArgumentException("the hue must be between 0 and 359");
        }
        if (s < 0 || s > 100) {
            throw new IllegalArgumentException("the saturation must be between 0 and 100");
        }
        if (b < 0 || b > 100) {
            throw new IllegalArgumentException("the brightness must be between 0 and 100");
        }
        ColorHSB hsb = new ColorHSB(h, s, b);

        String color = StdIn.readString();
        int hue = StdIn.readInt();
        int saturation = StdIn.readInt();
        int brightness = StdIn.readInt();
        ColorHSB min = new ColorHSB(hue, saturation, brightness);

        while (!StdIn.isEmpty()) {
            String c = StdIn.readString();
            int h1 = StdIn.readInt();
            int s1 = StdIn.readInt();
            int b1 = StdIn.readInt();
            ColorHSB temp = new ColorHSB(h1, s1, b1); // guy[args].distance(oran)[readInt] - hue or this.hue = guy, that.hue = oran
            if (hsb.distanceSquaredTo(temp) < hsb.distanceSquaredTo(min)) {
                min = temp;
                color = c;
            }
        }
        StdOut.println(color+" "+min);
    }
}
