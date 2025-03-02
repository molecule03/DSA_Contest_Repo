package Companies.TCS.src;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Sumit {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        String A = sc.next();
        String B = sc.next();
        int ans =  solve(A,  B);
        System.out.println(ans);
    }

    public static int solve(String A, String B){
        if(A.length() != B.length()) return -1;

        Set<Character> aSet = new HashSet<>();
        Set<Character> bSet = new HashSet<>();

        for(char c : A.toCharArray()) aSet.add(c);
        for(char c : B.toCharArray()) bSet.add(c);

        for(char c : bSet){
            if(!aSet.contains(c))
                return -1;
        }

        Set<String> diffSet = new HashSet<>();
        for(int i=0; i<A.length(); i++){
            char aChar = A.charAt(i);
            char bChar = B.charAt(i);

            if(bChar > aChar) return -1;
            if(aChar != bChar)
                diffSet.add(aChar+" "+bChar);
        }
        return diffSet.size();
    }

}

