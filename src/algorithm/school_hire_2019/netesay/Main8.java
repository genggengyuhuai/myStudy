package algorithm.school_hire_2019.netesay;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 19校招 网易 15.3通过率 牛牛准备参加学校组织的春游, 出发前牛牛准备往背包里装入一些零食, 牛牛的背包容量为w。 牛牛家里一共有n袋零食, 第i袋零食体积为v[i]。
 * 牛牛想知道在总体积不超过背包容量的情况下,他一共有多少种零食放法(总体积为0也算一种放法)。
 * 
 * @author lihaoyu
 * @date 2019/9/9 20:00
 */
public class Main8 {
    private static long count = 0;

    private static long fun(List<Integer> list, int index, int totalWeight) {
        // 这个一定不能选
        if (totalWeight <= 0) {
            return 0;
        }
        if (index == list.size() - 1) {
            if (totalWeight >= list.get(index)) {
                return 2;
            }
            else {
                return 1;
            }
        }

        return fun(list, index + 1, totalWeight) + fun(list, index + 1, totalWeight - list.get(index));

    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int bagWeight = scanner.nextInt();
        List<Integer> list = new ArrayList<>();
        long tempCount = 0;
        for (int i = 0; i < n; i++) {
            list.add(scanner.nextInt());
            tempCount += list.get(i);
        }

        if(tempCount <= bagWeight){
            count = (long)Math.pow(2, n);
        }
        else{
            count = fun(list, 0, bagWeight);
        }
        System.out.println(count);
        count = 0;
    }
}
