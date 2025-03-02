package DSA.DataStructures.NonLinear.BinarySearchTrees;

import java.util.ArrayList;

public class Tree {

    private class Node {
        private int value;
        private Node leftChild;
        private Node rightChild;

        public Node(int value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }

        private Node root;

        public void insert(int value) {
            Node node = new Node(value);
            if (root == null) {
                root = node;
                return;
            }
            Node currNode = root;
            while (true) {
                if (value < currNode.value) {
                    if (currNode.leftChild == null) {
                        currNode.leftChild = node;
                        break;
                    }
                    currNode = currNode.leftChild;
                } else {
                    if (currNode.rightChild == null) {
                        currNode.rightChild = node;
                        break;
                    }
                    currNode = currNode.rightChild;
                }
            }
        }

        public boolean find(int value){
            Node currNode = root;
            while(currNode != null){
                if(value < currNode.value)
                    currNode = currNode.leftChild;
                else if(value > currNode.value)
                    currNode = currNode.rightChild;
                else
                    return true;
            }
            return false;
        }

        public int minValue(){
            return minValue(root);
        }
        private int minValue(Node root){
//            if(root == null)
//                return -1;
//            if(root.leftChild == null && root.rightChild != null)
//                return  0;
            if(isLeafNode(root)) {
                return root.value;
            }
            int left = minValue(root.leftChild);
            int right = minValue(root.rightChild);
            return Math.min(Math.min(left,right), root.value);
        }

        public void traverseLevelOrder(){
            for(int i=0; i<=height();i++) {
                ArrayList<Integer> list =  new ArrayList<>();
                for (Object val : getNodesAtDistance(i) )
                    System.out.println(val);
            }
//            System.out.println(" ");
        }
        public void traverseInorder(Node root){
            if(root == null)
                return;
            traverseInorder(root.leftChild);
            System.out.println(root);
            traverseInorder(root.rightChild);
        }
        public void traversePreorder(Node root){
//            Node currNode = root;
            if(isLeafNode(root))
                return;
                System.out.println(root);
                traverseInorder(root.leftChild);
                traverseInorder(root.rightChild);
        }
        public void traversePostOrder(Node root){
            if(isLeafNode(root))
                return;
            traversePostOrder(root.leftChild);
            traversePostOrder(root.rightChild);
        }

        public int height(){
            return height(root);
        }
        private int height(Node root){
            if(root == null)
                return -1;
            if(isLeafNode(root))
                return 0;
            return 1+Math.max(height(root.leftChild),height(root.rightChild));
        }


        public boolean isValidBST(){
            return isValidBST(root,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
        private boolean isValidBST(Node root,int max,int min) {
            if(isLeafNode(root))
               return true;
            if(root.value<=min || root.value >=max)
                return false;

                return isValidBST(root.rightChild,max,(root.value+1))&&
                        isValidBST(root.leftChild,(root.value-1),min);
        }

public ArrayList getNodesAtDistance(int distance){
            ArrayList <Integer> list = new ArrayList<>();
            getNodesAtDistance(root,distance,list);
            return list;
    }
private void getNodesAtDistance(Node root, int distance,ArrayList list){
          if(root == null)return;
            if(distance==0) {
                list.add(root.value);
                return;
            }
            getNodesAtDistance(root.leftChild, distance-1, list);
            getNodesAtDistance(root.rightChild, distance-1,list);
}

        public boolean equals(Tree other){
            if(other == null)
                return false;
            return equals(root,other.root);
        }
        private boolean equals(Node first,Node second){
            if(first == null && second == null)
                return true;

            if(first != null && second!= null) {
                return (first.value == second.value) &&
                        (equals(first.leftChild, second.leftChild)) &&
                        (equals(first.rightChild, second.rightChild));
            }
            else{
            return false;
            }

        }

        public boolean isLeafNode(Node root){
            return(root.leftChild == null && root.rightChild == null);
        }
}
