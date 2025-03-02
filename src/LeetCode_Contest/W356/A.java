package LeetCode_Contest.W356;


public class A {

    public static void main(String[] args) {

        int hours[] ={0,1,2,3,4};
        int target = 2;
        System.out.println(numberOfEmployeesWhoMetTarget(hours, target));
    }

    //    Corrected Code in Upsolve
    public  static int numberOfEmployeesWhoMetTarget(int[] hours, int target) {

        int count = 0;
        for(int h : hours){
            if(h >= target) count++;
        }

        return count;

    }
}