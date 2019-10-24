package algorithm.main.kuaishou;

import java.util.Scanner;

/**
 *快手	字符串压缩	1052	31.57%
 *  对字符串进行RLE压缩，将相邻的相同字符，
 * 用计数值和字符值来代替。例如：aaabccccccddeee，则可用3a1b6c2d3e来代替。
 *
 * @author lihaoyu
 * @date 2019/10/23 21:27
 */
public class Main15 {

    public static String fun(String string) {
        int count = 1;
        char[] chars = string.toCharArray();
        int len = chars.length;
        int i = 0;
        StringBuilder sb = new StringBuilder();
        while (i < len) {
            while (i < len - 1 && chars[i] == chars[i + 1]) {
                count++;
                i++;
            }
            sb.append( count + ""+chars[i] );
            count = 1;
            i++;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        System.out.println(fun(next));
    }
}
