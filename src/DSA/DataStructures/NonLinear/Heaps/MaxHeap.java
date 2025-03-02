package DSA.DataStructures.NonLinear.Heaps;

public class MaxHeap{
    public static void heapify(int[] arr){
        int lastParentIndex = (arr.length/2)-1;
       for(int i=lastParentIndex; i>=0; i--)
           heapify(arr,i);
    }
    private static void heapify(int[]arr,int index){
        int largerIndex = largerIndex(arr,index);
        if(largerIndex == index)
            return;
        swap(arr, index, largerIndex);
        heapify(arr, largerIndex);
    }
    private static int largerIndex(int arr[],int index){
        int largerIndex = index;
        int leftIndex=index*2+1; int rightIndex=index*2+2;

       if( leftIndex < arr.length && arr[leftIndex]>arr[index])
           largerIndex= leftIndex;
       if(rightIndex < arr.length && arr[rightIndex]> arr[index])
           largerIndex= rightIndex;
       return largerIndex;
    }
    private static void swap(int arr[],int first,int second){
        int temp = arr[first];
        arr[first]=arr[second];
        arr[second]=temp;
    }

    private static int getKthLargest(int arr[],int k) {
        Heap heap = new Heap();
          for(int i : arr)
              heap.insert(i);

          int kthLargest = 0;
          for(int i=1; i<=k;i++)
              kthLargest = heap.remove();

          return kthLargest;
    }
}
