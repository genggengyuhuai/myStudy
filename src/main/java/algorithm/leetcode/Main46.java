package algorithm.leetcode;

/**
 * 123  -> abc, Lc, az  注意 0 对应 a
 * @author lihaoyu
 * @date 2020/6/9 12:54 下午
 */
public class Main46 {

    public int translateNum(int num) {
        // f(n) = 1 + f(n-1) * flag
        if(num <= 10) return 1;
        String s = String.valueOf(num);
        int f0 = 1;
        for (int i = 1; i < s.length(); i++) {
            int temp = Integer.parseInt(s.substring(i - 1, i + 1));
            if(temp <= 25 && temp != 0) f0 = 1 + f0;
        }
        return 0;

    }

    public static void main(String[] args) {

    }
}
