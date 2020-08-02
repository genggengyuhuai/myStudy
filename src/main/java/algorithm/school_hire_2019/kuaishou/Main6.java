package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 *  快手	字符串归一化	2214	34.33%
 * 通过键盘输入一串小写字母(a~z)组成的字符串。
 * 请编写一个字符串归一化程序，统计字符串中相同字符出现的次数，并按字典序输出字符及其出现次数。
 * 例如字符串"babcc"归一化后为"a1b2c2"
 *
 * @author lihaoyu
 * @date 2019/10/21 9:41
 */
public class Main6 {

    public static String fun(String s){
        int[] counts = new int[26];
        for(int i = 0; i < s.length(); i++){
            counts[s.charAt(i)-'a']++;
        }
        StringBuilder stringBuilder = new StringBuilder("");
        for(int i = 0; i < counts.length; i++){
            if(counts[i] != 0){
                stringBuilder.append((char)(i+'a')+""+counts[i]);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(fun(scanner.next()));
    }
}
