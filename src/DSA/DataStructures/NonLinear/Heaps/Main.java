package DSA.DataStructures.NonLinear.Heaps;
import java.util.Arrays;

public class Main {
    public static void main(String[] args){
        int num[] ={5,3,8,4,1,2};
        MaxHeap.heapify(num);

        System.out.println(Arrays.toString(num));

//                HeapSorrt

//        int myarr[]={9,1,2,8,3,4,7,5,6,0};
//        Heap heap = new Heap();
//        for(int i : myarr)
//            heap.insert(i);
//        for(int i=myarr.length-1; i>=0;i--){
//            myarr[i]=heap.remove();
//        }
//        System.out.println(Arrays.toString(myarr));
    }
}
