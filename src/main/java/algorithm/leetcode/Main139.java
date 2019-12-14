package algorithm.leetcode;

import java.util.List;

/**
 * 139. 单词拆分
 * 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词。
 * @author lihaoyu
 * @date 2019/12/14 19:22
 */
public class Main139{

    public static boolean wordBreak(String s, List<String> wordDict) {
        int i , j ;
        boolean[] flags = new boolean[s.length()+1];
        flags[0] = true;
        for(i = 1; i <= s.length(); i++){
            for(j = 0; j < i; j++){
                if(flags[j] && wordDict.contains(s.substring(j,i))){
                    flags[i] = true;
                    break;
                }
            }
        }
        return flags[s.length()];
    }


    public static void main(String[] args) {

    }
}
