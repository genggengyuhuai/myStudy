package algorithm.leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * 李嘉捷 微软 一面 滑动窗口   Hard           写了 t 不含有重复字符的
 * @author lihaoyu
 * @date 3/9/2020 2:38 PM
 */
public class Main76 {

    public static String minWindow(String s, String t) {
        Map<Character, Integer> pattern = new HashMap<>();
        String res = "";
        for (int i = 0; i < t.length(); i++) {
            pattern.put(t.charAt(i),pattern.getOrDefault(t.charAt(i), 0)+1);
        }
        int left = 0, right = 0, minLen = Integer.MAX_VALUE;
        Map<Character, Integer> window = new HashMap<>();
        while(right < s.length()){
            // right 前进
            while(right < s.length() && pattern.size() != window.size()){
                if(pattern.containsKey(s.charAt(right))){
                    int i = window.getOrDefault(s.charAt(right), 0) + 1;
                    window.put(s.charAt(right),i);
                }
                right++;
            }
            if(minLen >= right - left){
                minLen =   right - left;
                res = s.substring(left,right);
            }
            // left 前进
            while(left < right && pattern.size() == window.size()){
                if(window.containsKey(s.charAt(left))){
                    Integer count = window.get(s.charAt(left));
                    if(count == 1){
                        window.remove(s.charAt(left));
                    }else{
                        window.put(s.charAt(left),count-1);
                    }
                }
                left++;
                if(minLen >= right - left){
                    minLen =   right - left;
                    res = s.substring(left-1,right);
                }
            }
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(minWindow("ADOBECODEBANC", "ABC"));
    }
}
