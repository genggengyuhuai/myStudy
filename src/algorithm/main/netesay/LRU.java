package algorithm.main.netesay;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2019/9/11 20:55
 */
public class LRU<K,V> extends LinkedHashMap<K,V>{

    private Integer maxEntries;

    public LRU(int initialCapacity, float loadFactor, boolean accessOrder, Integer maxEntries) {
        super(initialCapacity, loadFactor, accessOrder);
        this.maxEntries = maxEntries;
    }

    @Override
     protected boolean removeEldestEntry(Map.Entry<K,V> eldest) {
        return size() > maxEntries;
    }

    public static void main(String[] args) {
        LRU<Integer,Integer> map = new LRU<>(128,0.75f,true,3);
        map.put(1,1);
        map.put(2,2);
        map.put(3,3);
        Integer integer = map.get(1);
        map.put(4,4);
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            System.out.println(entry.getValue());
        }
    }


}
