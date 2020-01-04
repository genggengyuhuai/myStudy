package algorithm.school_hire_2019.jingdong;

import java.util.Scanner;

/**
 * 小M要制作一种黑暗饮料，这种饮料的原料有n种，编号为1-n，已知小M的容器最多容纳V升材料，
 * 黑暗料理的各种原料配比为 a1 : a2 : a3 : ... : an, 每种原料分别
 * 有b1，b2，... bn升。  问小M最多可以制作多少升这种饮料。小M使用的各种原料体积和不能超过V。
 * @author lihaoyu
 * @date 2020/1/3 10:38
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        int V = scanner.nextInt();
        int[] a = new int[N];
        int[] b = new int[N];
        int countA = 0;
        for (int i = 0; i < N; i++) {
            a[i] = scanner.nextInt();
            countA += a[i];
        }
        double max = 11111111;
        for (int i = 0; i < N; i++) {
            b[i] = scanner.nextInt();
            max = Math.min(max,(b[i]+0.0)/a[i]);
        }
        System.out.format("%.4f",Math.min(max*countA,V+0.0));
    }
}
