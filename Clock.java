public class Clock {
    private static final int HOURS_PER_DAY = 24;
    private static final int MINUTES_PER_DAY = 60;
    private int hours;
    private int minutes;

    public Clock(int h, int m) {
        hours = h;
        minutes = m;
        if (h < 0 || h >= HOURS_PER_DAY || m < 0 || m >= MINUTES_PER_DAY) {
            throw new IllegalArgumentException("hours between 0 and 23, minutes between 0 and 59");
        }
    }
    public Clock(String s) {
        if (!s.contains(":")){
            throw new IllegalArgumentException();
        }
        int t = s.indexOf(':');
        String stringHour = s.substring(0, t);
        String stringMinutes  = s.substring(t + 1);
        if (stringHour.length() != 2 || stringMinutes.length() != 2) {
            throw new IllegalArgumentException();
        }
        int h = Integer.parseInt(stringHour);
        int m = Integer.parseInt(stringMinutes);
        if (h < 0 || h >= HOURS_PER_DAY || m < 0 || m >= MINUTES_PER_DAY) {
            throw new IllegalArgumentException();
        }
        hours = h;
        minutes = m;
    }
    public String toString() {
        if (hours < 10 && minutes < 10) { return "0"+ hours +":0"+ minutes; }
        else if (hours < 10) { return "0"+ hours +":"+ minutes; }
        else if (minutes < 10) { return hours +":0"+ minutes; }
        else { return hours +":"+ minutes; }
    }
    public boolean isEarlierThan(Clock that) {
        if (hours < that.hours) { return true; }
        else if (hours > that.hours) { return false; }
        else return minutes < that.minutes;
    }
    public void tic() {
        if (minutes == MINUTES_PER_DAY - 1 && hours == HOURS_PER_DAY - 1) {
            hours = 0;
            minutes = 0;
        } else if (minutes == MINUTES_PER_DAY - 1) {
            hours++;
            minutes = 0;
        } else {
            minutes++;
        }
    }
    public void toc(int delta) {
        if (delta < 0) {
            throw new IllegalArgumentException("Delta can't be negative");
        }
        int allMinutes = delta + hours * MINUTES_PER_DAY + minutes;
        hours = (allMinutes / MINUTES_PER_DAY) % HOURS_PER_DAY;
        minutes = (allMinutes % MINUTES_PER_DAY);
    }

    public static void main(String[] args) {
        Clock a = new Clock(23, 59);
        Clock b = new Clock("-22:47");
        StdOut.println(a.isEarlierThan(b));
        int beta = 1485;
        a.tic();
        b.toc(beta);
        StdOut.println(a);
        StdOut.println(b);
    }
}



//public void toc(int delta) {
//        if (delta < 0) {
//            throw new IllegalArgumentException("Delta can't be negative");
//        } else {
//            int h2 = delta / 60;
//            int m2 = delta % 60;
//            if (m1 + m2 > 59 && h1 != 23) {
//                m1 = m1 + m2 - 60;
//                h1++;
//            } else if (m1 + m2 > 59 && h1 == 23) {
//                m1 = m1 + m2 - 60;
//                h1 = 0;
//            } else {
//                m1 = m1 + m2;
//            }
//
//            if (h1 + h2 > 23) {
//                if ((h2 % 24) + h1 > 23) {
//                    h1 = ((h2 % 24) + h1) - 24;
//                } else {
//                    h1 = (h2 % 24) + h1;
//                }
//            } else {
//                h1 = h1 + h2;
//            }
//        }
//    }