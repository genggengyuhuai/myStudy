package algorithm.school_hire_2019.xiaomi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 设计一个函数， 可以将任意十进制的数， 转换成任意2到9的进制表示的形式
 * @author lihaoyu
 * @date 2019/11/5 18:18
 */
public class Main1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long x = scanner.nextLong();
        long k = scanner.nextLong();
        List<Long> list = new ArrayList<>();
        while(x >= k ){
            list.add(x % k);
            x = x / k;
        }
        list.add(x);
        for(int i = list.size() - 1; i >= 0; i--){
            System.out.print(list.get(i));
        }

    }
}
