package algorithm.leetcode;

/**
 * 316. 去除重复字母(困难)
 * 321. 拼接最大数(困难)
 * 402. 移掉 K 位数字(中等)
 * 1081. 不同字符的最小子序列（中等）
 *
 *
 给定一个以字符串表示的非负整数 num，移除这个数中的 k 位数字，使得剩下的数字最小。

 * 示例 1 :
 *
 * 输入: num = "1432219", k = 3
 * 输出: "1219"
 * 解释: 移除掉三个数字 4, 3, 和 2 形成一个新的最小的数字 1219。
 * 示例 2 :
 *
 * 输入: num = "10200", k = 1
 * 输出: "200"
 * 解释: 移掉首位的 1 剩下的数字为 200. 注意输出不能有任何前导零。
 * 示例 3 :
 *
 * 输入: num = "10", k = 2
 * 输出: "0"
 * 解释: 从原数字移除所有的数字，剩余为空就是 0。
 * @author lihaoyu
 * @date 2020/12/20 9:36 下午
 */
public class Main402 {

    // 移除K个字符，使剩下的数最小
    // 使用单调栈
    public static String removeKdigits(String num, int k) {
        if(k >= num.length()) return "0";
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < num.length(); i++) {
            char temp = num.charAt(i);
            // 栈顶更大，出栈
            while(sb.length() > 0 && sb.charAt(sb.length() - 1) > temp && k > 0){
                sb.deleteCharAt(sb.length() - 1);
                k--;
            }
            // 入栈
            sb.append(temp);
        }
        // 去掉所有前导0
        int zeroEnd = 0;
        while(zeroEnd < sb.length() && sb.charAt(zeroEnd) == '0') zeroEnd++;
        String res = sb.substring(zeroEnd, sb.length());
        if (res.length() == 0) {
            return "0";
        }
        if(k > 0){
            return res.substring(0,res.length() - k);
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(removeKdigits("112", 1));
    }

}
