package algorithm.temp;


/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */



public class Solution {

    public static void main(String[] args) {
         int[] nums = new int[10];
         int[] dp = new int[10];
         int  len = dp.length;
         // dp[] 表示以此位置为结尾的数  对应的 最长递增子序列的长度
         for(int i = 1; i < len; i++){
             for(int j = 0; j < i; j++){
                 if(nums[i] > nums[j] && dp[j] + 1 > dp[i]){
                     dp[i] = dp[j] + 1;
                 }
             }
         }
    }

}