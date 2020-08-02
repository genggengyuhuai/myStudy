package algorithm.leetcode;

/**
 * 29. 两数相除    被除数位移
 * @author lihaoyu
 * @date 2019/12/24 20:27
 */
public class Main29 {
    public static int divide(int dividend, int divisor) {
        if(dividend == 0) return 0;
        if(dividend == Integer.MIN_VALUE && divisor == -1) return Integer.MAX_VALUE;
        boolean zheng = false;
        if(dividend < 0 && divisor < 0 || dividend > 0 && divisor > 0) zheng = true;
        long bei = Math.abs((long)dividend);
        long chu = Math.abs((long)divisor);
        long res = 0;
        while(bei >= chu){
            long tempRes = 1;
            long tempDivisor = chu;
            while((tempDivisor << 1) < bei){
                tempRes = tempRes << 1;
                tempDivisor = tempDivisor << 1;
            }
            bei -= tempDivisor;
            res += tempRes;
        }
        return(int)(res * (zheng ? 1 : -1));
    }

    public static void main(String[] args) {
        System.out.println(divide(Integer.MIN_VALUE,1));
    }
}
