package algorithm.leetcode;

import java.util.ArrayList;

/**
 * 贪心，单调栈
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为摆动序列。第一个差（如果存在的话）可能是正数或负数。少于两个元素的序列也是摆动序列。
 * 例如，[1,7,4,9,2,5] 是一个摆动序列，因为差值 (6,-3,5,-7,3) 是正负交替出现的。相反, [1,4,7,2,5] 和 [1,7,4,5,5] 不是摆动序列，第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 * 给定一个整数序列，返回作为摆动序列的最长子序列的长度。 通过从原始序列中删除一些（也可以不删除）元素来获得子序列，剩下的元素保持其原始顺序。
 * @author lihaoyu
 * @date 2/7/2020 10:08 PM
 */
public class Main376 {

    public static int wiggleMaxLength(int[] nums) {
        if(nums.length == 0) return 0;
        // 以当前位置为增长/减少的最长长度
       int[] up = new int[nums.length], down = new int[nums.length];
       up[0] = 1;
       down[0] = 1;
       int  res = 1;
        for (int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]){
                up[i] = Math.max(down[i-1]+1,up[i-1]);
                down[i] = down[i-1];
            }else if(nums[i] < nums[i-1]){
                down[i] = Math.max(up[i-1]+1, down[i-1]);
                up[i] = up[i-1];
            }else{
                down[i] = down[i-1];
                up[i] = up[i-1];
            }
            res = Math.max(res,Math.max(down[i],up[i]));
        }

        return res;
    }


    public static void main(String[] args) {
        System.out.println(wiggleMaxLength(new int[]{1,2,1,2,1}));
    }
}
