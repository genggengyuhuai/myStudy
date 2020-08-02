package algorithm.leetcode;

/**
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 * @author lihaoyu
 * @date 2/6/2020 8:44 PM
 */
public class Main91 {

    public static int numDecodings(String s) {
        if(s == null || s.length() == 0 || s.charAt(0) == '0') return 0;
        if(s.length() == 1) return 1;
        if(s.charAt(0)>'2' && s.charAt(1) == '0') return 0;
        int prev = 1, temp, parse, post = 1 +
                ((Integer.parseInt(s.substring(0,2)) <= 26 && s.charAt(0) != '0' && s.charAt(1) != '0') ? 1 : 0);
        for(int i = 2; i < s.length(); i++){
            parse = Integer.parseInt(s.substring(i - 1, i + 1));
            if(parse == 0) return 0;
            if(s.charAt(i) == '0'){
                if(s.charAt(i-1)>'2') return 0;
                post = prev;
            }
            else{
                temp = post;
                post = post + ((parse  <= 26 && s.charAt(i-1) != '0' && s.charAt(i) != '0') ? prev : 0);
                prev = temp;
            }
        }
        return post;
    }

    public static void main(String[] args) {
        System.out.println(numDecodings("110110"));
    }

}
