package ListStructures;

public class Node<T> {
    /*
     * Node class defines the basic element to be useed in a linked list
     * style of data structure.
     * 
     * This node class is generic and can be used with any object type
     */

    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }

    public void setData(T newData) {
        this.data = newData;
    }

    public T getData() {
        return data;
    }

    public void setNext(Node<T> next) {
        this.next = next;
    }

    public void setPrev(Node<T> prev) {
        this.prev = prev;
    }

    public Node<T> getNext() {
        return next;
    }

    public Node<T> getPrev() {
        return prev;
    }
}