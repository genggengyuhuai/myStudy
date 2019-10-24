package algorithm.jiu_shi_gan.kuaishou;

import java.util.Scanner;

/**
 * 快手	解析加减法运算	745	30.73%
 * 解析加减法运算
 * 如：
 * 输入字符串："1+2+3" 输出："6"
 * 输入字符串："1+2-3" 输出："0"
 * 输入字符串："-1+2+3" 输出："4"
 * 输入字符串："1" 输出："1"
 * 输入字符串："-1" 输出："-1"
 * @author lihaoyu
 * @date 2019/10/23 21:35
 */
public class Main16 {

    public static boolean fun(char c){
        return c >= '0' && c <= '9';
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int sum = 0;
        int i = 0;
        int plus = 1;
        while(i < next.length()){
            int start = i;
            if(!fun(next.charAt(i))){
                plus = next.charAt(i) == '+' ? 1 : -1;
                i++;
                continue;
            }
            while(i<next.length() && fun(next.charAt(i))){
                i++;
            }
            sum += plus * (Integer.parseInt(next.substring(start,i)));
        }
        System.out.println(sum);


    }
}
