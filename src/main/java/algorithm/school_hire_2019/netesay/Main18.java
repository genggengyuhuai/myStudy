package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * 难度大
 * 小易的字典
 * 小易在学校中学习了关于字符串的理论, 于是他基于此完成了一个字典的项目。
 * 小易的这个字典很奇特, 字典内的每个单词都包含n个'a'和m个'z', 并且所有单词按照字典序排列。
 * 小易现在希望你能帮他找出第k个单词是什么。
 * @author lihaoyu
 * @date 2020/2/12 17:43
 */
public class Main18 {

    // 计算组合数 x 为底  x > y
    private static long fun(int x, int y,long k){
        long res = 1;
        for (int i = 1; i <= y; i++) {
            res *= x + 1 - i;
            res /= i;
            if(res > k) return k+1;
        }
        return res;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        long k = scanner.nextInt();
        long num = fun(n+m,n,k);
        if(k > num){
            System.out.println(-1);
            return;
        }
        StringBuilder res = new StringBuilder();
        while(m > 0 && n > 0){
            num = fun(m+n-1,n-1,k);
            if(k<=num){
                res.append("a");
                n--;
            }
            else{
                k -= num;
                res.append("z");
                m--;
            }
        }
        while(n-- > 0) res.append("a");
        while(m-- > 0) res.append("z");
        System.out.println(res);
    }

}
