package ListStructures;

public interface ListInterface<T extends Comparable<T>> {

    /*
     * Purpose:         to add a new element to the front of our list
     * Pre-condition:   NA
     * Input:           T - data to be input into the list
     * Returns:         NA
     */
    void addFront(T data);

    /*
     * Purpose:         to add a new element to the back of our list
     * Pre-condition:   NA
     * Input:           T - data to be input into the list
     * Returns:         NA
     */
    void addBack(T data);

    /*
     * Purpose:         to remove the element at the front of the list
     * Pre-condition:   The list isnt empty
     * Input:           NA
     * Returns:         T - returns the element being removed
     */
    T removeFront() throws ListEmptyException;

    /*
     * Purpose:         to remove the element at the back of the list
     * Pre-condition:   The list is not empty
     * Input:           NA
     * Returns:         T - returns the element being removed
     */
    T removeBack() throws ListEmptyException;

    /*
     * Purpose:         takes the element at the specified position/index
     *                  in the list and move it to the back
     * Pre-condition:   The list is not empty | the list has more than one element |
     *                  the element isnt already at the baack of the list | the specified
     *                  index is within the bounds of the list
     *                  0 <= pos <= numElements-2 (numE-1 is the last element as has no change)
     * Input:           int - the position of the element to be moved
     * Returns:         NA
     */
    void moveToBack(int index) throws ListEmptyException, PosOutOfBoundsException;

    /*
     * Purpose:         insert a new element into a specific part of the list based
     *                  on comparisons with the other elements
     * Pre-condition:   the list being inserted into is already organized
     * Input:           T - data to be input into the list
     * Returns:         NA
     */
    void insertInto(T data);

    /*
     * Purpose:         to output a string of all the data elements in the list
     * Pre-condition:   the list is not empty
     * Input:           NA
     * Returns:         String - string of all the data in the list
     */
    String toString();
}