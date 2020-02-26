package algorithm.basic_algorithm;

import java.util.Stack;

/**
 * 最大字典序子序列     单调栈
 * 给定 数字串或者 字符串   3，2，4，1，5，0   从中取 k 个数字，保持原有顺序，组成的数字最大
 * @author lihaoyu
 * @date 2/26/2020 10:45 PM
 */
public class Main1 {

    private static void fun(int[] a, int k){
        Stack<Integer> stack = new Stack<>();
        int size = a.length - k;
        for (int i = 0; i < a.length; i++) {
            //  注意最后一个   size-- 是数量限制
            while(!stack.isEmpty() && a[i] > stack.peek() && size-- > 0){
                stack.pop();
            }
            stack.add(a[i]);
        }

    }

    public static void main(String[] args) {

    }


}
