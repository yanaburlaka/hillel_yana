package lesson21;

public class MyMap<K, V> {

    private Entry<K, V>[] entries;

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
        int index = getHash(key);
        storeEntry(key, value, index);
    }

    private void storeEntry(K key, V value, int index) {
    }

    private int getHash(K key) {
        int hashCode = key.hashCode();
        return hashCode % 100;
    }
}
