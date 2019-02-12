package lesson18;


import java.util.Arrays;
import java.util.Iterator;

public class Main {

    public static void main(String[] args) {

        Student stud = new Student("Ivan", "Ivanov");
        Student stud2 = new Student("Roman", "Ivanov");
        Student stud3 = new Student("Ivan", "Romanov");
        MyCollection myCollection = new MyCollection();
        myCollection.add(stud);
        myCollection.add(stud2);
        System.out.println("Size is " + myCollection.size());

        if (myCollection.isEmpty()){
            System.out.println("Wow, it's empty!");
        }
        else {
            System.out.println("It's not empty");
        }

        if (myCollection.contains(stud3)) {
            System.out.println("We already have this object");
        }
        else {
            System.out.println("We don't have " + stud3.toString() + " in our collection yet");
            myCollection.add(stud3);
            System.out.println("Size is " + myCollection.size());
        }

        System.out.println();
        System.out.println("Let's take a look what we have in collection:");
        Iterator iterator = myCollection.iterator();
        while (iterator.hasNext()){
            Object o = iterator.next();
            System.out.println(o);
        }
        System.out.println();

        System.out.println("Let's create an array from objects in collection and see the result:");
        Object[] objects = myCollection.toArray();
        System.out.println(Arrays.toString(objects));

        System.out.println();
        System.out.println("Delete " + stud3.toString());
        myCollection.remove(stud3);
        System.out.println("Size is " + myCollection.size());

        Student stud4 = new Student("Oleg", "Vasiliev");
        Student stud5 = new Student("Vasilii", "Olegov");
        Student stud6 = new Student("Vasiliy", "Romanov");
        MyCollection myNewCollection = new MyCollection();
        myNewCollection.add(stud4);
        myNewCollection.add(stud5);
        myNewCollection.add(stud6);

        myCollection.addAll(myNewCollection);
        System.out.println(myCollection.size());

        System.out.println("Clear collection");
        myCollection.clear();
        System.out.println(myCollection.size());

    }
}
