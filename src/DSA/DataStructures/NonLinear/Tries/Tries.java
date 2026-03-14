package DSA.DataStructures.NonLinear.Tries;

public class Tries {
    private final int ALPHABET_SIZE=26;

    // Node contains current value and child array which contains all the next alphabets
    private class Node{
        char value;
        Node[] children = new Node[ALPHABET_SIZE];
        boolean isEndOfWord;

        public Node(char value){
            this.value = value;
        }
        @Override
        public String toString(){
            return "value: "+value;
        }
    }

    private Node root = new Node(' ');

    public void insertWord(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch -'a';
            if(current.children[index]==null) {
                current.children[index]=new Node(ch);
            }
            current = current.children[index];
        }
        current.isEndOfWord = true;
    }

    public boolean containsWord(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(current.children[index] != null){
                current = current.children[index];
            }
            else{
                return false;
            }
        }
        return current.isEndOfWord;
    }

    public boolean startsWith(String word){
        Node current = root;
        for(char ch : word.toCharArray()){
            int index = ch-'a';
            if(current.children[index] != null){
                current = current.children[index];
            }
            else{
                return false;
            }
        }
        return true;
    }
}
