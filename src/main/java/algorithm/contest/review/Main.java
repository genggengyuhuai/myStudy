package algorithm.contest.review;

import java.util.Scanner;

/**
 *   硬币最小数量 http://172.19.241.251/problem/Gre-4
 *
 * @author Lihaoyu
 * @date 2019/12/1 21:35
 */
public class Main {
    public static void main(String[] args) { // TODO Auto-generated method stub
        String[] unit = {"1", "2", "3", "4", "5", "$", "5", "4", "3", "2", "1"};
        Scanner sc = new Scanner(System.in);
        long beginLen = 0, beginDollarLen = 0;
        int caseNum = sc.nextInt();
        while (caseNum-- > 0) {
            long query = sc.nextLong();
            beginLen = 11;
            beginDollarLen = 1;
            while (beginLen < query) {
                beginLen = ((2 * beginLen) + ++beginDollarLen);
            }
            while (query > 11) {
                if (query <= (beginLen - beginDollarLen) / 2) {
                    beginLen = (beginLen - beginDollarLen--) / 2;
                } else if (query <= (beginLen + beginDollarLen) / 2) {
                    query = 6;
                } else {
                    query = beginLen - query + 1;
                    beginLen = (beginLen - beginDollarLen--) / 2;
                }
            }
            System.out.printf("%s\n", unit[(int) (query - 1)]);
        }
    }
}