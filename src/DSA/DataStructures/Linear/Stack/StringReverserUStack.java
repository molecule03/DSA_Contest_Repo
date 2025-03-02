package DSA.DataStructures.Linear.Stack;

import java.util.Stack;

public class StringReverserUStack {
    public String reverseString(String input){
        if(input == null)
            throw new IllegalArgumentException();

//Creating a stack and putting all the elements in stack
        Stack<Character> stack = new Stack<>();
        for (char ch : input.toCharArray())
            stack.push(ch);

//Creating StringBuilder and append elemets from the top of the stack
        StringBuilder reversed = new StringBuilder();
        while(!stack.empty())
            reversed.append(stack.pop());

            return reversed.toString();
    }
}
