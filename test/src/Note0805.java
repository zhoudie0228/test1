import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArraySet;

public class Note0805 {

    public static void main(String[] args) {
        Map<String,String> map=new ConcurrentHashMap<>();//new HashMap<>();
        for (int i = 1; i <=30; i++) {
                    new Thread(() -> {
                        map.put(Thread.currentThread().getName(),UUID.randomUUID().toString().substring(0,6));
                        System.out.println(map);
                    },String.valueOf(i)).start();
                }











        /*Set<String> set= new CopyOnWriteArraySet<>();//Collections.synchronizedSet(new HashSet<>());//new HashSet<>();
        for (int i = 1; i <=30; i++) {
                    new Thread(() -> {
                        set.add(UUID.randomUUID().toString().substring(0,6));
                        System.out.println(set);
                    },String.valueOf(i)).start();
                }*/
    }



}
