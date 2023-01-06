package TreeStructures;


public class Entry<K extends Comparable<K>, V> {
	public final K key;
	public V value;

	public Entry(K key, V value) {
		this.key = key;
		this.value = value;
	}

	public boolean equals(Entry<K,V> other) {
		Entry<K,V> otherEntry = other;
		return this.key.equals(otherEntry.key);
	}
	
	public V getValue() {
		return value;
	}
	
	public K getKey() {
		return key;
	}

}
