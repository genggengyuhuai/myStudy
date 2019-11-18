package algorithm.temp;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */



public class Solution {

    public static void main(String[] args) {
        int N = 100;
        int[] dp = new int[N+1];
        int[] weight = new int[]{6,8,10};
        for(int i = 0; i < weight.length; i++){
            for(int j = weight[i]; j < dp.length; j++){
                dp[i] = Math.max(dp[j], dp[j-weight[i]]+weight[i]);
            }
        }

    }

}