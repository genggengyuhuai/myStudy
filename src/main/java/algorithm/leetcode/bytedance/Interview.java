package algorithm.leetcode.bytedance;

/**
 * 字节跳动后端实习生 2020.3.2 三面 匡振国
 * 排序数组  -5,-3, -2,-2,1,1,2,2,3,4 输出每个
 * 元素平方后有多少个不同的元素  空间O(1)
 *
 * @author lihaoyu
 * @date 2020/8/3 9:55 下午
 */
public class Interview {

    // 双指针
    private static int fun(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        int left = 1, right = nums.length - 1, res = 1, temp = Math.abs(nums[0]);
        while (left < right) {
            int absLeft = Math.abs(nums[left]), absRight = Math.abs(nums[right]);
            if (absLeft == absRight) {
                if (absLeft == temp) continue;
                left++;
                right--;
            } else if (absLeft < absRight) {
                right--;
                temp = absRight;
            } else {
            }
        }


        return res;
    }

    public static void main(String[] args) {

    }
}
