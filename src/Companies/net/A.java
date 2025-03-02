package Companies.net;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class A {

    public static void main(String[] args) {

        char arr[] = {'Y', 'X', 'Y', 'Z', 'Z', 'X', 'X', 'Z', 'Y', 'Z', 'Y', 'X', 'Y'};
        int fix[] =  {0,    0,   0,   1,   0,   0,   1   ,1   ,0   ,0   ,1   ,0   ,0};

        System.out.println(Arrays.toString(solve(arr, fix)));
    }

    public static char[] solve(char arr[], int fix[]){

        Map<Character, Integer> map = new HashMap<>();

        for(char c : arr){
            map.put(c, map.getOrDefault(c, 0)+1);
        }
        for(int i =0; i<fix.length; i++){
            if(fix[i] == 1){
                map.put(arr[i], map.getOrDefault(arr[i], 0)-1);
            }
        }
        System.out.println(map);

//        for()
        char res[] = new char[arr.length];
        int idx = 0;
        for(char c : map.keySet()){

            for(int i=0; i<map.get(c); i++){
                if(fix[idx] != 1)
                    res[idx] = c;
                else{
                    res[idx] = arr[idx];
                    i--;
                }
                idx++;
            }
        }
        return res;
    }

}
