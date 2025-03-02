package Companies.TCS.src;

import java.util.Scanner;

public class MyClass {

    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int D[] = new int[n];
        for(int i=0; i<n; i++){
            D[i] = sc.nextInt();
        }

        int ans =  solve(n, D);
        System.out.println(ans);
    }

    public static int solve(int n, int[] D){

        int count = 0;

        for(int i=0; i<n-1; i++){
            if(D[i+1] != D[i]) count++;
        }

        if(count == 0){
            return 0;
        }
        else {
            return count+1;
        }





//        if(A.length() != B.length()) return -1;
//
//        Set<Character> aSet = new HashSet<>();
//        Set<Character> bSet = new HashSet<>();
//
//        for(char c : A.toCharArray()) aSet.add(c);
//        for(char c : B.toCharArray()) bSet.add(c);
//
//        for(char c : bSet){
//            if(!aSet.contains(c))
//                return -1;
//        }
//
//        Set<String> diffSet = new HashSet<>();
//        for(int i=0; i<A.length(); i++){
//            char aChar = A.charAt(i);
//            char bChar = B.charAt(i);
//
//            if(bChar > aChar) return -1;
//            if(aChar != bChar)
//                diffSet.add(aChar+" "+bChar);
//        }
//        return diffSet.size();
    }

}

