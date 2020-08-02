package algorithm.temp;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 两个栈，出栈顺序
 * @author lihaoyu
 * @date 2019/11/16 22:39
 */
public class Main{

    final static String s1 = "abc";
    final static String s2 = "xy";
    final static List<String> res = new ArrayList<>();
    final static StringBuilder sb = new StringBuilder();

    static void fun(int i, int j){
        if(i == s1.length() && j == s2.length()){
            res.add(sb.toString());
            return;
        }
        if(i != s1.length()){
            sb.append(s1.charAt(i));
            fun(i+1,j);
            sb.deleteCharAt(sb.length()-1);
        }
        if(j != s2.length()){
            sb.append(s2.charAt(j));
            fun(i,j+1);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static void main(String[] args) {
        fun(0,0);
        System.out.println(res);
    }
}
