package hashTables;
import java.util.List;

public interface MapInterface<K extends Comparable<K>,V> {
    
    /*
     * Purpose:         Check to see if a given key is stored in the map
     * Pre-condition:   NA
     * Returns:         Boolean - true if key is in map | false otherwise
     */
    boolean containsKey(K key);

    /*
     * Purpose:         Return the value stored at key in the map
     * Pre-condition:   NA
     * Returns:         the value stored at key
     * Throws:          KeyNotFoundException if key is not in the map
     */
    V get(K key) throws KeyNotFoundException;

    /*
     * Purpose:         Return a list of Entry types which contain the key/value
     *                  pairs of every entry in the map
     * Pre-condition:   NA
     * Returns:         List<Entry<K,V>> - an instance of a list with all the
     *                  key/value pairs in the list
     */
    List<Entry<K,V>> entryList();

    /*
     * Purpose:         Insert the key/value pair into the map. if the key already
     *                  exists in the map, update the value at the entry.
     * Pre-condition:   NA
     * Returns:         NA
     */
    void put(K key, V value);

    /*
     * Purpose:         Return the number of elements in the map
     * Pre-condition:   NA
     * Returns:         int - the number of elements in the map
     */
    int size();

    /*
     * Purpose:         remove all elements from the map
     * Pre-condition:   NA
     * Returns:         NA
     */
    void clear();



}
