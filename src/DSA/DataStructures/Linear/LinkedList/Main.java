package DSA.DataStructures.Linear.LinkedList;


import java.util.Arrays;

public class Main {
    public static void main(String [] args){
        LinkList list = new LinkList();
        list.addFirst(2);
        list.addFirst(1);
        list.addLast(3);
        list.addLast(4);
        System.out.println(Arrays.toString(list.toArray()));
        System.out.println(list.getKthNodeFromEnd(2));

//        list.reverseList();
//        list.deleteFirst();
//        list.deleteLast();
        System.out.println();
    }
}
