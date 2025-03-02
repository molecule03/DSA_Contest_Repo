package LeetCode_Contest.W353;

public class A {

    public static void main(String[] args) {

        int num = 9;
        int t = 2;
        System.out.println(theMaximumAchievableX(num, t));
    }

    public static int theMaximumAchievableX(int num, int t) {

        return num+t+t;
    }
}