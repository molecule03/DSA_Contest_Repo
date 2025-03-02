package LeetCode_Contest.W357;

public class A {

    public static void main(String[] args) {

        System.out.println(finalString("string"));
    }

    //    Corrected Code in Upsolve
    public static String finalString(String s) {

        StringBuilder sb = new StringBuilder();

        for(char c : s.toCharArray()){
            if(c == 'i'){
                sb = sb.reverse();
            }
            else{
                sb.append(c);
            }
        }


        return sb.toString();
    }
}