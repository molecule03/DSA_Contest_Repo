package Companies.TechMahindra;

public class B {

    public static void main(String[] args) {

//        if ( System.out.print(0) != null){
//
//        }


    }

    public  static int productsAtNegativeTemp(int[] temparature){

        int answer = 0;

        for(int t : temparature) if(t < 0) answer++;

        return answer;
    }
}
