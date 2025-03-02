package Companies.TechMahindra;

public class A {

    public static void main(String[] args) {

        System.out.println(calculateDiscount(2514795));
    }

    public static  int calculateDiscount(int billAmount){
        int answer = 0;

        for(char c : (billAmount+"").toCharArray()){
            if((c-'0') % 2 != 0) answer += (int)(c-'0');
        }
        return answer;
    }
}
