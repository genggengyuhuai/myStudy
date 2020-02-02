package algorithm.school_hire_2019.mogujie;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * 输入一个字符串,按字典序打印出该字符串中字符的所有排列。
 * @author lihaoyu
 * @date 2/2/2020 1:18 PM
 */
public class Main2 {

    private static List<String> res = new ArrayList<>();
    private static boolean[] flags;

    private static void fun(char[] cs, int index, String sb){
        if(index >= cs.length){
            res.add(sb);
            return;
        }
        for(int j = 0; j < cs.length; j++){
            if(!flags[j]){
                flags[j] = true;
                fun(cs,index+1,sb+cs[j]);
                flags[j] = false;
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.next().toCharArray();
        Arrays.sort(chars);
        flags = new boolean[chars.length];
        fun(chars,0,"");
        System.out.println(res);

    }
}
