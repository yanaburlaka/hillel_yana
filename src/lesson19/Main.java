package lesson19;

import lesson18.MyCollection;

import java.util.ListIterator;

public class Main {

    public static void main(String[] args) {

        MyLinkedListClass myLinkedList = new MyLinkedListClass();
        myLinkedList.add(2);
        myLinkedList.add(3);
        myLinkedList.add(4);
        myLinkedList.add(7);

        System.out.println(myLinkedList.size());

        ListIterator listIterator = myLinkedList.listIterator();
        System.out.println("Elements");
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        System.out.println("Elements backwards");
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }

    }
}
