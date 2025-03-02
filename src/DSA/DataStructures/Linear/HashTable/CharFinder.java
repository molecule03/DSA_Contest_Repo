package DSA.DataStructures.Linear.HashTable;
import java.util.HashSet;
import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class CharFinder {

 public static char  findFirstNonRepeatingChar(String str){
     Map<Character, Integer> map = new HashMap<>();
     char[] chars = str.toCharArray();
     for(char ch : chars){
         map.put(ch, map.getOrDefault(ch,0)+1);
     }
     System.out.println(map);
     for(char ch : chars) {
         if (map.get(ch) == 1)
         return ch;
     }
     return Character.MIN_VALUE;
 }

 public static char findFirstRepeatingChar(String str) {
     Set<Character> set = new HashSet<>();
     for (char ch : str.toCharArray()) {
         if(set.contains(ch))
             return ch;
         set.add(ch);
     }
return Character.MIN_VALUE;
     }
}
