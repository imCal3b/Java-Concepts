package TreeStructures;
import java.util.List;
import java.util.LinkedList;


public class BinarySearchTree<K extends Comparable<K>,V> {
    /*
     * the BinarySearchTree class is a data structure that uses the BiTreeNode
     * to define the linked segments of the tree structure.
     * 
     * Because the nodes used for the search tree are generic, the search tree
     * itself must also be generic.
     */
    public static final int BST_PREORDER  = 1;
    public static final int BST_POSTORDER = 2;
    public static final int BST_INORDER   = 3;

     BiTreeNode<K,V> root;
     int count;

     public BinarySearchTree() {
        root = null;
        count = 0;
     }
    
   /* Purpose: Insert a new key-value element into the tree.  
	 *          If the key already exists in the tree, update 
	 *          the value stored at that node with the new value.
	 * Parameters: K key - the key for which the BST is ordered
    *	 		      V value - the value to associate with the key
	 * Returns: nothing
	 * Pre-Conditions: the tree is a valid binary search tree
	 */
	public void insert (K key, V value) {
		if (root==null) {
			BiTreeNode<K,V> newNode = new BiTreeNode<K,V>(key,value);
			root = newNode;
			count++;
			return;

		} else {
			try {
				BiTreeNode<K,V> replaceValueNode = findRec(root, key);
				replaceValueNode.value = value;
			} catch(KeyNotFoundException e) {
				insertRec(root, key, value);
				count++;
			}
		}
	}

   /*
	 * --My helper function--
	 * purpose: find a spot in the binary tree to insert the new element.
	 * parameters:	BiTreeNode<K,V> cur - node to start looking for open spot.
	 * 				K key - the key of the new node.
	 * 				V value - the value of the new node.
	 * Returns: nothing
	 * Pre-conditions: 	the root is not null.
	 * 					the key has not already been found in the tree.
	 */
	private void insertRec(BiTreeNode<K,V> cur, K key, V value) {
		if (cur==null) {
			cur = new BiTreeNode<K,V>(key, value);
			return;
		}

		if (cur.getKey().compareTo(key) > 0) {
			//cur is larger than newKey: go leftChild
			if (cur.leftChild==null) {
				cur.leftChild = new BiTreeNode<K,V>(key, value);
			} else {
				insertRec(cur.leftChild, key, value);
			}

		} else if (cur.getKey().compareTo(key) < 0){
			//cur is less than newKey: go rightChild
			if (cur.rightChild==null) {
				cur.rightChild = new BiTreeNode<K,V>(key, value);
			} else {
				insertRec(cur.rightChild, key, value);
			}

		// key shouldve been found previously in findRec()
		// exception was thrown because key was not found
		// else prints error message
		} else {
			System.out.println("error... Key found...");
		}	
	}

   /* 	
	 * Purpose: Get the value of the given key. 
	 * Parameters: K key - the key to search for
	 * Returns: V - the value associated with the key
	 * Pre-conditions: the tree is a valid binary search tree
	 * Throws: KeyNotFoundException if key isn't in the tree
	 */
	public V find (K key) throws KeyNotFoundException {
		BiTreeNode<K,V> foundKeyNode = findRec(root, key);

		return foundKeyNode.value;
	}

   /*
	 * --My helper method--
	 * Purpose: Look through tree for the given search key.
	 * Parameters:	BiTreeNode<K,V> cur - the node to compare keys with
	 * 				K key - the given search key to compare against each node
	 * Returns: BiTreeNode<K,V> - The node with a matching key
	 * Pre-Conditions: The tree is a valid binary search tree
	 * Throws: KeyNotFoundException if key is not in tree
	 */
	private BiTreeNode<K,V> findRec(BiTreeNode<K,V> cur, K key) throws KeyNotFoundException {
		if (cur==null) {
			throw new KeyNotFoundException();
		}
		
		if (cur.getKey().compareTo(key) < 0) {
			//the key of cur Node is less than the search key: go right
			return findRec(cur.rightChild, key);
		} else if (cur.getKey().compareTo(key) > 0) {
			//the key of cur Node is larger than the search key: go Child
			return findRec(cur.leftChild, key);
		} else {
			//the key of cur Node equals the search key
			return cur;
		}
	}

   /* 	
	 * Purpose: Get the number of nodes in the tree.
	 * Parameters: none
	 * Returns: int - the number of nodes in the tree. 
	 */
	public int size() {
		return count;
	}

	/*
	 * Purpose: Remove all nodes from the tree.
	 * Parameters: none
	 * Returns: nothing
	 */
	public void clear() {
		root = null;
		count = 0;
	}

   /* 
	 * Purpose: Get the height of the tree. 
	 * Parameters: none
	 * Returns: int - the height of the tree
	 */
	public int height() {
		int h = heightRec(root);
		return h;
	}

	private int heightRec(BiTreeNode<K,V> cur) {
		if (cur==null) return -1;

		int ChildHeight = heightRec(cur.leftChild);
		int rightHeight = heightRec(cur.rightChild);

		return Math.max(ChildHeight, rightHeight) + 1;
	}

   /* 
	 * Purpose: Return a list of all the key-value Entry elements 
	 *          stored in the tree using a level-order traversal.
	 * Parameters: None
	 * Returns: List<Entry<K,V>> - a list of key-value entries
	 */
	public List<Entry<K,V>>	entryList() {
		// list to add all the nodes to
		List<Entry<K,V>> l = new LinkedList<Entry<K,V>>();
		
		// queue of nodes that need to be added
		LinkedList<BiTreeNode<K,V>> q = new LinkedList<BiTreeNode<K,V>>();
		
		q.addLast(root);
		while(q.size() != 0) {
			BiTreeNode<K,V> cur = q.removeFirst();

			l.add(new Entry<K,V>(cur.getKey(), cur.value));

			if (cur.leftChild != null) q.addLast(cur.leftChild);
			if (cur.rightChild != null) q.addLast(cur.rightChild);
		}

		return l;
	}

/* 	
	 * Purpose: Get a list of all the key-value entries stored in the tree
	 * Parameters: int whichTraversal - the type of traversal to perform:
	 * Returns: List<Entry<K,V>> - a list of key-value entries
	 * Example: The list will be constructed by performing a traversal
	 * specified by the parameter whichTraversal.
	 * 
	 * If whichTraversal is:
	 *	 BST_PREORDER	perform a pre-order traversal
	 *	 BST_POSTORDER	perform a post-order traversal
	 *	 BST_INORDER	perform an in-order traversal
	 */
	public List<Entry<K,V> > entryList (int which) {
		List<Entry<K,V> > entries = new LinkedList<Entry<K,V> >();

		if (which == BST_PREORDER) {
			preOrderRec(root, entries);
		}
		else if (which == BST_INORDER) {
			inOrderRec(root, entries);
		}
		else if (which == BST_POSTORDER) {
			postOrderRec(root, entries);
		}
		return entries;
	}

	private void inOrderRec (BiTreeNode<K,V> n, List <Entry<K,V>> entries) {
		// the tree to the entries list with an in-order traversal
		if (n==null) return;

		inOrderRec(n.leftChild, entries);

		entries.add(new Entry<K,V>(n.getKey(), n.value));

		inOrderRec(n.rightChild, entries);
	}

	private void preOrderRec (BiTreeNode<K,V> n, List <Entry<K,V>> entries) {
		// the tree to the entries list with a pre-order traversal
		if (n==null) return;

		entries.add(new Entry<K,V>(n.getKey(), n.value));

		preOrderRec(n.leftChild, entries);

		preOrderRec(n.rightChild, entries);
	}

	private void postOrderRec (BiTreeNode<K,V> n, List <Entry<K,V>> entries) {
		// the tree to the entries list with a post-order traversal
		if (n==null) return;

		postOrderRec(n.leftChild, entries);

		postOrderRec(n.rightChild, entries);

		entries.add(new Entry<K,V>(n.getKey(), n.value));
	}



}
