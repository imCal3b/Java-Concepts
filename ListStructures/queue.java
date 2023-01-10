package ListStructures;

public class queue<T extends Comparable<T>> {
    private LinkedNodeList<T> queue;
    private int size;

    public queue() {
        queue = new LinkedNodeList<T>();
        size = 0;
    }

    public void addToQueue(T element) {
        queue.addBack(element);
        size++;
    }
    
    public T removeFromQueue() {
        return queue.removeFront();
    }

    public T frontElement() {
        return queue.head.getData();
    }

    public int size() {
        return size;
    }

    public void clear() {
        queue.clear();
    }
}
