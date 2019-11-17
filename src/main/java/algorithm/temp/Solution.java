package algorithm.temp;


import java.math.BigInteger;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */



public class Solution {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        BigInteger[] res = new BigInteger[num+1];
       res[0] =  new BigInteger("1");
        res[1] = new BigInteger("1");
        res[2] = new BigInteger("1");
        for(int i = 3; i < num+1; i++){
            res[i] = res[i - 1].add(res[i - 3]);
        }
        System.out.println(res[num]);
    }

}