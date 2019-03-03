package lesson21;

import java.util.HashMap;

public class Main {

    public static void main(String[] args) {

        MyMap<String, Integer> countriesAndArea = new MyMap<String, Integer>();
        countriesAndArea.put("Canada", 9_984_670);
        countriesAndArea.put("United States of America", 9_826_675);
        countriesAndArea.put("China", 9_598_094);
        countriesAndArea.put("Argentina", 2_766_890);
        countriesAndArea.put("Bahamas", 13_878);
        System.out.println("Sdf");
        Integer size = countriesAndArea.get("China");
        System.out.println(size);
        System.out.println(countriesAndArea.toString());
    }
}
