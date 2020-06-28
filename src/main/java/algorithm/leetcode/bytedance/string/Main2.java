package algorithm.leetcode.bytedance.string;

/**
 * 最长公共前缀
 *
 * @author lihaoyu
 * @date 2020/6/28 8:06 下午
 */
public class Main2 {
    public static String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0) return "";
        StringBuilder sb = new StringBuilder();
        int len = 0;
        while(true){
            if(strs[0].length() <= len) return sb.toString();
            char temp = strs[0].charAt(len);
            for (String str : strs) {
               if(str.length() <= len || str.charAt(len) != temp) return sb.toString();
            }
            sb.append(temp);
            len++;
        }
    }

    public static void main(String[] args) {

    }
}
