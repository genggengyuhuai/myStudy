package algorithm.leetcode;

/**
 * 实现 pow(x,n)
 * @author lihaoyu
 * @date 2020/5/11 10:08 上午
 */
public class Main50 {

    private static double fun(double x, int n){
        if( n == 0) return 1;
        if( n == 1) return x;
        double fun = fun(x, n >> 1);
        return fun * fun * ((n & 1) == 0 ? 1 : x);
    }

    public static double myPow(double x, int n) {
        boolean flag = n < 0;
        n = Math.abs(n);
        if( n == Integer.MIN_VALUE) return 1 / ( x * fun(x, Integer.MAX_VALUE));
        return flag ? 1 / fun(x, n) : fun(x, n);
    }

    public static void main(String[] args) {
        System.out.println(myPow(1.00000 ,-2147483648));
    }
}
