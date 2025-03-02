package LeetCode_Contest.W354;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C {

//    Upsolved
    public static void main(String[] args) {

        int arr[] = {2,1,3,1,1,1,7,1,2,1};
        List<Integer> nums = new ArrayList<>();

        for(int a : arr) nums.add(a);


        System.out.println(minimumIndex(nums));
    }

  public static int minimumIndex(List<Integer> nums) {

        Map<Integer,Integer> freq = new HashMap<>();

        for(int n : nums){
            freq.put(n, freq.getOrDefault(n, 0)+1);
        }

        int max = 0;
        int cur = 0;
        for(int k : freq.keySet()){
            if(cur < freq.get(k)){
                cur = freq.get(k);
                max = k;
            }
        }

        int count = 0;
        System.out.println(max);
        int size = nums.size();
        for(int i=0; i<size; i++){
            if(nums.get(i) == max){
                count++;
            }

            if( (count*2) > (i+1) && ((cur-count)*2) > (size-i-1)){
                return i;
            }
        }

        return -1;
    }
}