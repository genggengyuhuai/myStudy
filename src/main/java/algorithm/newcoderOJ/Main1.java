package algorithm.newcoderOJ;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * 众所周知，牛能和牛可乐经常收到小粉丝们送来的礼物，每个礼物有特定的价值，
 * 他俩想要尽可能按照自己所得价值来平均分配所有礼物。
 * 那么问题来了，在最优的情况下，他俩手中得到的礼物价值和的最小差值是多少呢？
 * 输入
 * [1,2,3,4]
 * 输出
 * 0
 * 说明
 * 他俩一个人拿1,4 。另一个人拿2,3
 * @author lihaoyu
 * @date 3/6/2020 8:32 AM
 */
public class Main1 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inputStr = br.readLine();
        int input[] = parseInts(inputStr.split("."));
        int output = solution(input);
        System.out.println(output);
    }

    private static int[] parseInts(String[] strArr) {
        if (strArr == null || strArr.length == 0) {
            return new int[0];
        }
        int[] intArr = new int[strArr.length];
        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(strArr[i]);
        }
        return intArr;
    }

    private static int solution(int[] presentVec) {
        int sum = 0;
        for (int i : presentVec) {
            sum += i;
        }
        int[] dp = new int[sum/2+1];
        for (int i = 0; i < presentVec.length; i++) {
            for(int j = sum/2; j >= presentVec[i]; j--){
                dp[j] = Math.max(dp[j],dp[j-presentVec[i]]+presentVec[i]);
            }
        }
        return Math.abs(sum - 2 * dp[sum/2]);
    }

}
