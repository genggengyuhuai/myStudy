package algorithm.school_hire_2019.wangyihuyu;

import java.util.Scanner;

/**
 * 小A很喜欢字母N，他认为连续的N串是他的幸运串。有一天小A看到了一个全部由大写字母组成的字符串，他被允许改变最多2个大写字母
 * （也允许不改变或者只改变1个大写字母），使得字符串中所包含的最长的连续的N串的长度最长。你能帮助他吗？
 * @author lihaoyu
 * @date 2019/12/29 10:48
 */
public class Main7 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            String string = scanner.next();
            int[] dp1 = new int[string.length() + 1];
            int[] dp2 = new int[string.length() + 1];
            int[] dp3 = new int[string.length() + 1];
            for (int i = 0; i < string.length(); i++) {
                if (string.charAt(i) != 'N') {
                    dp1[i + 1] = 0;
                    dp2[i + 1] = dp1[i] + 1;
                    dp3[i + 1] = dp2[i] + 1;
                } else {
                    dp1[i + 1] = dp1[i] + 1;
                    dp2[i + 1] = dp2[i] + 1;
                    dp3[i + 1] = dp3[i] + 1;
                }
            }

            int max = 0;
            for (int i = 0; i < dp3.length; i++) {
                max = Math.max(max, dp3[i]);
            }
            System.out.println(max);
        }
    }

}
