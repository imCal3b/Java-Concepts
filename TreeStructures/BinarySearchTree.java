public class BinarySearchTree<K extends Comparable<K>,V> {
    /*
     * the BinarySearchTree class is a data structure that uses the BiTreeNode
     * to define the linked segments of the tree structure.
     * 
     * Because the nodes used for the search tree are generic, the search tree
     * itself must also be generic.
     */

     BiTreeNode<K,V> root;
     int count;

     public BinarySearchTree() {
        root = null;
        count = 0;
     }
    
}
