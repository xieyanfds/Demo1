package test.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;
import test.domain.User;

import java.util.List;

/**
 * Created by Administrator on 2017/12/4.
 */
public class TestMultimap {
    public static void main(String[] args) {
        Multimap<String, Object> myMultiMap = ArrayListMultimap.create();
        myMultiMap.put("Fruits", new User("1","2"));
        myMultiMap.put("Fruits", "Pear");
        myMultiMap.put("Fruits", "Banana");
        myMultiMap.put("Vegetables", "eggplant");

        System.out.println("myMultiMap size:" + myMultiMap.size());

        List<?> fruits = (List<? extends Object>) myMultiMap.get("Fruits");

        fruits.forEach(o->{
            System.out.println(o);
        });
        System.out.println("myMultiMap.get(fruits): " + fruits);
        System.out.println("myMultiMap.get(Vegetables): " + myMultiMap.get("Vegetables"));

        System.out.println("keys:");
        for (String key : myMultiMap.keys()) {
            System.out.println(key);
        }

        System.out.println("values:");
        for (Object value : myMultiMap.values()) {
            System.out.println(value);
        }

        myMultiMap.remove("Fruits", "Apple");
        System.out.println("myMultiMap size:" + myMultiMap.size());

        myMultiMap.removeAll("Fruits");
        System.out.println("myMultiMap size:" + myMultiMap.size());
    }
}
