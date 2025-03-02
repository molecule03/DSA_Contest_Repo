package DSA.DataStructures.NonLinear.AVLTrees;

public class AVLTree {
    private class AVLNode{
        public int height;
        private AVLNode leftChild;
        private AVLNode rightChild;
        private int value;

        public AVLNode(int value){
            this.value = value;
        }

        @Override
        public String toString() {
            return "Node=" + value;
        }
    }
    private AVLNode root;

    public void insert(int value){
       root = insert(value,root);
    }
    private AVLNode insert(int value,AVLNode root){
        AVLNode newNode = new AVLNode(value);
        if(root == null) {
            return newNode;
        }
        if(value < root.value) {
            root.leftChild =insert(value, root.leftChild);
        }
        else {
          root.rightChild =insert(value, root.rightChild);
        }


      setHeight(root);
        return  balance(root);
    }

    private AVLNode balance(AVLNode root){
        if(isLeftHeavy(root)) {
            if(balanceFactor(root.leftChild) < 0)
               root.leftChild = rotateLeft(root.leftChild);
            return rotateRight(root);        }
        else if(isRightHeavy(root)) {
            if(balanceFactor(root.rightChild) > 0)
              root.rightChild = rotateRight(root.rightChild);
            return rotateLeft(root);
        }
        return root;
    }

    private AVLNode rotateRight(AVLNode root){
        AVLNode newRoot = root.leftChild;

        root.leftChild = newRoot.rightChild;
        newRoot.rightChild = root;

        setHeight(root);
        setHeight(newRoot );
        return newRoot;
    }

    private AVLNode rotateLeft(AVLNode root){
        AVLNode newRoot = root.rightChild;

        root.rightChild = newRoot.leftChild;
        newRoot.leftChild = root;

        setHeight(root);
        setHeight(newRoot );
        return newRoot;
    }
    private void setHeight(AVLNode node){
        node.height = Math.max(height(node.leftChild),height(node.rightChild))+1;
    }

    private boolean isLeftHeavy(AVLNode node){
        return balanceFactor(node) > 1;
    }
    private boolean isRightHeavy(AVLNode node){
        return balanceFactor(node) < -1;
    }
    private int balanceFactor(AVLNode node){
        return (node == null) ? 0 : height(root.leftChild)-height(root.rightChild);
    }
    
    private int height(AVLNode node){
        return(node == null) ? -1 : node.height;
    }
}
