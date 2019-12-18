package algorithm.leetcode.tencent;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 146. LRU缓存机制
 * @author lihaoyu
 * @date 2019/12/18 15:44
 */
public class Main146 {

    private static class LRUCache extends LinkedHashMap {
        int capacity;

        public LRUCache(int capacity) {
            super(2 * capacity, 0.75f, true);
            this.capacity = capacity;
        }

        public int get(int key) {
            if(super.get(key) != null)
            return (Integer)super.get(key);
            return -1;
        }

        public void put(int key, int value) {
            super.put(key,value);
        }

        @Override
        protected boolean removeEldestEntry(Map.Entry eldest) {
            return size() > capacity;
        }

    }

    public static void main(String[] args) {
        LRUCache cache = new LRUCache(3);
        cache.put(1,1);
        cache.put(2,2);
        cache.put(3,3);
        cache.get(1);
        cache.put(4,4);
        System.out.println(cache.get(2));


    }

}
