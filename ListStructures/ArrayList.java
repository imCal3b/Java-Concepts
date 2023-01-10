package ListStructures;

/*
 * using non-generic implementation for writing purposes.
 *      generic arrays cannot be defined, the type of the array
 *      must be defined beforehand.
 * 
 * code is written to show how an arrayList class would be implemented.
 */
public class ArrayList implements ListInterface {

    final static int DEFAULT_SIZE = 100;
    Integer[] list;
    int numElements;

    public ArrayList() {
        list = new Integer[DEFAULT_SIZE];
        numElements = 0;
    }

    public ArrayList(int size) {
        list = new Integer[size];
        numElements = 0;
    }

    public void addFront(Integer data) {
        if (numElements == 0) {
            list[0] = data;
            numElements++;
        } else {
            if (numElements == list.length) list = scale(list);

            list = shuffle(list);
            list[0] = data;
            numElements++;
        }
    }

    private Integer[] scale(Integer[] listIn) {
        Integer[] listOut = new Integer[listIn.length*2];

        for(int i=0; i<listIn.length; i++) listOut[i] = listIn[i];

        return listOut;
    }
    
    private Integer[] shuffle(Integer[] list) {
        for (int i=numElements-1; i>=0; i--) list[i+1] = list[i];

        return list;
    }

    public void addBack(Integer data) {
        if (numElements == list.length) list = scale(list);

        list[numElements] = data;
        numElements++;
    }

    public Integer removeFront() {
        if (numElements == 0) return null;

        Integer temp = list[0];
        for (int i=1; i<numElements; i++) list[i-1] = list[i];

        numElements--;
        return temp;
    }

    public Integer removeBack() {
        if (numElements == 0) return null;
        
        numElements--;
        return list[numElements];
    }
}



