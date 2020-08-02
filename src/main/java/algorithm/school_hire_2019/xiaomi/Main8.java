package algorithm.school_hire_2019.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 我们来做一个简单的密码破译游戏。破译的规则很简单，将数字转换为字母，1转化为a，2转化为b，依此类推，26转化为z。
 * 现在输入的密码是一串数字，输出的破译结果是该数字串通过转换规则所能产生的所有字符串。
 * @author lihaoyu
 * @date 2019/11/5 20:31
 */
public class Main8 {

    private static void fun(String string, int index, StringBuilder sb, List<String> res) {
        if (index >= string.length()) {
            res.add(sb.toString());
            return;
        }
        if (string.charAt(index) == '0') {
            return;
        }
        sb.append((char) ('a' + string.charAt(index) - '1'));
        fun(string, index + 1, sb, res);
            sb.delete(sb.length() - 1, sb.length());
        if (index <= string.length() - 2 && Integer.parseInt(string.substring(index, index + 2)) <= 26) {
            sb.append((char) ('a' + (Integer.parseInt(string.substring(index, index + 2)) - 1)));
            fun(string, index + 2, sb, res);
                sb.delete(sb.length() - 1, sb.length());
        }

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            StringBuilder sb = new StringBuilder();
            List<String> list = new ArrayList<>();
            String string = scanner.next();
            fun(string, 0, sb, list);
            for (int i = 0; i < list.size(); i++) {
                if (i != list.size() - 1) {
                    System.out.print(list.get(i) + " ");
                } else {
                    System.out.println(list.get(i));
                }
            }
        }


    }
}
