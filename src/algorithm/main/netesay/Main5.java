package algorithm.main.netesay;

import java.util.Scanner;

/**
 * 19 校招  网易  数对
 * 牛牛以前在老师那里得到了一个正整数数对(x, y), 牛牛忘记他们具体是多少了。
 *
 * 但是牛牛记得老师告诉过他x和y均不大于n, 并且x除以y的余数大于等于k。
 * 牛牛希望你能帮他计算一共有多少个可能的数对。
 *
 * 输入描述:
 * 输入包括两个正整数n,k(1 <= n <= 10^5, 0 <= k <= n - 1)。
 * 输出描述:
 * 对于每个测试用例, 输出一个正整数表示可能的数对数量。
 * @author lihaoyu
 * @date 2019/9/7 10:24
 */
public class Main5 {

    /**
     * x , y < 10 且 x % y >= 3
     *
     * @return 数量
     * @author lihaoyu
     * @param n
     * @param k
     */
    private static long fun(int n, int k){
        if(k == 0){
            return (long)Math.pow(n,2);
        }
        long count = 0;
        for(int i = k+1; i <= n; i++){
            // 每组个数
            long every = i - k;
            // 至少 shang - 1 组 ， 最后一组可能不全
            long shang = (n - k) / i + 1;

            // 最后一组全
            if(shang * i - 1 <= n){
                count += every * shang;
            }
           else{
               count += every * (shang - 1) + (n - k) % i + 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int k = scanner.nextInt();
            System.out.println(fun(n, k));
        }
    }



}
