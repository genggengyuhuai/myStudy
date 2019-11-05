package algorithm.school_hire_2019.wangyihuyu;

import java.util.Scanner;

/**
 * 现在你需要用一台奇怪的打字机书写一封书信。信的每行只能容纳宽度为100的字符，也就是说如果写下某个字符会导致行宽超过100，那么就要另起一行书写
 * 信的内容由a-z的26个小写字母构成，而每个字母的宽度均会事先约定。例如字符宽度约定为[1,2,3,4,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5,5]，那么就代表'a'到'd'四个字母的宽度分别是1,2,3,4，而'e'到'z'的宽度均为5
 * 那么按照上述规则将给定内容S书写成一封信后，这封信共有几行？最后一行宽度是多少？
 *
 * @author lihaoyu
 * @date 2019/11/5 13:53
 */
public class Main4 {
    private static final int MAX = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] width = new int[26];
        for (int i = 0; i < 26; i++) {
            width[i] = scanner.nextInt();
        }
        String next = scanner.next();
        int rowNumber = 1;
        int curLength = 0;
        int curWidth;
        for (int i = 0; i < next.length(); i++) {
            curWidth = width[next.charAt(i) - 'a'];
            if (curWidth > MAX - curLength) {
                curLength = 0;
                rowNumber++;
                i--;
                continue;
            }
            curLength += curWidth;
        }
        System.out.println(rowNumber + " " + curLength);

    }

}