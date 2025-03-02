package Companies.NeoSoft;
//import javafx.scene.layout.Priority;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

//    public static void camcelCase(String S) {
//
//        StringBuilder sb = new StringBuilder();
//        for (char c : S.toCharArray()) {
//            if (c >= 'A' && c <= 'Z') {
//                System.out.println(sb.toString());
//                sb = new StringBuilder();
//            }
//            sb.append(c);
//        }
//        System.out.println(sb.toString());
//    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();
        int n = s.length();
        Map<Character, Integer> map = new HashMap<>();

        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c,0)+1);
        }

        int ans = -1;
        for(int i=0; i<n; i++){
            if(map.get(s.charAt(i)) == 1){
                ans = i;
                break;
            }
        }
        System.out.println(ans);
    }
}