package LeetCode_Contest.W336;

import java.util.HashSet;
import java.util.Set;

public class A {
    public static void main(String[] args) {

        String[] words = {"hey","aeo","mu","ooo","artro"};
        int left = 1;
        int right = 4;
        System.out.println(vowelStrings(words, left, right));
    }

    public static int vowelStrings(String[] words, int left, int right) {

        int count = 0;
        Set<Character> set = new HashSet<>();
        set.add('a');
        set.add('e'); set.add('i');
        set.add('o');
        set.add('u');

        for(int i=left; i<=right; i++){
            String w = words[i];


            if(set.contains(w.charAt(0)) && set.contains(w.charAt(w.length()-1)) )
                count++;

        }

        return count;
    }

}
