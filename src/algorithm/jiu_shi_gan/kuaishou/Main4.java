package algorithm.jiu_shi_gan.kuaishou;

import java.util.Scanner;

/**
 * 爬梯子动归   对 1e9+3取模
 *
 * 前几个月放映的头号玩家简直火得不能再火了，作为一个探索终极AI的研究人员，月神自然去看了此神剧。
 * 由于太过兴奋，晚上月神做了一个奇怪的梦，月神梦见自己掉入了一个被施放了魔法的深渊，月神想要爬上此深渊。
 *
 * 已知深渊有N层台阶构成（1 <= N <= 1000)，并且每次月神仅可往上爬2的整数次幂个台阶(1、2、4、....)，请你编程告诉月神，月神有多少种方法爬出深渊
 *
 * @author lihaoyu
 * @date 2019/10/20 22:55
 */
public class Main4 {

    public static void main(String[] args) {
        int n = 1000;
        long[] res = new long[n+1];
        res[0] = 1;
        for(int i = 1; i < n+1; i++){
            for(int j = 1; (i - j ) >= 0; j = (j << 1)){
                res[i] += res[i - j];
            }
            res[i] = res[i] % 1000000003;
        }

        Scanner scanner = new Scanner(System.in);
        int t = scanner.nextInt();
        for(int i = 0; i < t; i++){
            System.out.println(res[scanner.nextInt()]);
        }


    }
}
