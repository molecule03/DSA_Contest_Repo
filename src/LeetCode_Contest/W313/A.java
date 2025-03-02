package LeetCode_Contest.W313;

public class A {

    public static void main(String[] args) {

        int a = 12;
        int b = 6;
        System.out.println(commonFactors(a, b));
    }

    public static int commonFactors(int a, int b) {

        int count = 0;
        int x = a<b ? a : b;
        for(int i=1; i<=x; i++){
            if(a%i==0 && b%i==0) count++;
        }

        return count;
    }
}
