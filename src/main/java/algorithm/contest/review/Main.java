package algorithm.contest.review;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] unit = {"1","2","3","4","5","$","5","4","3","2","1"};
        Scanner sc = new Scanner(System.in);
        long beginLen = 0,beginDollarLen = 0;
        long caseNum = sc.nextInt();
        while (caseNum-- > 0) {
            long query = sc.nextLong();
            beginLen = 11;
            beginDollarLen = 2;
            while(beginLen < query) {
                beginLen = 2*beginLen+beginDollarLen;
                ++beginDollarLen;
            }
            --beginDollarLen;
            while(query>11) {
                if(query<(beginLen-beginDollarLen)/2) {
                    query = 6;
                }
                else {
                    query = beginLen - query + 1;
                    beginLen = (beginLen - beginDollarLen)/2;
                    --beginDollarLen;
                }
            }
            System.out.printf("%s\n", unit[(int) (query-1)]);
        }

    }

}