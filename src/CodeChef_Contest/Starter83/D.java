package CodeChef_Contest.Starter83;

//package CodeChef.Starter83;

import java.util.Scanner;

//import java.util.Scanner;

public class D {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0) {
            int n = sc.nextInt();
            int f = sc.nextInt();
            int b = sc.nextInt();
            String s = sc.next();
            String p = "";
            for(int i = 0; i < n; i++) {
                char c = s.charAt(i);
                while(b != 0 && f == 0) {
                    if(c-'a' > 0 && (c+f) < 123) {
                        c--;
                        b--;
                    }
                    else if((c+f) > 122) {
                        f--;
                        c++;
                    }
                    else {
                        break;
                    }
                }

                while(b != 0 && f != 0) {
                    if(c-'a' > 0 && (c+f) < 123) {
                        c--;
                        b--;
                    }
                    else if((c+f) > 122) {
                        f--;
                        c++;
                    }
                    else {
                        break;
                    }
                }

                if(c > 122) {
                    c -= 26;
                }
                p += c;
            }
            System.out.println(p);
        }
        sc.close();
    }
}

