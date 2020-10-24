package algorithm.leetcode.bytedance.array_sort;

import java.util.HashMap;
import java.util.Map;

/**
 *   最长连续序列  手动收藏
 * 给定一个未排序的整数数组，找出最长连续序列的长度。
 * 要求算法的时间复杂度为 O(n)。
 * 示例:
 * 输入: [100, 4, 200, 1, 3, 2]
 * 输出: 4
 * 解释: 最长连续序列是 [1, 2, 3, 4]。它的长度为 4。
 * @author lihaoyu
 * @date 2020/7/4 7:57 下午
 */
public class Main6 {

    // 目测用 hash
    public static int longestConsecutive(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        // key 存的是当前数字， value 到当前数的连续次数，用于优化
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int res = 1;
        // 先都装进去
        for (int num : nums) {
            map.put(num,0);
        }
        for (int i = 0; i < nums.length; i++) {
            int cur = nums[i] - 1, tempRes = 1;
            // 去找比他小的
            while(true){
                // 优化的一个点， value = -1 说明已经被遍历过，要停止
                if(!map.containsKey(cur) || map.get(cur) == -1) {
                    break;
                }
                int temp = map.get(cur);
                // 说明有过累计，不用再走了
                if(temp > 0){
                    // 直接塞回去
                    map.put(nums[i], temp+tempRes);
                    tempRes += temp;
                    map.put(cur,-1);
                    res = Math.max(res, tempRes);
                    break;
                }
                // 没有累计，往回找
                tempRes++;
                res = Math.max(res,tempRes);
                map.put(cur, -1);
                cur--;
            }
            if(tempRes != 1)
            map.put(nums[i],tempRes);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{23, 1, 2, 0, 2, 4, 3, 65, 12, 65, 5, -12}));
    }
}
