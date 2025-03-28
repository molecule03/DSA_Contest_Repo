package DSA.DataStructures.NonLinear.Heaps;
import java.util.ArrayList;

public class Heap {
    int items[]= new int [10];
    private int size=0;


       public void insert(int value){
        if(isFull())
            throw new IllegalStateException();
        items[size++]= value;
        bubbleUp();
    }
           private void bubbleUp(){
             int index = size-1;
             while (index > 0 && items[index] > items[parent(index)]) {
             swap(index,parent(index));
             index = parent(index);
          }
       }
           private int parent(int index){
           return (index-1)/2;
       }

       public int remove(){
        if(isEmpty())
            throw new IllegalStateException();
        int root = items[0];
        items[0]= items[--size];
        bubbleDown();
        return root;
       }
           private void bubbleDown(){
             int index =0;
                while(index <= size && !isValidParent(index)){
                    int largerChildIndex = largerChildIndex(index);
                    swap(index,largerChildIndex);
                    index= largerChildIndex;
                }
           }
           private boolean isValidParent(int index){
             if(!hasLeftChild(index))
                 return true;
             if(!hasRightChild(index))
                 return items[index]>= leftChildIndex(index);

             return(items[index]>= leftChild(index) && items[index]>= rightChild(index));
           }
           private int largerChildIndex(int index){
             if(!hasLeftChild(index))
                 return index;
             if(!hasRightChild(index))
                 return leftChildIndex(index);

             return leftChild(index)>rightChild(index)? leftChildIndex(index) : rightChildIndex(index);
           }


           private int leftChildIndex(int index){
             return index*2+1;
           }
           private int rightChildIndex(int index){
             return index*2+2;
           }
           private int leftChild(int index){
             return items[leftChildIndex(index)];
           }
           private int rightChild(int index){
             return items[rightChildIndex(index)];
           }
           private boolean hasLeftChild(int index){
             return leftChildIndex(index) <= size;
           }
           private boolean hasRightChild(int index){
             return rightChildIndex(index) <= size;
           }

    private void swap(int first, int second){
        int temp = items[first];
        items[first] = items[second];
        items[second] = temp;
    }

    public boolean isEmpty(){
        return size == 0;
    }
    public boolean isFull(){
        return size == items.length;
    }

}

