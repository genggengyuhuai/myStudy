package algorithm.leetcode.bytedance.string;


/**
 * 给定一个字符串，逐个翻转字符串中的每个单词。
 * 去除多余的空格
 * @author lihaoyu
 * @date 2020/6/28 9:35 下午
 */
public class Main5 {

    public static String reverseWords(String s) {
        s = s.trim();
        String[] s1 = s.split(" ");
        StringBuilder sb = new StringBuilder(s1.length);
        for (int i = s1.length - 1; i >= 0; i--) {
            if("".equals(s1[i])) continue;
            sb.append(s1[i]);
            if(i != 0) sb.append(" ");
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseWords(" a good   example  "));
    }
}
