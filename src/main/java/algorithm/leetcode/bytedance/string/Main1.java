package algorithm.leetcode.bytedance.string;


import java.util.Arrays;

/**
 * leetcode 字节跳动题库   挑战字符串类
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 * @author lihaoyu
 * @date 2020/6/28 9:57 上午
 */
public class Main1 {

    // 双指针法
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() <= 0) return 0;
        int[] index = new int[255];
        Arrays.fill(index,-1);
        int left = 0, right = 0, res = 1;
        while(right <= s.length()){
            while(right < s.length() && index[s.charAt(right)] == -1){
                index[s.charAt(right)] = right;
                right++;
                res = Math.max(res, right - left);
            }
            // right 的指向有重复, 移动 left 后把 老 left 到 新 left 之间的 Index 置 -1
            if(right >= s.length()) return res;
            int temp = left;
            left = index[s.charAt(right)] + 1;
            for(int i = temp; i < left; i++){
                index[s.charAt(i)] = -1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("bbbb"));
    }
}
