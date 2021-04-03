package algorithm.leetcode;

import java.util.Arrays;

/**
 * 单调栈
 * 惠天宇字节二面，2021.4.2
 * 739. 每日温度
 * 请根据每日 气温 列表，重新生成一个列表。对应位置的输出为：要想观测到更高的气温，至少需要等待的天数。如果气温在这之后都不会升高，请在该位置用 0 来代替。
 * 例如，给定一个列表 temperatures = [73, 74, 75, 71, 69, 72, 76, 73]，你的输出应该是 [1, 1, 4, 2, 1, 1, 0, 0]。
 * 提示：气温 列表长度的范围是 [1, 30000]。每个气温的值的均为华氏度，都是在 [30, 100] 范围内的整数。
 *
 * @author lihaoyu
 * @date 2021/4/2 18:56
 */
public class Main739 {

    public static int[] dailyTemperatures(int[] T) {
        // 单调栈
        int[] stack = new int[T.length], res = new int[T.length];
        int top = 0;
        // 从右面开始遍历，放进去的是Index
        for (int i = T.length - 1; i >= 0; i--) {
            while (top != 0 && T[i] >= T[stack[top - 1]]) {
                // 出栈
                top--;
            }
            res[i] = top == 0 ? 0 : (stack[top - 1] - i);
            stack[top++] = i;
        }
        return res;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(dailyTemperatures(new int[]{73, 74, 75, 71, 69, 72, 76, 73})));
    }
}
