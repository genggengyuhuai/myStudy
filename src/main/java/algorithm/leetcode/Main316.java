package algorithm.leetcode;

import java.util.HashMap;

/**
 * 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 *
 * 示例 1:
 *
 * 输入: "bcabc"
 * 输出: "abc"
 * 示例 2:
 *
 * 输入: "cbacdcbc"
 * 输出: "acdb"
 * @author lihaoyu
 * @date 2020/12/20 10:30 下午
 */
public class Main316 {

    // 单调栈
    public static String removeDuplicateLetters(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        StringBuilder stack = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
        char c = s.charAt(i);
          while(stack.length() != 0 && map.get(stack.charAt(stack.length() - 1)) != 1 && stack.charAt(stack.length() - 1) >  c){
            stack.deleteCharAt(stack.length() - 1);
            map.put(c, map.get(c) - 1);
          }
          stack.append(c);
        }
        // 最后一个
        return stack.toString();
    }


    public static void main(String[] args) {
        System.out.println(removeDuplicateLetters("cdfcd"));
    }
}
