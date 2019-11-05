package algorithm.school_hire_2019.disifanshi;

import java.util.Scanner;

/** 给定一个字符串（数字或大小写字母）, 找出最长的对称的子串（如有多个，输出任意一个）。
 * @author lihaoyu
 * @date 2019/11/5 13:28
 */
public class Main3 {

    private static String fun(String string, int i, int j){
        while (i >= 0 && j < string.length() && string.charAt(i) == string.charAt(j)){
            i--;
            j++;
        }
        return string.substring(i+1,j);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String res = "";
        for(int i = 0; i < s.length(); i++){
            String fun = fun(s, i, i);
            if(res.length() < fun.length()){
                res = fun;
            }
            if(i < s.length() - 1){
                String fun1 = fun(s, i, i + 1);
                if(res.length() < fun1.length()){
                    res = fun1;
                }
            }
        }
        System.out.println(res);


    }
}
