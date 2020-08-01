package algorithm.leetcode.bytedance.datestructure;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2020/8/1 4:55 下午
 */
public class AllOne {
    Map<String, Integer> keyMap;
    Map<Integer, String> valueMap;

    /**
     * Initialize your data structure here.
     */
    public AllOne() {
        keyMap = new HashMap<>();
        valueMap = new HashMap<>();
    }

    /**
     * Inserts a new key <Key> with value 1. Or increments an existing key by 1.
     */
    public void inc(String key) {
        int value = keyMap.getOrDefault(key, 0) + 1;
        keyMap.put(key, value);
        valueMap.remove(value - 1);
        valueMap.put(value, key);
    }

    /**
     * Decrements an existing key by 1. If Key's value is 1, remove it from the data structure.
     */
    public void dec(String key) {
        // 已知一定存在
        int value = keyMap.get(key);
        if (value == 1) {

        }
    }

    /**
     * Returns one of the keys with maximal value.
     */
    public String getMaxKey() {
        return null;
    }

    /**
     * Returns one of the keys with Minimal value.
     */
    public String getMinKey() {
        return null;
    }
}

/**
 * Your AllOne object will be instantiated and called as such:
 * AllOne obj = new AllOne();
 * obj.inc(key);
 * obj.dec(key);
 * String param_3 = obj.getMaxKey();
 * String param_4 = obj.getMinKey();
 */