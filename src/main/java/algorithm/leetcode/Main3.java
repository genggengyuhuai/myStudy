package algorithm.leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *  头延伸，尾收缩的    滑动窗口 ！
 *  abcdcqwer 输出 dcqwer 6
 *
 * @author lihaoyu
 * @date 2019/12/6 13:14
 */
public class Main3 {


    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        Set<Character> set = new HashSet<>(32);
        int i = 0, j = 0, maxLen = 1;
        while(i < cs.length){
            while(j < cs.length && !set.contains(cs[j])){
                set.add(cs[j]);
                j++;
                maxLen = Math.max(maxLen,set.size());
            }
            if(j == cs.length) return maxLen;
            set.remove(cs[i]);
            i++;
        }
        return maxLen;
    }

    public static int lengthOfLongestSubstring2(String s) {
        if(s == null || s.length() == 0) return 0;
        char[] cs = s.toCharArray();
        Map<Character,Integer> map = new HashMap<>(32);
        int i = 0, j = 0, maxLen = 1;
        while(j < cs.length) {
            if(map.containsKey(cs[j])){
                i = Math.max(i,map.get(cs[j])+1);
            }
            maxLen = Math.max(maxLen, j-i+1);
            map.put(cs[j], j);
            j++;
        }
        return maxLen;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring2("abcdcqwer"));
    }
}
