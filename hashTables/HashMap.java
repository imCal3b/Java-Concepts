package hashTables;
import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Iterator;

public class HashMap<K extends Comparable<K>, V> implements MapInterface<K,V> {

	private List<List<Entry<K,V>>> 	table;
	private int	count;
	private int  tableSize;
	

	public HashMap() {
		tableSize = 1000003; // prime number 1000003
		table = new ArrayList<List<Entry<K,V>>>(tableSize);

		// initializes table as a list of empty lists
		for (int i = 0; i < tableSize; i++) {
			table.add(new LinkedList<Entry<K,V>>());
		}

		count = 0;
    }

	//----------------------------------------------------------
	public boolean containsKey(K key) {
		// TODO: complete the rest of this method
		try {
			get(key);
			return true;
		} catch (KeyNotFoundException e) {return false;}
	}

	//----------------------------------------------------------
	public V get (K key) throws KeyNotFoundException {
		// TODO: complete the rest of this method
		Entry<K,V> indexListItem = find(key);
		return indexListItem.getValue();
	}

	//----------------------------------------------------------
	//Helper function that returns the HashEntry object of a matching key
	private Entry<K,V> find(K key) throws KeyNotFoundException {
		// gets the index in the table this key should be in
		int index = Math.abs(key.hashCode()) % tableSize;
		// System.out.println("findIndex: "+index);

		Iterator<Entry<K,V>> indexList = table.get(index).iterator();
		while (indexList.hasNext()) {
			Entry<K,V> indexListItem = indexList.next();
			if (indexListItem.getKey().equals(key)) { //use .compareTo()/.equals() | comparing objects
				return indexListItem;
			}
		}

		throw new KeyNotFoundException();
	}

	//----------------------------------------------------------
	public List<Entry<K,V>> entryList() {
		List <Entry<K,V>> resultList = new LinkedList<Entry<K,V>>();
		// TODO: complete the rest of this method

		// Tip: you will need to iterate through each index in the table (and each index holds a list)
		//      you will THEN need to iterate through each element in the linked list chain at a 
		//      specific index and add each element to l
		for (int i=0;i<tableSize;i++) {
			Iterator<Entry<K,V>> indexList = table.get(i).iterator();

			while (indexList.hasNext()) {
				Entry<K,V> item = indexList.next();

				resultList.add(item);
			}
		}

		return resultList;
	}
	
	//----------------------------------------------------------
	public void put (K key, V value){
		// TODO: complete the rest of this method

		// if key is found, update value.  if key is not found add a new HashEntry with key,value
		// The tester expects that you will add the newest HashEntry to the END of the list
		try {
			Entry<K,V> indexListItem = find(key);
			indexListItem.setValue(value);
		} catch(KeyNotFoundException e) {
			// gets the index in the table this key should be in
			int index = Math.abs(key.hashCode())%tableSize;

			List<Entry<K,V>> indexList = table.get(index);
			indexList.add(new Entry<K,V>(key, value));

			count++;
		}
	}

	public int size() {
		return count;
	}

    public void clear() {
		for(int i = 0; i < tableSize; i++) {
			table.get(i).clear();
		}
        count = 0;
    }

}