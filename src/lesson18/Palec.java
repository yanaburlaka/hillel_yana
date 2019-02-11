package lesson18;

import java.util.Iterator;

public class Palec implements Iterator {

    private final Object[] objects;

    private int index = 0;

    public Palec(Object[] objects) {
        this.objects = objects;
    }

    @Override
    public boolean hasNext() {
        return index < objects.length;
    }

    @Override
    public Object next() {
        if(index == objects.length){
            throw new IndexOutOfBoundsException("oh");
        }
        Object result = objects[index];
        index++;
        return result;
    }
}
