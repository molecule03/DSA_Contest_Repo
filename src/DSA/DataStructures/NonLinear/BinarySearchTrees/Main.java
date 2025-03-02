package DSA.DataStructures.NonLinear.BinarySearchTrees;

import java.util.ArrayList;

public class Main {
    public static void main(String []args){
        Tree tree1 = new Tree();
        Tree tree2 = new Tree();
        tree1.insert(10);
        tree1.insert(3);
        tree1.insert(12);
        tree1.insert(1);
        tree1.insert(15);
        tree1.insert(13);

        tree2.insert(10);
        tree2.insert(3);
        tree2.insert(12);
        tree2.insert(1);
        tree2.insert(15);
        tree2.insert(16);
//        tree.insert(120);
//        tree.insert(13);
//        tree.insert(23);
//        tree.insert(93);
//        tree.insert(45);
//        tree.insert(956);
//        tree.insert(978);
//        tree.insert(91);

//        System.out.println(tree.minValue());
         tree1.traverseLevelOrder();
//  System.out.println(tree1.traverseLevelOrder());
        System.out.println(tree1.height());
        System.out.println();

    }
}
