package DSA.DataStructures.Linear.Stack;

import java.util.EmptyStackException;

public class StackuLinkedList {
    private int count =0;
    private Node head =null;


    private class Node {
        Node next;
        int value;

        public Node(int value) {
            this.value = value;
        }
    }

        public void push(int input){
            Node node = new Node(input);
            node.next = head;
            head = node;
            count++;
        }

        public int pop(){
        if(head == null)
            throw new EmptyStackException();
        int removed = head.value;
             head = head.next;
            count --;
             return removed;
        }

        public int peek(){
        return head.value;
        }

    public int[] toArray(){
        int[] array = new int[count];
        while(head != null) {
            array[count-1] = head.value;
            head = head.next;
            count--;
        }
        return array;
    }
        }

