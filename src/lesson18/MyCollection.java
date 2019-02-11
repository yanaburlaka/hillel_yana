package lesson18;

import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection {

    private Object[] objects = new Object[0];

    public Object[] getObjects() {
        return objects;
    }

    public void setObjects(Object[] objects) {
        this.objects = objects;
    }

    public MyCollection() {
    }

    public MyCollection(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public int size() {
        return objects.length;
    }

    @Override
    public boolean isEmpty() {
        if (this.size() == 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public boolean contains(Object o) {
        for(Object obj: objects) {
            if (obj.equals(o)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() { //anonym

            private int index = 0;

            @Override
            public boolean hasNext() {
                return index < objects.length;
            }

            @Override
            public Object next() {
                if (index == objects.length) {
                    throw new IndexOutOfBoundsException("oh");
                }
                Object result = objects[index];
                index++;
                return result;
            }


        };
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = objects[i];
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        int size = size();
        Object[] result = new Object[size + 1];
        for (int i = 0; i < size; i++) {
            result[i] = objects[i];
        }
        result[size] = o;
        objects = result;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        if (this.contains(o) == false) {
            return false;
        }
        else {
            int size = this.size();
            int index = 0;
            Object[] result = new Object[this.size() - 1];
            for (int i = 0; i < result.length; i++) {
                if (objects[i] == o){
                    continue;
                }
                else {
                    result[index] = objects[i];
                    index++;
                }
            }
            objects = result;
            return true;
        }
    }

    @Override
    public boolean addAll(Collection c) {
        for (Object o : c){
            add(o);
        }
        return true;
    }

    @Override
    public void clear() {
        objects = new Object[0];
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


}
