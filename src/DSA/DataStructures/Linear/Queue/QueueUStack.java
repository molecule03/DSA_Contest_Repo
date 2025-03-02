package DSA.DataStructures.Linear.Queue;
import java.util.Stack;

public class QueueUStack {
    Stack<Integer> stack1 = new Stack<>();
    Stack<Integer> stack2 = new Stack<>();

    public void enque(int item){
       stack1.push(item);
    }

    public int dequeue(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1toStack2();
        return stack2.pop();
    }

    public int peek(){
        if(isEmpty())
            throw new IllegalStateException();
        moveStack1toStack2();
        return stack1.peek();
    }

    private void moveStack1toStack2() {
        if(stack2.isEmpty())
            while(!stack1.isEmpty())
            stack2.push(stack1.pop());
    }

    public boolean isEmpty(){
        return (stack1.isEmpty() && stack2.isEmpty());
    }

}
