package algorithm.leetcode.interview;

import java.util.ArrayList;
import java.util.List;

/**
 * 括号。设计一种算法，打印n对括号的所有合法的（例如，开闭一一对应）组合。
 * 说明：解集不能包含重复的子集。
 * 例如，给出 n = 3，生成结果为：
 * [
 *   "((()))",
 *   "(()())",
 *   "(())()",
 *   "()(())",
 *   "()()()"
 * ]
 * @author lihaoyu
 * @date 2020/5/5 10:02 下午
 */
public class Main0809 {

    private int N;
    private StringBuilder sb = new StringBuilder();
    private List<String> res = new ArrayList<>();

    // n 代表剩余 （  的数量   m 代表 剩余 ） 的数量
    private void fun(int n, int m) {
        if (n == 0 && m == 0) {
            res.add(sb.toString());
            return;
        }
        if(n > 0){
            sb.append('(');
            fun(n-1,m);
            sb.deleteCharAt(sb.length()-1);
        }

        // 注意这里的   m > n
        if( m > 0 && m > n){
            sb.append(')');
            fun(n,m-1);
            sb.deleteCharAt(sb.length()-1);
        }
    }


    public List<String> generateParenthesis(int n) {
        N = n;
        fun(n,n);
        return res;
    }


    public static void main(String[] args) {
        Main0809 main0809 = new Main0809();
        System.out.println(main0809.generateParenthesis(3));
    }
}
