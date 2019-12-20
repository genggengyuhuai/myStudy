package algorithm.leetcode.tencent;

/**
 * 55. 跳跃游戏
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个位置。
 * @author lihaoyu
 * @date 2019/12/20 16:53
 */
public class Main55 {

    public static boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        int init = nums[0]; // 可以到达的最大高度
        int i;
        for(i = 1; i < nums.length && init > 0; i++){
            if(init >= nums.length - i) return true;
            init = Math.max(init - 1, nums[i]);
        }
        return i == nums.length;
    }


    public static void main(String[] args) {
        System.out.println(canJump(new int[]{2, 2, 1, 0, 4}));
    }
}
