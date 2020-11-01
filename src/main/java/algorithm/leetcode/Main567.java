package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 567. 字符串的排列
 * 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * 输入: s1 = "ab" s2 = "eidbaooo"
 * 输出: True
 * 解释: s2 包含 s1 的排列之一 ("ba").
 *
 * @author lihaoyu
 * @date 2020/10/25 11:16 下午
 */
public class Main567 {

    // 注意是子串完全包含串
    public static boolean checkInclusion(String s1, String s2) {
        if (s1 == null || s2 == null || s2.length() < s1.length()) return false;
        Map<Character, Integer> srcMap = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            srcMap.put(s1.charAt(i), srcMap.getOrDefault(s1.charAt(i), 0) + 1);
        }

        // count 是满足的字符种类数
        int left = 0, right = 0, count = 0;
        while(right < s2.length()){
            char temp = s2.charAt(right);
            if (srcMap.containsKey(temp)) {
                window.put(temp, window.getOrDefault(temp, 0) + 1);
                // 当前字符 符合满足了
                if(window.get(temp).equals(srcMap.get(temp))) count++;
            }
            right++;
            // 左收缩
            if(right - left > s1.length()){
                temp = s2.charAt(left);
                if (srcMap.containsKey(temp)) {
                    // 不再符合了
                    if(window.get(temp).equals(srcMap.get(temp))) count--;
                    // 这里不可能有 default
                    window.put(temp, window.getOrDefault(temp, 0) - 1);
                }
                left++;
            }
         if(count == srcMap.size()) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("ab", "bac"));
    }
}
