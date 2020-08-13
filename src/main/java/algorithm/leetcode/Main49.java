package algorithm.leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 给定一个字符串数组，将字母异位词组合在一起。字母异位词指字母相同，但排列不同的字符串。
 * 输入: ["eat", "tea", "tan", "ate", "nat", "bat"]
 * 输出:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * @author lihaoyu
 * @date 2020/8/10 10:37 下午
 */
public class Main49 {

    // string 抽象出来   0120000402010005006 这种，长度为26位的字符串
    private static String fun(String s){
        int[] counts = new int[26];
        for (int i = 0; i < s.length(); i++) {
            counts[s.charAt(i)-'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for (int count : counts) {
            sb.append(count);
        }
      return sb.toString();
    }


    public static List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<>();
        if(strs == null || strs.length == 0) return res;
        Map<String, List<String>> map = new HashMap<>(strs.length);
        for (String str : strs) {
            String fun = fun(str);
            if (!map.containsKey(fun)){
                List<String> tempSet = new ArrayList<>();
                tempSet.add(str);
                map.put(fun,tempSet);
            }else {
                List<String> tempSet = map.get(fun);
                tempSet.add(str);
            }
        }
        for (String fun : map.keySet()) {
            res.add(new ArrayList<>(map.get(fun)));
        }
        return res;
    }

    public static void main(String[] args) {
        groupAnagrams(new String[]{"",""}).forEach(System.out::println);
    }
}
