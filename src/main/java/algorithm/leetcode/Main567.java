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
 * @author lihaoyu
 * @date 2020/10/25 11:16 下午
 */
public class Main567 {
    // 注意是子串包含串
    public static boolean checkInclusion(String s1, String s2) {
        if(s1 == null || s2 == null) return false;
        Map<Character, Integer> srcMap = new HashMap<>(), window = new HashMap<>();
        for (int i = 0; i < s1.length(); i++) {
            srcMap.put(s1.charAt(i),srcMap.getOrDefault(s1.charAt(i),0) + 1);
        }
        int left = 0, right = 0;
       while(left < s2.length()){
           char cur = s2.charAt(left);
           if(!srcMap.containsKey(cur)){
               left++;
               continue;
           }
           right = left;
           // 开始计算当前子串是否匹配, count 是满足的字符种类，不超过26
           int count = 0;
           // 右指针
           while(right < s2.length()){
               char cur2 = s2.charAt(right);
                if(!srcMap.containsKey(cur2)){
                    break;
                }
                window.put(cur2,window.getOrDefault(cur2,0)+1);
                if(window.get(cur2).equals(srcMap.get(cur2))) count++;
                // 种类全部满足，直接返回
                if(count == srcMap.size()) return true;
                right++;
           }
           left = right + 1;
           window.clear();
       }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(checkInclusion("hello", "ooolleoooleh"));
    }
}
