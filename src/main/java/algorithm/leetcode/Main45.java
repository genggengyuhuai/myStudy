package algorithm.leetcode;

/**
 *    困难贪心
 * 给定一个非负整数数组，你最初位于数组的第一个位置。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @author lihaoyu
 * @date 2/7/2020 4:28 PM
 */
public class Main45 {

    public static int jump(int[] nums) {
        if(nums.length == 1) return 0;
        int count = 0;
        for(int i = 0; i < nums.length; i++){
            if(i + nums[i] >= nums.length - 1) return count+1;
            int next = i+1, max = i+1+nums[i+1];
            for(int j = i+1; j <= i+nums[i]; j++){
                if(j + nums[j] >= max){
                    next = j;
                    max = j + nums[j];
                }
            }
            count++;
            i = next - 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(jump(new int[]{2,3,1,1,4}));
    }
}
