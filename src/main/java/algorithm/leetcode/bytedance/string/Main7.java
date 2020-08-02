package algorithm.leetcode.bytedance.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 复原ip地址
 * 输入: "25525511135"
 * 输出: ["255.255.11.135", "255.255.111.35"]
 *
 * @author lihaoyu
 * @date 2020/6/28 9:50 下午
 */
public class Main7 {

    private String src;
    private List<String> list = new ArrayList<>();

    private void fun(int index, int count, StringBuilder sb) {
        if (index == src.length() && count == 4) {
            list.add(sb.toString());
            return;
        }
        // 可优化
        if (index >= src.length() || count > 4) {
            return;
        }
        // 一位数
        sb.append(src.charAt(index));
        if (count != 3) sb.append(".");
        fun(index + 1, count + 1, sb);
        sb.deleteCharAt(sb.length() - 1);
        if (count != 3) sb.deleteCharAt(sb.length() - 1);
        // 特判 0
        if (src.charAt(index) == '0') return;
        // 两位数,需要判断长度
        if (index + 2 > src.length()) return;
        sb.append(src, index, index + 2);
        if (count != 3) sb.append(".");
        fun(index + 2, count + 1, sb);
        sb.delete(sb.length() - 2, sb.length());
        if (count != 3) sb.deleteCharAt(sb.length() - 1);
        // 三位数，需要判断长度和大小
        if (index + 3 > src.length() || Integer.parseInt(src.substring(index, index + 3)) > 255) return;
        sb.append(src, index, index + 3);
        if (count != 3) sb.append(".");
        fun(index + 3, count + 1, sb);
        sb.delete(sb.length() - 3, sb.length());
        if (count != 3) sb.deleteCharAt(sb.length() - 1);
    }

    public List<String> restoreIpAddresses(String s) {
        if (s == null) return list;
        src = s;
        fun(0, 0, new StringBuilder());
        return list;
    }


    public static void main(String[] args) {
        Main7 main7 = new Main7();
        System.out.println(main7.restoreIpAddresses("1001000"));
    }
}
