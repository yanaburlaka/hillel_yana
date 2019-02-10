package lesson18;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Object[] arr = {1, 3, 4};
        MyCollection myCollection = new MyCollection(arr);
        Object[] my = myCollection.toArray();
        for (int i = 0; i < my.length; i++) {
            System.out.println(my[i]);
        }
        System.out.println(myCollection.contains(2));
        myCollection.add(2);
        for (int i = 0; i < myCollection.size(); i++) {
            System.out.println(Array.get(myCollection.toArray(), i));
        }
        System.out.println();
        myCollection.remove(3);
        for (int i = 0; i < myCollection.size(); i++) {
            System.out.println(Array.get(myCollection.toArray(), i));
        }

    }
}
