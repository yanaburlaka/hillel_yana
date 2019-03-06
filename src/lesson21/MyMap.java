package lesson21;

import java.util.Arrays;
import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class MyMap<K, V> implements Map{

    private Entry<K, V>[] entries;
    private static final int SIZE = 4;
    private int sizeOfBucket = 0;

    public MyMap() {
        this.entries = new Entry[SIZE];
    }

    private class Entry<K, V> {
        Object key;
        Object value;
        Entry<K, V> next;

        public Entry(K key, V value, Entry<K, V> next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }

        public String entryToString() {
            return "Entry{" +
                    key + " = " + value +
                    '}';
        }
    }
//
//    public void put(K key, V value) {
//
//        Entry<K, V> newEntry = new Entry(key, value, null);
//        int index = getHashCode(key);
//        Entry<K, V> existingEntry = entries[index];
//        if (existingEntry == null) {
//            entries[index] = newEntry;
//            sizeOfBucket++;
//        } else {
//            while (existingEntry.next != null) {
//                if (existingEntry.key.equals(key)) {
//                    existingEntry.value = value;
//                    return;
//                }
//                existingEntry = existingEntry.next;
//            }
//            if (existingEntry.key.equals(key)) {
//                existingEntry.value = value;
//            } else {
//                existingEntry.next = newEntry;
//                sizeOfBucket++;
//            }
//        }
//    }

//    public V get(K keyToGet) {
//        int index = getHashCode(keyToGet);
//        V valueToGet = null;
//        Entry<K, V> existingEntry = entries[index];
//        if (existingEntry == null) {
//            System.out.println("We don't have this country, sorry");
//        } else {
//            while (existingEntry.next != null) {
//                if (existingEntry.key.equals(keyToGet)) {
//                    valueToGet = existingEntry.value;
//                    return valueToGet;
//                }
//                existingEntry = existingEntry.next;
//            }
//        }
//        return valueToGet;
//    }

    @Override
    public int size() {
        return sizeOfBucket;
    }

    @Override
    public boolean isEmpty() {
        return (sizeOfBucket == 0);
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Object get(Object keyToGet) {
        int index = getHashCode(keyToGet);
        Object valueToGet = null;
        Entry<K, V> existingEntry = entries[index];
        if (existingEntry == null) {
            System.out.println("We don't have this country, sorry");
        } else {
            while (existingEntry.next != null) {
                if (existingEntry.key.equals(keyToGet)) {
                    valueToGet = existingEntry.value;
                    return valueToGet;
                }
                existingEntry = existingEntry.next;
            }
        }
        return valueToGet;
    }

    @Override
    public Object put(Object key, Object value) {
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
        return value;
    }

    @Override
    public Object remove(Object key) {
        return null;
    }

    @Override
    public void putAll(Map m) {

    }

    @Override
    public void clear() {

    }

    @Override
    public Set keySet() {
        return null;
    }

    @Override
    public Collection values() {
        return null;
    }

    @Override
    public Set<Map.Entry> entrySet() {
        return null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MyMap<?, ?> myMap = (MyMap<?, ?>) o;

        // Probably incorrect - comparing Object[] arrays with Arrays.equals
        return Arrays.equals(entries, myMap.entries);
    }


    public int getHashCode(Object key) {
        String s = key.toString();
        int i = s.length() % SIZE;
        return i;
    }

    @Override
    public String toString() {
        String result = "";
        for (Entry en : entries) {
            if (en != null) {
                result = result.concat(en.entryToString());
                while (en.next != null) {
                    en = en.next;
                    result = result.concat(en.entryToString());
                }
            }
        }
        return result;
    }
}
