package algorithm.leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * 22. 括号生成
 * 给出 n 代表生成括号的对数，请你写出一个函数，使其能够生成所有可能的并且有效的括号组合。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author lihaoyu
 * @date 2019/12/25 12:38
 */
public class Main22 {

    private static StringBuilder sb;
    private static List<String> res;


    private static void fun(int real, int logic, int n, StringBuilder sb, List<String> res){
        if(sb.length() == 2 * n){
            res.add(sb.toString());
            return;
        }
        if(real < n){
            fun(real+1,logic+1,n,sb.append('('),res);
            sb.deleteCharAt(sb.length()-1);
        }
        // 栈中还有左括号
        if(logic > 0){
            fun(real,logic-1,n,sb.append(')'),res);
            sb.deleteCharAt(sb.length()-1);
        }
    }

    public static List<String> generateParenthesis(int n) {
        sb = new StringBuilder();
        res = new ArrayList<>();
        fun(0,0,n,sb,res);
        return res;
    }

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
        System.out.println(generateParenthesis(1));
    }
}
