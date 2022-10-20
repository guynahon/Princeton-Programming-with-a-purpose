import java.awt.Color;
public class KernelFilter {
    public static Picture identity(Picture picture) {
        double array[][] = new double[3][3];
        array[0][0] = 0;
        array[0][1] = 0;
        array[0][2] = 0;
        array[1][0] = 0;
        array[1][1] = 1;
        array[1][2] = 0;
        array[2][0] = 0;
        array[2][1] = 0;
        array[2][2] = 0;
        return kernel(picture, array);
    }
    public static Picture sharpen(Picture picture) {
        double array[][] = new double[3][3];
        array[0][0] = 0;
        array[0][1] = -1;
        array[0][2] = 0;
        array[1][0] = -1;
        array[1][1] = 5;
        array[1][2] = -1;
        array[2][0] = 0;
        array[2][1] = -1;
        array[2][2] = 0;
        return kernel(picture, array);
    }
    public static Picture emboss(Picture picture) {
        double array[][] = new double[3][3];
        array[0][0] = -2;
        array[0][1] = -1;
        array[0][2] = 0;
        array[1][0] = -1;
        array[1][1] = 1;
        array[1][2] = 1;
        array[2][0] = 0;
        array[2][1] = 1;
        array[2][2] = 2;
        return kernel(picture, array);
    }
    public static Picture laplacian(Picture picture) {
        double array[][] = new double[3][3];
        array[0][0] = -1;
        array[0][1] = -1;
        array[0][2] = -1;
        array[1][0] = -1;
        array[1][1] = 8;
        array[1][2] = -1;
        array[2][0] = -1;
        array[2][1] = -1;
        array[2][2] = -1;
        return kernel(picture, array);
    }
    public static Picture gaussian(Picture picture) {
        double array[][] = new double[3][3];
        array[0][0] = 1.0 * (1.0 / 16.0);
        array[0][1] = 2.0 * (1.0 / 16.0);
        array[0][2] = 1.0 * (1.0 / 16.0);
        array[1][0] = 2.0 * (1.0 / 16.0);
        array[1][1] = 4.0 * (1.0 / 16.0);
        array[1][2] = 2.0 * (1.0 / 16.0);
        array[2][0] = 1.0 * (1.0 / 16.0);
        array[2][1] = 2.0 * (1.0 / 16.0);
        array[2][2] = 1.0 * (1.0 / 16.0);
        return kernel(picture, array);
    }
    public static Picture motionBlur(Picture picture) {
        double weights[][] = new double[9][9];
        for (int i = 0; i < weights.length; i++) {
            weights[i][i] = 1.0/9.0;
            }
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rhold = 0.0;
        double ghold = 0.0;
        double bhold = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row ++) {
                for (int i = -4; i < 5; i++) {
                    for (int j = -4; j < 5;j++) {
                        Color color = picture.get(Math.floorMod(col + i, w), Math.floorMod(row + j, h));
                        rhold += color.getRed() * weights[i + 4][j + 4];
                        ghold += color.getGreen() * weights[i + 4][j + 4];
                        bhold += color.getBlue() * weights[i + 4][j + 4];
                    }
                }
                int red = (int) Math.round(rhold);
                int green = (int) Math.round(ghold);
                int blue = (int) Math.round(bhold);
                if (red < 0) { red = 0; }
                if (red > 255) { red = 255; }
                if (green < 0) { green = 0; }
                if (green > 255) { green = 255; }
                if (blue < 0) { blue = 0; }
                if (blue > 255) { blue = 255; }
                Color pixelColor = new Color(red, green, blue);
                target.set(col, row, pixelColor);
                rhold = 0.0;
                ghold = 0.0;
                bhold = 0.0;
            }
        }
        return target;
    }
    private static Picture kernel(Picture picture, double[][] weights) {
        int w = picture.width();
        int h = picture.height();
        Picture target = new Picture(w, h);
        double rhold = 0.0;
        double ghold = 0.0;
        double bhold = 0.0;
        for (int col = 0; col < w; col++) {
            for (int row = 0; row < h; row ++) {
                for (int i = -1; i < 2; i++) {
                    for (int j = -1; j < 2;j++) {
                            Color color = picture.get(Math.floorMod(col + i, w), Math.floorMod(row + j, h));
                            rhold += color.getRed() * weights[i + 1][j + 1];
                            ghold += color.getGreen() * weights[i + 1][j + 1];
                            bhold += color.getBlue() * weights[i + 1][j + 1];
                    }
                }
                int red = (int) Math.round(rhold);
                int green = (int) Math.round(ghold);
                int blue = (int) Math.round(bhold);
                if (red < 0) { red = 0; }
                if (red > 255) { red = 255; }
                if (green < 0) { green = 0; }
                if (green > 255) { green = 255; }
                if (blue < 0) { blue = 0; }
                if (blue > 255) { blue = 255; }
                Color pixelColor = new Color(red, green, blue);
                target.set(col, row, pixelColor);
                rhold = 0.0;
                ghold = 0.0;
                bhold = 0.0;
            }
        }
        return target;
    }

    public static void main(String[] args) {
        Picture source = new Picture(args[0]);
        identity(source).show();
        sharpen(source).show();
        laplacian(source).show();
        emboss(source).show();
        gaussian(source).show();
        motionBlur(source).show();
    }
}

