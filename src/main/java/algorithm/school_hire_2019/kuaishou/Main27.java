package algorithm.school_hire_2019.kuaishou;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 给定一个字符串，请找出其中长度最长且不含有重复字符的子串，计算该子串长度。
 * @author lihaoyu
 * @date 2019/12/28 15:36
 */
public class Main27 {
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
        Scanner scanner = new Scanner(System.in);
        System.out.println(lengthOfLongestSubstring2(scanner.next()));
    }
}
