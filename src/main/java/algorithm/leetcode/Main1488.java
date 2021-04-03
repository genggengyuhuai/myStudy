package algorithm.leetcode;

import javax.mail.search.SearchTerm;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2021/3/23 23:52
 */
public class Main1488 {

    public int[] avoidFlood(int[] rains) {
        if (rains == null || rains.length == 0) return null;
        int[] res = new int[rains.length];
        LinkedList<Integer> queue = new LinkedList<>();
        Set<Integer>  set = new HashSet<>();
        // 先初始化 queue 和 set
        for (int i = 0; i < rains.length; i++) {
            // 下雨
            if(rains[i] != 0){
                if(!set.contains(rains[i])){
                    set.add(rains[i]);
                }else{
                    queue.addLast(rains[i]);
                }
            }
        }
        for (int i = 0; i < rains.length; i++) {
            // 下雨
            if(rains[i] != 0){
                res[i] = 1;
            }else{
                // 不下雨, 尝试移除
                if(queue.isEmpty()){
                    // 已经空了
                    res[i] = -1;
                    continue;
                }
                res[i] = queue.pollFirst();
            }
        }
        if (!queue.isEmpty()){
            return new int[0];
        }
        return res;
    }

    public static void main(String[] args) {

    }
}
