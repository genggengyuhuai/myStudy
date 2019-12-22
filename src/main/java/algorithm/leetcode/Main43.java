package algorithm.leetcode;

import java.util.Scanner;

/**
 * 43. 字符串相乘  大树相乘 乘法
 * @author lihaoyu
 * @date 2019/12/20 21:20
 */
public class Main43 {

    public static String multiply(String num1, String num2) {
        if(num1 == null || num2 == null || num1.length() == 0 || num2.length() == 0) return "";
        if("0".equals(num1) || "0".equals(num2)) return "0";
        int[] res = new int[num1.length() + num2.length()];
        int x , y, temp;
        for(int i = num1.length() - 1; i >= 0; i--){
               x = num1.charAt(i) - '0';
            for(int j = num2.length() - 1; j >= 0; j--){
                y = num2.charAt(j) - '0';
                temp = (res[i+j+1] + x * y);
                res[i+j+1] = temp % 10;
                res[i+j] += temp / 10;

            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < res.length; i++) {
            if(i == 0 && res[i] == 0){
                continue;
            }
            sb.append(res[i]);
        }
        return sb.toString();
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        String next1 = scanner.next();
        System.out.println(multiply(next1,next));
    }
}
