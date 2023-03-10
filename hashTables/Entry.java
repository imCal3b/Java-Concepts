package hashTables;

public class Entry<K extends Comparable<K>,V> {

    final K key;
    V value;

    public Entry(K key, V value) {
        super();
        this.key = key;
        this.value = value;
    }
    
    public int hashCode() {
        int hashkey = key != null ? key.hashCode() : 0;
        int hashvalue = value != null ? value.hashCode() : 0;

        return (hashkey + hashvalue) * hashvalue + hashkey;
    }

    public boolean equals(Object other) {
        if (other instanceof Entry) {           // Entry class was written this way by instructor.
            Entry otherEntry = (Entry) other;   // can statement be written in another way to eliminate caution?

            return ((this.key == otherEntry.key ||
                (this.key != null && otherEntry.key != null && this.key.equals(otherEntry.key))) && 
                    (this.value == otherEntry.value || 
                        (this.value != null && otherEntry.value != null && this.value.equals(otherEntry.value))));
        }
        return false;
    }
    
    public String toString() {
        return "(" + key + ", " + value + ")";
    }

    public K getKey() {
        return key;
    }

    public V getValue() {
        return value;
    }

    public void setValue(V value) {
        this.value = value;
    }
}
