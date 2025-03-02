package DSA.DataStructures.Linear.Arrays;

public class Array {
    private int[] items;
    private int count;

//  Creating Constructor and passing length of Array.
    public Array(int length) {
       items= new int[length];
    }

    public void insert(int item){
        //If the Array is full,resize it
        if(items.length == count){
            // Creating a new Array(twice the size)
            int [] newItem = new int[count * 2];
            // Copy all the existing items.
            for(int i=0; i < count; i++) {
                newItem[i] = items[i];
            }
            //Set "items" to this new Array
            items = newItem;
        }
        //Adding new item at the end of array
        items[count++] = item;
    }

    public void removeAt(int index) {
        if (index <0 ||  index >= count)
            throw new IllegalArgumentException();

        for(int i = index; i<count; i++) {
            items[i] = items[i + 1];
        }
        count--;
    }

    public int indexOf(int item){
        for(int i=0; i<count ;i++)
            if(items[i] == item) {
                return i;
            }
        return-1;
    }

    //Iterating all the Elements in Array and Printing them.
    public void print() {
        for (int i = 0; i < count; i++)
            System.out.println(items[i]);
    }

}