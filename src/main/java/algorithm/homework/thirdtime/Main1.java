package algorithm.homework.thirdtime;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 给定两个字符串，返回两个字符串的最长公共子序列（不是最长公共子字符串），可能是多个。
 *
 * @author lihaoyu
 * @date 2019/10/26 18:02
 */
public class Main1 {

    public static void fun(String s1, String s2){
        int len1 = s1.length();
        int len2 = s2.length();
        int[][] dp = new int[len1+1][len2+1];
        for(int i = 1; i <= len1; i++){
            for(int j = 1; j <= len2; j++){
                if(s1.charAt(i-1) == s2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        ArrayList<String> list = new ArrayList<>();
        backTrack(s1,list,sb,dp,len1,len2);
        if(!list.isEmpty()){
        Collections.sort(list);
        list.forEach(System.out::println);
        }
    }

public static void backTrack(String str,ArrayList<String> list, StringBuilder sb, int[][] dp,int i, int j){
        if(i == 0 || j == 0){
            StringBuilder reverse = sb.reverse();
            if(!list.contains(reverse.toString())){
            list.add(reverse.toString());
            }
            sb.reverse();
            return;
        }
        if(dp[i][j] == dp[i-1][j]){
            backTrack(str,list,sb,dp,i-1,j);
        }
        if(dp[i][j] == dp[i][j-1]){
            backTrack(str,list,sb,dp,i,j-1);
        }
        if(dp[i][j] != dp[i-1][j] && dp[i][j] != dp[i][j-1]){
            sb.append(str.charAt(i-1));
            backTrack(str,list,sb,dp,i-1,j-1);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for(int t = 0; t < T; t++){
            String s1 = scanner.next();
            String s2 = scanner.next();
            fun(s1,s2);
        }

    }

}
