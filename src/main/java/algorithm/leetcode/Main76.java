package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 李嘉捷 微软 一面 滑动窗口   Hard           写了 t 不含有重复字符的
 * 给你一个字符串 S、一个字符串 T 。请你设计一种算法，可以在 O(n) 的时间复杂度内，从字符串 S 里面找出：包含 T 所有字符的最小子串。
 * 示例：
 * <p>
 * 输入：S = "ADOBECODEBANC", T = "ABC"
 * 输出："BANC"
 *
 * @author lihaoyu
 * @date 3/9/2020 2:38 PM
 */
public class Main76 {

    public static String minWindow2(String s, String t) {
        Map<Character, Integer> src = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            src.put(t.charAt(i), src.getOrDefault(t.charAt(i), 0) + 1);
        }
        // count 是已经满足了几种字符
        int left = 0, right = 0, count = 0, minLen = Integer.MAX_VALUE, resBegin = 0;
        while (right < t.length()) {
            char c = t.charAt(right);
            // 上来就右移？
            right++;
            if (src.containsKey(c)) {
                window.put(c, window.getOrDefault(c, 0) + 1);
                if (window.get(c).equals(src.get(c))) count++;
            }
            // 如果所有字符都满足了，考虑左边收缩
            while(count == src.size()){
                // 更新答案
                if(right - left < minLen){
                    resBegin = left;
                    minLen = right - left;
                }
                // 移除
                char d = s.charAt(left);
                if(src.containsKey(d)){
                    if(window.get(d).equals(src.get(d))) count--;
                    window.put(d,window.get(d)-1);
                }
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(resBegin,minLen);
    }

    public static String minWindow(String s, String t) {
        Map<Character, Integer> pattern = new HashMap<>();
        String res = "";
        for (int i = 0; i < t.length(); i++) {
            pattern.put(t.charAt(i), pattern.getOrDefault(t.charAt(i), 0) + 1);
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        while (right < s.length()) {
            // right 前进
            while (right < s.length() && pattern.size() != window.size()) {
                if (pattern.containsKey(s.charAt(right))) {
                    int i = window.getOrDefault(s.charAt(right), 0) + 1;
                    window.put(s.charAt(right), i);
                }
                right++;
            }
            if (minLen >= right - left) {
                minLen = right - left;
                res = s.substring(left, right);
            }
            // left 前进
            while (left < right && pattern.size() == window.size()) {
                if (window.containsKey(s.charAt(left))) {
                    Integer count = window.get(s.charAt(left));
                    if (count == 1) {
                        window.remove(s.charAt(left));
                    } else {
                        window.put(s.charAt(left), count - 1);
                    }
                }
                left++;
                if (minLen >= right - left) {
                    minLen = right - left;
                    res = s.substring(left - 1, right);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
