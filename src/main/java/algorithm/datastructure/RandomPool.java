package algorithm.datastructure;

import java.util.HashMap;

/**
 * 需求，写一个数据结构
 * 1. 可以增删查
 * 2. 可以等概率获取其中一个元素
 * 3. 以上操作时间复杂度都是 O(1)
 *
 * 思想是两个 hashmap，存储元素的定位。   保持元素的定位是 1-n 才可以等概率取
 * @author lihaoyu
 * @date 3/18/2020 3:53 PM
 */

public class RandomPool {
    public int size;
    private HashMap<Object, Integer> keySignMap;
    private HashMap<Integer, Object> signKeyMap;

    public RandomPool() {
        this.size = 0;
        this.keySignMap = new HashMap<>();
        this.signKeyMap = new HashMap<>();
    }

    public void insert(Object key) {
        //不重复添加
        if (keySignMap.containsKey(key)) {
            return;
        }
        keySignMap.put(key, size);
        signKeyMap.put(size, key);
        size++;
    }

    public void delete(Object key) {
        // 删除元素的时候把最后一个元素的定位补充到删除元素的定位上
        if (keySignMap.containsKey(key)) {
            Object lastKey = signKeyMap.get(--size);
            int deleteSign = keySignMap.get(key);
            keySignMap.put(lastKey, deleteSign);
            signKeyMap.put(deleteSign, lastKey);
            keySignMap.remove(key);
            signKeyMap.remove(lastKey);
        }
    }

    public Object getRandom() {
        if (size > 0) {
            return signKeyMap.get((int) (Math.random() * size));
        }
        return null;
    }

}