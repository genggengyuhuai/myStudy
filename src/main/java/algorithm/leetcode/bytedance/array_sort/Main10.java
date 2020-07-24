package algorithm.leetcode.bytedance.array_sort;

/**
 *
 * 给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水
 *输入: [0,1,0,2,1,0,1,3,2,1,2,1]
 * 输出: 6
 * @author lihaoyu
 * @date 2020/7/5 11:40 下午
 */
public class Main10 {
    
    // 计算每个柱子的左右最大高度，然后(如果大于当前柱子)取小的那个，就是当前柱子的蓄水量
    public int trap(int[] height) {
        if(height == null || height.length == 0) return 0;
        int res = 0;
        int[] left = new int[height.length];
        left[0] = Integer.MIN_VALUE;
        int[] right = new int[height.length];
        right[right.length-1] = Integer.MIN_VALUE;
        System.out.println();
        return 0;
    }

    public static void main(String[] args) {

    }
}
