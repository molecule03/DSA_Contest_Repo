package DSA.DataStructures.Linear.Stack;

import java.util.Arrays;
import java.util.Stack;

public class StackuArray<T> {
    private T stack[];
    private int count = 0;

    @SuppressWarnings("unchecked")
    public StackuArray() {
        // You can't do new T[5], so we use (T[]) new Object[5]
        stack = (T[]) new Object[5];
    }


    public void  push (T item){
        if(count == stack.length)
            throw new StackOverflowError();
        stack[count++]=item;
    }

    public T pop(){
        if (count == 0)
            throw new IllegalStateException("Stack is empty");
        return stack[--count];
    }

    public T peek(){
        if (count == 0)
            throw new IllegalStateException("Stack is empty");
        return stack[count-1];
    }

    @Override
    public String toString(){
        T[] content = Arrays.copyOfRange
               (stack,0, count);
       return Arrays.toString(content);
    }



}
