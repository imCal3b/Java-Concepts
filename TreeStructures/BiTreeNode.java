public class BiTreeNode<K extends Comparable<K>,V> {
    /*
     * BiTreeNode class defines the basic element of a linked tree data structure.
     * This tree node can only be used for binary tree structures.
     * 
     * This node class is generic and defined to work with a key/value pair. This
     * node class can work with any object for the key or value.
     * 
     * the key object also extends the comparable object so that we can utilize
     * the comparable functions to organize our nodes within the structure.
     */

     private K key; // key for storing and finding node
     V value; // data stored in node
    
     BiTreeNode<K,V> leftChild;
     BiTreeNode<K,V> rightChild;

     public BiTreeNode(K key) {
         this.key = key;

         leftChild = null;
         rightChild = null;
     }

     public BiTreeNode(K key, V value) {
        this.key = key;
        this.value = value;

        leftChild = null;
        rightChild = null;
     }

     public String toString() {
      String s = "K: " + key + " | V: " + value + "\n";
      return s;
     }
}
