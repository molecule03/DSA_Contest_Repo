package DSA.DataStructures.Linear.Queue;

import java.util.Arrays;

public class QueueUArray {
    private int[] items = new int[5];
        private int front = 0;
        private int back= 0;
        private int count=0;

    public void enqueue(int item){
//        if(isFull()) throw new IllegalArgumentException();
        items[back] = item;
        back=(back+1)%items.length;
        count++;
    }

    public int dequeue() {
        int  removed = items[front];
        items[front]=0;
        front = (front +1)%items.length;
        count--;
        return removed;
    }

    public int peek(){
        return items[(back)];
    }

    public boolean isEmpty(){
        return count == 0;
    }

    public boolean isFull(){return count == items.length;}

@Override
    public String toString() {
    return Arrays.toString(items) ;

    }
}
