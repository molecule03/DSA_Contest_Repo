package DSA.DataStructures.Linear.HashTable;
import java.util.LinkedList;
import java.util.Map;

public class HashTable {
    private class Entry {
        private int key;
        private String value;

        public Entry(int key, String value) {
            this.key = key;
            this.value = value;
        }

    }

    private LinkedList<Entry>[] entries = new LinkedList[5];

    public void put(int key, String value) {
        Entry entry = getEntry(key);
        if (entry != null) {
            entry.value = value;
            return;
        }
        getOrCreateBucket(key).add(new Entry(key, value));
    }

    private Entry getEntry(int key) {
        LinkedList<Entry> bucket = getBucket(key);
        if (bucket != null) {
            for (Entry entry : bucket)
                if (entry.key == key)
                    return entry;
        }

        return null;
    }
    private LinkedList<Entry> getOrCreateBucket(int key){

        LinkedList<Entry> bucket = getBucket(key);
        if (bucket == null) {
            bucket = new LinkedList<>();
            entries[hash(key)] = bucket;
        }

        return bucket;
    }

    public void remove(int key) {
        Entry entry = getEntry(key);
        if (entry == null)
            throw new IllegalStateException();
        getBucket(key).remove(entry);
    }

    public String get(int key) {
        Entry entry = getEntry(key);
        return (entry == null) ? null : entry.value;
    }

    private LinkedList<Entry> getBucket(int key){
        return entries[hash(key)];
    }

    private int hash (int key) {
        return key % entries.length;
    }

}


