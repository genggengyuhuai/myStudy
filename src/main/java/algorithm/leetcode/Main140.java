package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 动归加回溯，但是  aaaaaaaaaaaaa 的情况会超时
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，在字符串中增加空格来构建一个句子，使得句子中所有的单词都在词典中。返回所有这些可能的句子。
 * 说明：
 * 分隔时可以重复使用字典中的单词。
 * 你可以假设字典中没有重复的单词。
 * 示例 1：
 * 输入:
 * s = "catsanddog"
 * wordDict = ["cat", "cats", "and", "sand", "dog"]
 * 输出:
 * [
 *   "cats and dog",
 *   "cat sand dog"
 * ]
 * @author lihaoyu
 * @date 2/7/2020 9:39 AM
 */
public class Main140 {

    public static List<String> wordBreak(String s, List<String> wordDict) {
        List<String> tempRes = new ArrayList<>();
        if(s.length() == 0) return tempRes;
        boolean[][] dp = new boolean[s.length()][s.length()];
        for (String word : wordDict) {
            int start = 0, index;
            while((index = s.indexOf(word,start)) != -1){
                dp[index][index+word.length()-1] = true;
                start = index+1;
            }
        }
       // fun(s,dp,s.length()-1,"",tempRes);
        fun2(s,dp,0,"",tempRes);
        List<String> res = new ArrayList<>();
        for (String tempRe : tempRes) {
            StringBuilder sb = new StringBuilder();
            String[] split = tempRe.split(",");
            for (int i = 0; i < split.length; i++) {
                if(i != 0)
                sb.append(" ").append(split[i]);
                else sb.append(split[i]);
            }
            res.add(sb.toString());
        }
        return res;
    }

    // 回溯
    private static void fun(String src, boolean[][] dp, int j, String tempStr, List<String> res){
        if(j == -1){
            res.add(tempStr);
            return;
        }
        if(j < -1){
            return;
        }
        for(int i = 0; i <= j; i++){
            if(dp[i][j])
            fun(src,dp,i-1,tempStr+src.substring(i,j+1)+",",res);
        }
    }

    // 向前
    private static void fun2(String src, boolean[][] dp, int i, String tempStr, List<String> res){
        if(tempStr.replaceAll(",","").length() == src.length()){
            res.add(tempStr);
            return;
        }
        if(tempStr.replaceAll(",","").length() > src.length()){
            return;
        }
        for(int j = i; j < src.length(); j++){
            if(dp[i][j])
                fun2(src,dp,j+1,tempStr+src.substring(i,j+1)+",",res);
        }
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("apple");
        list.add("pen");
        list.add("applepen");
        list.add("pine");
        list.add("pineapple");
        System.out.println(wordBreak("pineapplepenapple", list));
    }

}
