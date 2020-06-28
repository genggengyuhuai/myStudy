package algorithm.leetcode.offer;

/**
 * 123  -> abc, Lc, az  注意 0 对应 a
 *
 * @author lihaoyu
 * @date 2020/6/9 12:54 下午
 */
public class Main46 {

    public static int translateNum(int num) {
        // f(n) = f(n-1) + f(n-2) * flag
        String s = String.valueOf(num);
        if (s.length() <= 1) return s.length();
        int a = 1;
        int temp = Integer.parseInt(s.substring(0, 2));
        int b = 1;
        if(temp > 0 && temp <= 25) b = 2;
        for (int i = 2; i < s.length(); i++) {
            temp =  Integer.parseInt(s.substring(i-1,i+1));
            int flag = 0;
            if(temp >= 10 && temp <= 25) flag = 1;
            temp = a;
            a = b;
            b += flag * temp;
        }
        return b;

    }

    public static void main(String[] args) {
        System.out.println(translateNum(12258));
    }
}
