package algorithm.leetcode.bytedance.array_sort;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 *   最长连续序列
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
    public int longestConsecutive(int[] nums) {
        // key 存的是当前数字， value 存在的
        Map<Integer,Integer> map = new HashMap<>(nums.length);
        int res = 1;
        for (int i = 0; i < nums.length; i++) {

        }

        return 0;
    }


    public static void main(String[] args) {

    }
}
