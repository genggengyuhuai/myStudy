package algorithm.jianzhi_offer;

import java.util.Scanner;

/**
 * 给你一根长度为n的绳子，请把绳子剪成整数长的m段（m、n都是整数，n>1并且m>1），每段绳子的长度记为k[0],k[1],...,k[m]。请问k[0]xk[1]x...xk[m]可能的最大乘积是多少？
 * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * @author lihaoyu
 * @date 2019/11/28 18:10
 */
public class Solution2 {

    public static int cutRope(int target) {
        if(target == 2){
            return 1;
        }
        if(target == 3){
            return 2;
        }

        int count2 = 0, count3 = 0,temp,left,res = 1;
        if((target & 1) == 1){
            target -= 3;
            count3++;
        }
        // 偶数
        if((target & 1) == 0){
            count2 = target/2;
            // temp 组 2个3
            temp = count2 / 3;
            for (int i = 0; i < temp; i++) {
                res *= 9;
            }
            left = count2 - 3 * temp;
            for (int i = 0; i < left; i++) {
                res *= 2;
            }
        }
        for (int i = 0; i < count3; i++) {
            res *= 3;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        System.out.println(cutRope(N));
    }
}
