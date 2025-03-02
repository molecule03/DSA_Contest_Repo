package Companies.IBM;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class A {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<String> rows = new ArrayList<>();
        rows.add("AXDER");
        rows.add("SUJQW");
        rows.add("YTMBC");
        rows.add("OLFGH");


        char alphabet = 'M';

        findPrecedingAlphabets(rows, alphabet);
    }

    public static void findPrecedingAlphabets(List<String> rows, char alphabet){

        int n = rows.size();
        int r = 0;
        int c = 0;
        boolean  f = false;
        for(int i=0; i<n; i++){
            String cur = rows.get(i);
            for(int j=0; j<n; j++){
                if(cur.charAt(j) == alphabet){
                    r = i;
                    c = j;
                    f = true;
                    break;
                }
            }
            if(f) break;
        }

        for(int i=0; i<c; i++){
            String s = rows.get(r);
            System.out.print(s.charAt(i));
        }
        System.out.println("");
        for(int i=0; i<r; i++){
            String s = rows.get(i);
            System.out.print(s.charAt(c));
        }
    }

    public static int minOperations(int n) {
        int minCount=0;
        int res=0;
        int flag=0;

        while(n>0){
            if(n%2==0){
                minCount++;
                if(flag<=1){
                    res+=flag;
                    flag=0;
                } else{
                    res+=1;
                    flag=1;
                }
            }else{
                flag++;
            }
            n/=2;
        }

        res += (flag<=1)? flag:2;

        return Math.min(minCount+2, res);
    }
}
