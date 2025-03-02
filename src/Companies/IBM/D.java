package Companies.IBM;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Stack;
public class D {

   public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

//        int n = sc.nextInt();
       int n = sc.nextInt();
        String s = sc.next();
       Set<String> result = new HashSet<>();
       result.add(""); // Add the empty string
       for (int i = 0; i < n; i++) {
           result.add(String.valueOf(s.charAt(i))); // Add individual characters
       }
       generatePermutations("", s, result);

       System.out.println("Total number of strings: " + result.size());
       System.out.println("Strings: " + result);
//       int totalSubstrings = (n * (n + 1)) / 2 + 1;
//       System.out.println(totalSubstrings);
//        System.out.println(CryptographicOP(s, n));
//        System.out.println(reduceString(s));
    }

    public static int reduceString(String s){
        Stack<Character> st = new Stack<>();
        st.push(s.charAt(0));
        int n = s.length();
        for(int i=1; i<n; i++){
            char c = s.charAt(i);

            if(!st.isEmpty()){
                char last = st.peek();
                if(c == 'B' && (last == 'A' || last == 'B')) {
                    st.pop();
                    continue;
                }
            }

            st.push(c);
        }
        return st.size();
    }

    public static int CryptographicOP  (String s , int Y){

        int dec = Integer.parseInt(s, 2);
        int rem = dec%Y;

        String bin = Integer.toBinaryString(rem);

        return Integer.parseInt(bin, 2);
    }

    private static void generatePermutations(String prefix, String remaining, Set<String> result) {
        int n = remaining.length();
        if (n == 0) {
            result.add(prefix);
        } else {
            for (int i = 0; i < n; i++) {
                generatePermutations(prefix + remaining.charAt(i), remaining.substring(0, i) + remaining.substring(i + 1), result);
            }
        }
    }
}
