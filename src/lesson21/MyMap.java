package lesson21;

import java.util.Arrays;

public class MyMap<K, V> {

    private Entry<K, V>[] entries;
    private static final int SIZE = 4;
    private int sizeOfBucket = 0;

    public MyMap() {
        this.entries = new Entry[SIZE];
    }

    private class Entry<K, V> {
        K key;
        V value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public void put(K key, V value) {

        Entry<K, V> newEntry = new Entry(key, value, null);
        int index = getHashCode(key);
        Entry<K, V> existingEntry = entries[index];
        if (existingEntry == null) {
            entries[index] = newEntry;
            sizeOfBucket++;
        } else {
            while (existingEntry.next != null) {
                if (existingEntry.key.equals(key)) {
                    existingEntry.value = value;
                    return;
                }
                existingEntry = existingEntry.next;
            }
            if (existingEntry.key.equals(key)) {
                existingEntry.value = value;
            } else {
                existingEntry.next = newEntry;
                sizeOfBucket++;
            }
        }
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMap<?, ?> myMap = (MyMap<?, ?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(entries, myMap.entries);
    }


    public int getHashCode(K key) {
        String s = key.toString();
        int i = s.length() % SIZE;
        return i;
    }

}
