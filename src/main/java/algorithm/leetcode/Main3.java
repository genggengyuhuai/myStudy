package algorithm.leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  滑动窗口 ！
 *
 * @author lihaoyu
 * @date 2019/12/6 13:14
 */
public class Main3 {


    public static int lengthOfLongestSubstring(String s) {
        char[] cs = s.toCharArray();
        int maxLen = 1;
        List<Character> list = new LinkedList<>();
        for(int i = 0; i < s.length(); i++){
            if(list.isEmpty()){
                list.add(cs[i]);
                continue;
            }
            int index = list.indexOf(cs[i]);

            if(index >= 0){

            }
        }
        return maxLen;
    }


    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabcbb"));
    }
}
