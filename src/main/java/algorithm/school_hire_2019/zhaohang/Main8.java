package algorithm.school_hire_2019.zhaohang;

import java.util.Scanner;

/**
 * 招商银行信用卡中心	解码方法	865	27.86%
 *
 * 一条包含字母 A-Z 的消息通过以下方式进行了编码：
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 给定一个只包含数字的非空字符串，请计算解码方法的总数。
 *
 *  @author lihaoyu
 * @date 2019/10/27 11:23
 */
public class Main8 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int len = string.length();
        int a = 1;
        int b = 1;
        int temp;
        for(int i = 1; i < len; i++){
            temp = b;
            if(Integer.parseInt(string.substring(i-1,i+1)) <= 26){
                b = a+b;
            }
            a = temp;
        }
        System.out.println(b);
    }
}
