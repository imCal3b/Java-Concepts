package BSTExample;
import TreeStructures.*; // * is used to insert all the methods from the TreeStructures package
import java.util.*;

public class Main {
    public static void main(String[] args) {
        int[] keys = {7,4,11,3,6,9,14,8,10};
        String[] values = {"Science","Exam","Programming","Fun","Summer","Recursion","Implementation","Computer","Parameters"};

        BinarySearchTree<Integer,String> bst = new BinarySearchTree<Integer,String>();

        arrToTreeInsert(bst,keys,values);

        printTree(bst,1);
        printTree(bst,2);
        printTree(bst,3);

    }

    public static void arrToTreeInsert(BinarySearchTree<Integer,String> bst, int[] keys, String[] values) {

        for (int i=0; i<keys.length; i++) {
            bst.insert(keys[i],values[i]);
        }
    }

    public static void printTree(BinarySearchTree<Integer,String> bst, int orderType) {
       
        List<Entry<Integer,String>> entryList;
        switch (orderType) {
            case 2:
                System.out.println("postOrder");
                entryList = bst.entryList(2);
                break;
            case 3:
                System.out.println("inOrder");
                entryList = bst.entryList(3);
                break;
            default:
                System.out.println("preOrder");
                entryList = bst.entryList(1);
            break;
        }

        Iterator<Entry<Integer,String>> iter = entryList.iterator();

        while (iter.hasNext()) {
            Entry<Integer,String> item = iter.next();
            System.out.print(item + ",");
        }
        System.out.println("\n");

    }
}
