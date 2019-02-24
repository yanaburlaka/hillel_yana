package lesson20;

import java.util.Iterator;

public class Main {

    public static void main(String[] args) {
        MyTreeSet myTreeSet = new MyTreeSet();
        myTreeSet.add(3);
        myTreeSet.add(5);
        myTreeSet.add(1);
        myTreeSet.add(10);
        myTreeSet.add(30);
        myTreeSet.add(4);
        myTreeSet.add(50);
        myTreeSet.add(7);

        Iterator iterator = myTreeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}
