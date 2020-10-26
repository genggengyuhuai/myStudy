package algorithm.leetcode;

import java.util.ArrayList;

/**
 *
 * 我们把数组 A 中符合下列属性的任意连续子数组 B 称为 “山脉”：
 * B.length >= 3
 * 存在 0 < i < B.length - 1 使得 B[0] < B[1] < ... B[i-1] < B[i] > B[i+1] > ... > B[B.length - 1]
 * （注意：B 可以是 A 的任意子数组，包括整个数组 A。）
 * 给出一个整数数组 A，返回最长 “山脉” 的长度。
 * 如果不含有 “山脉” 则返回 0。
 * 示例 1：
 * 输入：[2,1,4,7,3,2,5]
 * 输出：5
 * 解释：最长的 “山脉” 是 [1,4,7,3,2]，长度为 5。
 * @date 2020/10/25 11:04 下午
 */
public class Main845 {

    public static int longestMountain(int[] A) {
        // 求当前位置的最长递增子序列   正和反
        if(A == null ||  A.length <= 2) return 0;
        int[] incr = new int[A.length], desc = new int[A.length];
        for (int i = 1; i < incr.length; i++) {
            if(A[i] > A[i-1]) incr[i] = incr[i-1] + 1;
        }
        for (int i = desc.length - 2; i >= 0; i--) {
            if (A[i] > A[i+1]) desc[i] = desc[i+1] + 1;
        }
        int res = 0;
        for (int i = 0; i < incr.length; i++) {
            if(incr[i] != 0 && desc[i] != 0)
            res = Math.max(res,incr[i] + desc[i] + 1);

        }
        return res >= 3 ? res : 0;
    }

    public static void main(String[] args) {
        int[] temp = new int[]{2,1,4,7,3,2,5};
        longestMountain(temp);
    }
}
