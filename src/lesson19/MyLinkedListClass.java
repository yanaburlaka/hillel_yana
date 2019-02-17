package lesson19;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyLinkedListClass<T> implements List<T> {

    private Node head;
    private Node tail;
    private int length;

    public MyLinkedListClass() {
        head = new Node();
        tail = new Node();
        head.nextElement = tail;
        tail.previousElement = head;
    }

    private class Node {

        private T currentElement;
        private Node previousElement;
        private Node nextElement;

        public Node(T currentElement) {
            this.currentElement = currentElement;
            this.nextElement = null;
            this.previousElement = null;
        }

        public Node() {
            this.currentElement = null;
            this.nextElement = null;
            this.previousElement = null;
        }
    }

    @Override
    public int size() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public boolean contains(Object o) {
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }

    @Override
    public boolean add(T t) {
        Node last = tail.previousElement;
        Node node = new Node(t);
        node.nextElement = tail;
        node.previousElement = last;
        tail.previousElement = node;
        last.nextElement = node;
        length++;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public boolean addAll(int index, Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public Object set(int index, Object element) {
        return null;
    }

    @Override
    public void add(int index, Object element) {

    }

    @Override
    public T remove(int index) {
        return null;
    }

    @Override
    public int indexOf(Object o) {
        return 0;
    }

    @Override
    public int lastIndexOf(Object o) {
        return 0;
    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        return false;
    }

    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }

    @Override
    public ListIterator listIterator() {
        return new ListIterator() {

            private int index = 0;
            private Node current = head.nextElement;
            private Node lastNode = null;
            @Override
            public boolean hasNext() {
                return index < length;
            }

            @Override
            public Object next() {
                if (!hasNext()) {
                    throw new IndexOutOfBoundsException("huh, oh no");
                }
                lastNode = current;
                T data = current.currentElement;
                current = current.nextElement;
                index++;
                return data;
            }

            @Override
            public boolean hasPrevious() {
                return index > 0;
            }

            @Override
            public Object previous() {
                if (!hasPrevious()) {
                    throw new IndexOutOfBoundsException("huh, oh no");
                }
                current = current.previousElement;
                lastNode = current;
                index--;
                return current.currentElement;
            }

            @Override
            public int nextIndex() {
                return index;
            }

            @Override
            public int previousIndex() {
                return index - 1;
            }

            @Override
            public void remove() {

            }

            @Override
            public void set(Object o) {

            }

            @Override
            public void add(Object o) {

            }
        };
    }

    @Override
    public ListIterator listIterator(int index) {
        return null;
    }

    @Override
    public List subList(int fromIndex, int toIndex) {
        return null;
    }


}

