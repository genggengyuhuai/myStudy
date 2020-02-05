package algorithm.school_hire_2019.duxiaoman;

import java.util.Scanner;

/**
 * 取模很烦
 * 给定一个仅由小写字母x和y组成且长度不超过105的字符串，
 * 每次可以将字符串中的一个子串xy替换成字符串yyx，那么至少要替换多少次才能让字符串中不存在子串xy？
 * @author lihaoyu
 * @date 2/5/2020 4:11 PM
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        int countX = 0;
        long res = 0;
        int index = 0;
        // 先把y走完
        while(index < next.length() && next.charAt(index) == 'y'){
            index++;
        }
        while(index < next.length() && next.charAt(index) == 'x'){
            index++;
            countX++;
        }
        if(index == next.length()){
            System.out.println(0);
            return;
        }
        //
        while(index < next.length()){
            if(next.charAt(index) == 'y'){
                res += (Math.pow(2,countX)  % 1000000007 - 1);
                res = res % 1000000007;
            }
            else{
                countX++;
            }
            index++;
        }
        System.out.println(res);

    }
}
