package algorithm.leetcode.tencent;

import java.util.Arrays;

/**
 * 34. 在排序数组中查找元素的第一个和最后一个位置
 * @author lihaoyu
 * @date 2019/12/20 20:44
 */
public class Main34 {


    public static int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1,-1};
        int index = Arrays.binarySearch(nums, target);
        if(index < 0) return res;
        int left = index, right = index;
        while(left > 0 && nums[left] == nums[left - 1])  left--;
        while(right < nums.length - 1 && nums[right] == nums[right + 1])  right++;
        res[0] = left;
        res[1] = right;
        return res;
    }

    public static void main(String[] args) {
        int[] ints = searchRange(new int[]{7, 7, 7, 8, 8, 10}, 7);
        for (int anInt : ints) {
            System.out.print(" "+anInt);
        }
    }
}
