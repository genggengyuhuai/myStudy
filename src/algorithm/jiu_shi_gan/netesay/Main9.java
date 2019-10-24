package algorithm.jiu_shi_gan.netesay;

import java.util.Scanner;

/**
 * 19网易校招     俄罗斯方块  30通过率
 * @author lihaoyu
 * @date 2019/9/9 19:41
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            int[] res = new int[n];
            for(int i = 0; i < m; i++){
                res[scanner.nextInt()-1]++;
            }
            int min = res[0];
            for(int i = 0; i < n; i++){
               min = res[i] < min ? res[i] : min;
            }
            System.out.println(min);
        }

    }
}
