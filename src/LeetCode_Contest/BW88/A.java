package LeetCode_Contest.BW88;

import java.util.*;

/**
 * The A class contains the main method and a static method to check if a given string has equal frequency of characters.
 */
public class A {
    public static void main(String[] args) {

        System.out.println("keep it up Lavesh");

        String word1 = "aazz";
        String word2 = "abcc";
        System.out.println(equalFrequency(word1));
    }

    /**
     * Checks if the given word has equal frequency of characters.
     *
     * The equalFrequency method takes a string word as input and returns a boolean value indicating whether the word has
     * equal frequency of characters. It uses a HashMap to store the characters of the word and their frequencies. It
     * then iterates through the characters of the word and updates their frequencies in the HashMap.
     * Next, the method creates a list to store the frequencies of the characters and sorts it in ascending order.
     * It then iterates through each character in the word and checks if all frequencies in the set are the same.
     * If they are, it returns true.
     * If the frequencies are not all the same, the method counts the number of frequencies that are equal to 1.
     * If the count is equal to the length of the word, it means that all characters have a frequency of 1, and it returns true.
     * Otherwise, it returns false.
     * Overall, the equalFrequency method uses a HashMap and sets to determine if the word has equal frequency of characters.
     * It has a time complexity of O(n), where n is the length of the word, due to the iteration through the characters
     * and the creation of the HashMap and sets.
     *
     * @param word The input string.
     * @return True if the word has equal frequency of characters, false otherwise.
     */
    public static boolean equalFrequency(String word) {

        // Create a HashMap to store the characters of the word and their frequencies
        Map<Character, Integer> map = new HashMap<>();

        // Iterate through each character in the word and update its frequency in the HashMap
        for (char c : word.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // Create a list to store the frequencies of the characters
        List<Integer> list = new ArrayList<>();
        for (int val : map.values()) {
            list.add(val);
        }

        // Sort the list in ascending order
        Collections.sort(list);

        int count = 0;

        // Iterate through each character in the word
        for (char key : map.keySet()) {
            int val = 0;
            Set<Integer> set = new HashSet<>();

            // Iterate through each character in the word again
            for (char k : map.keySet()) {
                // Check if the current character is the same as the outer loop character
                if (key - 'a' == k - 'a') {
                    // Check if the frequency of the character is greater than 1
                    if (map.get(key) - 1 > 0) {
                        set.add(map.get(key) - 1);
                    }
                    continue;
                }
                set.add(map.get(k));
            }

            // Check if all frequencies in the set are the same
            if (set.size() == 1) {
                return true;
            }
        }

        // Count the number of frequencies that are equal to 1
        for (int i : list) {
            if (i == 1) {
                count++;
            }
        }

        // Check if the count is equal to the length of the word
        if (count == word.length()) {
            return true;
        }

        return false;
    }
}
