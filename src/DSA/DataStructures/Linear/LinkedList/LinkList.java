package DSA.DataStructures.Linear.LinkedList;

public class LinkList {
    private static class Node {
        private int value;
        private Node next;

        public Node(int value) {
            this.value = value;
        }
    }


        private Node first;
        private Node last;
        private int size;

        public void addFirst(int item){
            Node newNode = new Node(item);
            if(first == null){
                first = last = newNode;
            }
            else{
                newNode.next = first;
                first = newNode;
            }
            size++;
        }

        public void addLast(int item){
            Node newNode = new Node(item);

            if(first == null){
                first = last = newNode;
            }
            else{
                last.next = newNode;
                last = newNode;
            }
            size++;
        }

        public void deleteFirst(){
            if(first == null){
                throw new IllegalArgumentException();
            }

            if(first == last){
                first = last = null;
            }
            else {
                Node sec = first.next;
                first.next = null;
                first = sec;
            }
            size--;
        }

        public void deleteLast(){
            if(first == null){
                throw new IllegalArgumentException();
            }

            if(first == last){
                first = last = null;
            }
            else {
                Node preNode = first;
                while (preNode.next != last) {
                    preNode = preNode.next;
                }
                last = preNode;
                last.next = null;
            }
            size--;
        }

        public void reverseList(){
            Node preNode = first;
            Node currNode = first.next;
            while(currNode != null){
                Node nextNode = currNode.next;
                currNode.next = preNode;
                preNode = currNode;
                currNode = nextNode;
            }
            last = first;
            last.next = null;
            first = preNode;
        }

        public int indexOf(int item) {
            int index = 0;
            Node curr = first;
            while(curr != null){
                if(curr.value == item) return item;
                curr = curr.next;
                index++;
            }
            return -1;
        }

        public int getKthNodeFromEnd(int k){
            Node firPointer = first;
            Node secPointer = first;
            for(int i=0; i<(k-1); i++){
                secPointer = secPointer.next;
                if(secPointer == null) throw new IllegalArgumentException();
            }
            while(secPointer != last){
                secPointer = secPointer.next;
                firPointer = firPointer.next;
            }
            return firPointer.value;
        }

        public int[] toArray(){
            int [] arr = new int[size];
            int index =0;
            Node currNode = first;

            while(currNode != null){
                arr[index++] = currNode.value;
                currNode = currNode.next;
            }
            return arr;
        }


    }
