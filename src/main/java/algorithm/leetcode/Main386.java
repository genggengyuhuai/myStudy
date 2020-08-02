package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 386. 字典序排数
 * 给定 n =1 3，返回 [1,10,11,12,13,2,3,4,5,6,7,8,9] 。
 * @author lihaoyu
 * @date 2019/12/25 23:02
 */
public class Main386 {

    private static void fun(List<Integer> res, String string, int n){
        if(string.length() > 0 && Integer.parseInt(string) <= n){
            res.add(Integer.parseInt(string));
        }
        if(string.length() > 0 && Integer.parseInt(string) > n){
            return;
        }
        for(int i = 0; i <= 9; i++){
            if(i == 0 && string.length() == 0){
                continue;
            }
            fun(res,string+i,n);
        }
    }

    public static List<Integer> lexicalOrder(int n) {
        List<Integer> res = new ArrayList<>();
        fun(res,"",n);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(lexicalOrder(111));
    }
}
