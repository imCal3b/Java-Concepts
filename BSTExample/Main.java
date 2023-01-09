package BSTExample;
import TreeStructures.*; // * is used to insert all the methods from the TreeStructures package

public class Main {
    public static void main(String[] args) {
        int[] keys = {7,4,11,3,6,9,14,8,10};
        String[] values = {"Science","Exam","Programming","Fun","Summer","Recursion","Implementation","Computer","Parameters"};

        BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();

        arrToTreeInsert(bst,keys,values);


    }

    public static void arrToTreeInsert(BinarySearchTree<Integer,String> bst, int[] keys, String[] values) {

        for (int i=0; i<keys.length; i++) {
            bst.insert(keys[i],values[i]);
        }
    }
}
