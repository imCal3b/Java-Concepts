package ListStructures;

public class LinkedNodeList<T extends Comparable<T>> implements ListInterface<T> {

    Node<T> head;
    Node<T> tail;

    int numElements;

    public LinkedNodeList() {
        head = null;
        tail = null;
        numElements = 0;
    }

    public void addFront(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            numElements++;
        } else {
            head.prev = newNode;
            newNode.next = head;

            head = newNode;
            numElements++;
        }
    }

    public void addBack(T data) {
        Node<T> newNode = new Node<T>(data);

        if (isEmpty()) {
            head = newNode;
            tail = newNode;
            numElements++;
        } else {
            tail.next = newNode;
            newNode.prev = tail;

            tail = newNode;
            numElements++;
        }
    }

    public T removeFront() {
        if (isEmpty()) return null;

        if (numElements == 1) {
            T returnData = head.getData();

            head = null;
            tail = null;
            numElements = 0;

            return returnData;
        } else {
            T returnData = head.getData();

            head = head.next;
            head.prev = null;
            numElements--;

            return returnData;
        }
    }

    public T removeBack() {
        if (isEmpty()) return null;

        if (numElements == 1) {
            T returnData = tail.getData();

            head = null;
            tail = null;
            numElements = 0;

            return returnData;
        } else {
            T returnData = tail.getData();

            tail = tail.prev;
            tail.next = null;
            numElements--;

            return returnData;
        }
    }

    public void moveToBack(int pos) {
        if (pos < 0 || pos > numElements) return;
        if (isEmpty()) return;

        if (pos+1 == numElements) {
            // nothing happens as were at the last element
        } else if (pos == 0 && numElements > 1) {
            head.prev = tail;
            tail.next = head;

            tail = head;
            head = head.next;

            head.prev = null;
            tail.next = null;
        } else {
            Node<T> cur = head;
            int count = 0;
            while (cur.next != null) {
                if (pos == count) {
                    cur.next.prev = cur.prev;
                    cur.prev.next = cur.next;

                    tail.next = cur;
                    cur.prev = tail;
                    cur.next = null;

                    tail = cur;
                    return;
                }
                cur = cur.next;
                count++;

            }
            // if code gets here, nothing happens as were at the last element
        }
    }

    public void insertInto(T data) {
        if (isEmpty()) addFront(data);

        Node<T> newNode = new Node<T>(data);
        if (newNode.compareTo(head) <= 0) {
            addFront(data);
            return;
        } else if (newNode.compareTo(tail) >= 0) {
            addBack(data);
            return;
        }

        Node<T> cur = head;
        while (cur.next != null) {
            if (newNode.compareTo(cur) >= 0 && newNode.compareTo(cur.next) < 0) {
                newNode.prev = cur;
                newNode.next = cur.next;

                cur.next.prev = newNode;
                cur.next = newNode;

                numElements++;
            }
            cur = cur.next;
        }
    }

    public int size() {
        return numElements;
    }

    public boolean isEmpty() {
        return numElements == 0;
    }

    public void clear() {
        head = null;
        tail = null;
        numElements = 0;
    }

    // __________________________________
    // Methods for provided tester
    public String frontToBack() {
		String result = "{";
		Node<T> cur = head;
		while (cur != null) {
			result += cur.getData();
			cur = cur.next;
		}
		result += "}";
		return result;
	}
	
	public String backToFront() {
		String result = "{";
		Node<T> cur = tail;
		while (cur != null) {
			result += cur.getData();
			cur = cur.prev;
		}
		result += "}";
		return result;
	}
    // __________________________________

    public String toString() {
        String result = "{";

        Node<T> cur = head;
        while (cur != null) {
            result += cur.getData();

            cur = cur.next;
        }
        result += "}";

        return result;
    }
    
}
