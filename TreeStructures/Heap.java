package TreeStructures;
/*
 * this Heap is designed as a Maximum Heap.
 * the largest value will reside at the top or highest
 * priority of the queue.
 */
public class Heap {
    Integer[] data;
    int numElements;
    int rootIndex = 0;

    public Heap() {
        data = new Integer[1000];
        numElements = 0;
    }

    public Heap(int size) {
        data = new Integer[size];
        numElements = 0;
    }

    public void insert(Integer val) {
        if (numElements == data.length) data = scale(data);

        if (isEmpty()) {
            data[0] = val;
            numElements++;
        } else {
            data[numElements] = val;

            bubbleUp(numElements);
            numElements++;
        }
    }

    private Integer[] scale(Integer[] oldArr) {
        Integer[] newArr = new Integer[oldArr.length*2];

        for (int i=0; i<oldArr.length; i++) newArr[i] = oldArr[i];

        return newArr;
    }

    public Integer removeMax() {
        if (isEmpty()) return null;

        if (numElements == 1) {
            numElements = 0;
            return data[0];
        } else {
            numElements--;
            Integer temp = data[0];

            data[0] = data[numElements];
            bubbleDown(rootIndex);

            return temp;
        }
    }

    public void bubbleUp(int index) {
        if (index == rootIndex) return;

        int parentIndex = (index-1)/2;

		if(data[parentIndex] < data[index]) {
			int temp = data[parentIndex];

			data[parentIndex] = data[index];
			data[index] = temp;

			bubbleUp((index-1)/2);
		} else {
			return;
		}

    }

    public void bubbleDown(int index) {

    }

    public boolean isEmpty() {
        return numElements == 0;
    }
    
}
