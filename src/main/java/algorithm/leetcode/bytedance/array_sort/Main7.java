package algorithm.leetcode.bytedance.array_sort;

/**
 * 第 k 个排列
 * n = 5  字符串12345的全排列的第k个是？
 *
 * @author lihaoyu
 * @date 2020/7/5 10:43 上午
 */
public class Main7 {

    // 记录排列数
    private static int[] permuteNums;
    private int n;
    // 记录当前数字自否已被使用
    private boolean[] flag;

    private static void prepare() {
        permuteNums = new int[10];
        permuteNums[0] = 1;
        for (int i = 1; i <= 9; i++) {
            permuteNums[i] = i * permuteNums[i - 1];
        }
    }

    private void fun(int k, StringBuilder sb) {
        if (sb.length() == n) return;
        int index = sb.length() + 1;
        // 小于，取第一个可以用的数字
        if (k <= permuteNums[n - index]) {
            for (int i = 1; i < flag.length; i++) {
                if (!flag[i]) {
                    sb.append(i);
                    flag[i] = true;
                    break;
                }
            }
            fun(k, sb);
            return;
        }
        // 大于， 取模计算第一个可以用的数字
        int count = k / permuteNums[n - index];
        int available = -1;
        for (int i = 1, tempCount = 0; i < flag.length; i++) {
            if (!flag[i] && tempCount == count) {
                flag[i] = true;
                available = i;
                break;
            }
            if (!flag[i]) {
                tempCount++;
            }

        }
        if(available == -1) available = flag.length-1;
        fun(k - permuteNums[n - index] * count, sb.append(available));
    }

    public String getPermutation(int n, int k) {
        this.n = n;
        flag = new boolean[n + 1];
        StringBuilder sb = new StringBuilder();
        fun(k, sb);
        return sb.toString();
    }

    public static void main(String[] args) {
        prepare();
        Main7 main7 = new Main7();
        System.out.println(main7.getPermutation(3, 2));
    }
}
