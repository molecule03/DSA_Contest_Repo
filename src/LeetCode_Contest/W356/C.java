package LeetCode_Contest.W356;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

// Upsolved
public class C {

    public static void main(String[] args) {

        String ans = minimumString("xyyz", "xzyz", "zzz");

        System.out.println(ans);
    }

    public static String minimumString(String a, String b, String c) {
        String one = getConcatenatedString(a, b, c);
        String two = getConcatenatedString(a, c, b);
        String three = getConcatenatedString(b, a, c);
        String four = getConcatenatedString(b, c, a);
        String five = getConcatenatedString(c, a, b);
        String six = getConcatenatedString(c, b, a);

        // System.out.println(one+" "+two+" "+three+" "+four+" "+five+" "+six);

        return getSmallest(one, two, three, four, five, six);
    }

    private static String getConcatenatedString(String a, String b, String c) {
        StringBuilder sb = new StringBuilder(a);
        sb.append(getPrefixNotInString(sb.toString(), b));
        sb.append(getPrefixNotInString(sb.toString(), c));
        return sb.toString();
    }

    private static String getPrefixNotInString(String a, String b) {
        // System.out.println(a+" "+b);
        if (a.contains(b)) {
            return "";
        }

        StringBuilder prefix = new StringBuilder();
        int n = a.length();
        int idx = -1;
        for (int i = 0; i < b.length(); i++) {
            prefix.append(b.charAt(i));
            if (i < n && a.substring(n - i - 1).equals(prefix.toString())) {
                idx = i;
            }
        }
        return b.substring(idx+1);
    }

    private static String getSmallest(String... strings) {
        List<String> list = new ArrayList<>(Arrays.asList(strings));
        list.sort(Comparator.comparingInt(String::length).thenComparing(Comparator.naturalOrder()));
        return list.get(0);
    }
}