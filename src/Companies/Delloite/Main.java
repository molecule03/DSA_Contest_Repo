package Companies.Delloite;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        concatenatedCount(s);

//        System.out.println(findNextEven(99));
    }
     public static int findNextEven( int n){
        int nextEven = 0;

        if(n%2 == 0) nextEven = n+2;
        else nextEven = n+1;

        return nextEven;
    }
    public static void  concatenatedCount(String s){

        String[] arr = s.split(" ");

        List<Integer> list = new ArrayList<>();
        for(String cur : arr){

            int count = 0;

            for(int i=1; i<cur.length();i++){
                char prev = cur.charAt(i-1);
                char now = cur.charAt(i);
                if(prev < now) count++;
            }
            list.add(count);
        }
//        System.out.println(Arrays.toString(arr));
        StringBuilder sb = new StringBuilder();
        for(int i : list){
            sb.append(i);
        }

        System.out.println(sb.toString());
    }
}
