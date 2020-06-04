package algorithm.leetcode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 每个元音包含偶数次的最长子字符串
 * @author lihaoyu
 * @date 2020/5/30 4:14 下午
 */
public class Main1371 {

    private static final Map<Character, Integer> map = new HashMap<>();

    public int findTheLongestSubstring(String s) {
        map.put('a',1);
        map.put('e',2);
        map.put('i',3);
        map.put('o',4);
        map.put('u',5);
        if(s == null || s.length() == 0) return 0;
        // 以当前位置为结尾的最长字符串长度，以及5个元音的上一次出现的下标  没有则为 -1
        int[][] dp = new int[s.length()+1][6];
        int res = 0;
        Arrays.fill(dp[0],-1); dp[0][0] = 0;
        for (int index = 0; index < s.length(); index++) {
            if(!map.containsKey(s.charAt(index))) {
                System.arraycopy(dp[index],0,dp[index+1],0,6);
                res = Math.max(dp[index+1][0], res);
                continue;
            }
            // 是 a,e,i,o,u

            
            
        }

        return 0;
    }

    public static void main(String[] args) {

    }
}
