package algorithm.school_hire_2019.xiaohongshu;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2/5/2020 10:18 PM
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int m = scanner.nextInt();
        int[] a = new int[m];
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            a[i] = scanner.nextInt();
            b[i] = scanner.nextInt();
        }
        Set<Integer> aSet = new HashSet<>();
        Set<Integer> bSet = new HashSet<>();
        for (int i = 0; i < m; i++) {
            aSet.add(a[i]);
            bSet.add(b[i]);
            // 对于 a[i] 进行查找


            aSet.clear();
            bSet.clear();

        }

    }

}
