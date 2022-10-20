public class Huntingtons {
    public static String removeWhitespace(String s) {
        String v = s.replace("\t", "");
        String v2 = v.replace("\n", "");
        String v3 = v2.replace("\r", "");
        String v4 = v3.replace(" ", "");
        return v4;
    }
    public static int maxRepeats(String dna) {
        int count = 0;
        int hold = 0;
        for (int i = 0; i < dna.length(); i++) {
            if (i + 3 > dna.length()) {
                break;
            } else if(dna.substring(i, i + 3).equals("CAG")) {
                count++;
                i+=2;
                if (count > hold) {
                    hold = count;
                }
            } else {
                    count = 0;
                }
            }

        return hold;
    }
    public static String diagnose(int maxRepeats) {
        if (maxRepeats <= 9 || maxRepeats > 180) {
            return "not human";
        } else if (maxRepeats <= 35) {
            return "normal";
        } else if (maxRepeats <= 39) {
            return "high risk";
        } else {
            return "Huntington's";
        }
    }

    public static void main(String[] args) {
        String s = new In(args[0]).readAll();
        s = removeWhitespace(s);
        StdOut.println("max repeats = "+maxRepeats(s));
        StdOut.println(diagnose(maxRepeats(s)));
    }
}
