package algorithm.leetcode;

/**
 * 实现 int sqrt(int x) 函数。
 * 计算并返回 x 的平方根，其中 x 是非负整数。
 * 由于返回类型是整数，结果只保留整数的部分，小数部分将被舍去
 * @author lihaoyu
 * @date 2020/5/9 1:28 下午
 */
public class Main69 {

    public static int mySqrt(int x) {
    if(x == 0) return 0;
    if(x == 1 || x == 2 || x == 3) return 1;
    long start = 0, end = x;
    while(start < end){
        long mid = (start + end ) >> 1;
        if(mid * mid == x){
            return (int)mid;
        }
        if(mid * mid > x){
            end = mid - 1;
        }else{
            start = mid + 1;
        }
    }
    if(end * end > x) return (int)(end-1);
        return (int)end;
    }


    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }
}
