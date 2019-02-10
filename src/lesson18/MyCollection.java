package lesson18;

import java.util.Collection;
import java.util.Iterator;

public class MyCollection implements Collection {

    private Object[] objects;

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
        int counter = 0;
        for(Object obj: objects) {
            if (obj == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator iterator() {
        return null;
    }

    @Override
    public Object[] toArray() {
        int size = this.size();
        Object[] result = new Object[size];
        for (int i = 0; i < size; i++) {
            result[i] = objects[i];
        }
        return result;
    }

    @Override
    public boolean add(Object o) {
        int size = this.size();
        Object[] result = new Object[this.size() + 1];
        for (int i = 0; i < size; i++) {
            result[i] = objects[i];
            if (i == size - 1) {
                result[i] = o;
            }
        }
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
        return false;
    }

    @Override
    public void clear() {

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
