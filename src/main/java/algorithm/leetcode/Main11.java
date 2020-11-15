package algorithm.leetcode;

/**
 * 11. 盛最多水的容器
 * 双指针法
 * 和 蓄水池不一样
 * author lihaoyu
 * @date 2019/12/25 12:20
 */
public class Main11 {

    public static int maxArea(int[] height) {
        int res = 0, temp = 0;
        int start = 0, end = height.length - 1;
        while(start < end) {
            temp = Math.min(height[start], height[end]);
            if(temp * (end - start) > res) res = temp * (end - start);
            if(temp == height[start]) start++;
            else end--;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1,8,6,2,5,4,8,3,7}));
    }
}
