package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * 示例 1：
 * <p>
 * 输入：
 * s = "barfoothefoobarman",
 * words = ["foo","bar"]
 * 输出：[0,9]
 * 解释：
 * 从索引 0 和 9 开始的子串分别是 "barfoo" 和 "foobar" 。
 * 输出的顺序不重要, [9,0] 也是有效答案。Ø
 * 示例 2：
 * <p>
 * 输入：
 * s = "wordgoodgoodgoodbestword",
 * words = ["word","good","best","word"]
 * 输出：[]
 *
 * @author lihaoyu
 * @date 2020/11/9 10:36 上午
 */
public class Main30 {

    public static List<Integer> findSubstring(String s, String[] words) {
        List<Integer> res = new ArrayList<>();
        if (words == null || words.length == 0 || s == null) return res;
        // 单词可能有重复的.
        Map<String, Integer> source = new HashMap<>();
        Map<String, Integer> window = new HashMap<>();
        // 源加入
        for (String word : words) source.put(word, source.getOrDefault(word, 0) + 1);
        // 因为 len 固定，所以只需要一个指针即可，没有收缩的过程
        int left = 0, wholeLen = words.length * words[0].length();
        while (left + wholeLen <= s.length()) {
            int right = left, count = 0,tempCount = words.length;
            while(right + tempCount * words[0].length() <= s.length() && right - left < wholeLen){
                String temp = s.substring(right, right + words[0].length());
                if(!source.containsKey(temp)) break;
                window.put(temp,window.getOrDefault(temp,0)+1);
                if(window.get(temp).equals(source.get(temp))) count++;
                if(count == source.size()){
                    // 加到结果里
                    res.add(left);
                    break;
                }
                right += words[0].length();
                tempCount--;
            }
            window.clear();
            left++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","word"}));
        System.out.println(findSubstring("sbarfoothefoobarman",new String[]{"foo","bar"}));
        System.out.println(findSubstring("wordgoodgoodgoodbestword",new String[]{"word","good","best","good"}));
    }
}
