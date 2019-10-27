package algorithm.school_hire_2019.kuaishou;

import java.util.Scanner;

/**
 *
 *
 * 已知一个字符串数组words，要求寻找其中两个没有重复字符的字符串，使得这两个字符串的长度乘积最大，输出这个最大的乘积。如：
 * words=["abcd","wxyh","defgh"], 其中不包含重复字符的两个字符串是"abcd"和"wxyh"，则输出16
 * words=["a","aa","aaa","aaaa"], 找不到满足要求的两个字符串，则输出0
 *
 * @author lihaoyu
 * @date 2019/10/26 19:10
 */
public class Main19 {

    public static boolean haveSame(String s1, String s2){
        for(int i = 0; i < s1.length(); i++)
            for(int j = 0; j < s2.length(); j++)
                if(s1.charAt(i) == s2.charAt(j))
                    return true;
        return false;
    }

    public static int fun(String[] s){
        int max = 0;
        int len = s.length;
        for(int i = 0; i < len; i++){
            for(int j = i+1; j < len; j++){
                if(!haveSame(s[i],s[j])){
                    max = Math.max(max, s[i].length() * s[j].length());
                }
            }
        }

        return max;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        String[] strings = s.substring(1, s.length() - 1).replace("\"","").split(",");
        System.out.println(fun(strings));

    }
}
