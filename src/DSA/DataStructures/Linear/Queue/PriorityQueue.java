package DSA.DataStructures.Linear.Queue;

import java.util.Arrays;

public class PriorityQueue {
    private int[] items = new int[5];
   private int count;

    public void insert(int item) {
        if(count == items.length)
            resize_items();
        int i;
        for (i = count-1; i >= 0; i--) {
            if (items[i] > item)
                items[i +1] = items[i];
            else
                break;
        }
            items[i + 1] = item;
        count++;
    }

    private void resize_items() {
        int[] newItems = new int[count*2];
        for(int a=0 ;a<count;a++)
            newItems[a]=items[a];
        items=newItems;
    }

    public int remove(){
        return items[--count];
    }

    public boolean isEmpty(){
        return count==0;
    }

    @Override
    public String toString(){
        return Arrays.toString(items);
    }

}
