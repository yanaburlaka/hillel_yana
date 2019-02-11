package lesson18;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Student stud = new Student("Ivan", "Ivanov");
        Student stud2 = new Student("Roman", "Ivanov");
        MyCollection myCollection = new MyCollection();
        myCollection.add(stud);
        myCollection.add(stud2);
        Object[] objects = myCollection.toArray();
        objects[0] = null;
        objects[1] = null;
        System.out.println(myCollection.size());

        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }

    }
}
