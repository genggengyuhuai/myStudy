package algorithm.school_hire_2019.vivo;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author lihaoyu
 * @date 3/6/2020 8:32 AM
 */
public class Main5 {

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
