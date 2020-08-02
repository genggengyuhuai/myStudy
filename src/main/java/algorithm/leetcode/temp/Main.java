package algorithm.leetcode.temp;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/12/25 12:16
 */
public class Main {

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
        Scanner scanner = new Scanner(System.in);
        String nextLine = scanner.nextLine();
        String[] s = nextLine.split(",");
        int[] nums = new int[s.length];
        for(int i = 0; i < nums.length; i++){
            nums[i] = Integer.parseInt(s[i]);
        }
        System.out.println(maxArea(nums));
    }
}
