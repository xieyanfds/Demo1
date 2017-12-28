package test.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * Created by Administrator on 2017/12/4.
 */
public class TestMultimap {
    public static void main(String[] args) {
        Multimap<String, String> myMultiMap = ArrayListMultimap.create();
        myMultiMap.put("Fruits", "Apple");
        myMultiMap.put("Fruits", "Pear");
        myMultiMap.put("Fruits", "Banana");
        myMultiMap.put("Vegetables", "eggplant");

        System.out.println("myMultiMap size:" + myMultiMap.size());

        System.out.println("myMultiMap.get(Fruits): " + myMultiMap.get("Fruits"));
        System.out.println("myMultiMap.get(Vegetables): " + myMultiMap.get("Vegetables"));

        System.out.println("keys:");
        for (String key : myMultiMap.keys()) {
            System.out.println(key);
        }

        System.out.println("values:");
        for (String value : myMultiMap.values()) {
            System.out.println(value);
        }

        myMultiMap.remove("Fruits", "Apple");
        System.out.println("myMultiMap size:" + myMultiMap.size());

        myMultiMap.removeAll("Fruits");
        System.out.println("myMultiMap size:" + myMultiMap.size());
    }
}
