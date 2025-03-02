package DSA.DataStructures.Linear.Stack;

import java.util.Stack;

public class Expression {
    public boolean isBalanced(String input){
        Stack<Character> stack = new Stack<>();

        for(char ch: input.toCharArray()){
            if(ch == '(' || ch == '<' || ch=='[' || ch == '{')
                stack.push(ch);

            else if (ch == ')'|| ch == '>' || ch==']' || ch == '}') {
                if (stack.empty()) return false;
                char top = stack.pop();
                if (    (ch == ')' && top != '(') ||
                        (ch == '>' && top != '<') ||
                        (ch == ']' && top != '[') ||
                        (ch == '}' && top != '{')
                )
                    return false;
            }

        }
        return stack.empty();
    }
}
