package algorithm.leetcode;

/**
 * @author lihaoyu
 * @date 2020/5/14 5:29 下午
 */
public class Main136 {

    // 数组中只有一个数字出现了奇数次，其他都出现了偶数次
    public static int singleNumber(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        int res = nums[0];
        for (int i = 1; i < nums.length; i++) {
            res ^= nums[i];
        }
        return res;
    }



    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 3, 4, 5, 2, 3, 4}));
    }
}
