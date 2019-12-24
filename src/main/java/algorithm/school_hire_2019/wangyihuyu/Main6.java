package algorithm.school_hire_2019.wangyihuyu;

import java.util.Scanner;

/**
 * 时钟
 * 小W有一个电子时钟用于显示时间，显示的格式为HH:MM:SS，HH，MM，SS分别表示时，分，秒。
 * 其中时的范围为[‘00’,‘01’…‘23’]，分的范围为[‘00’,‘01’…‘59’]，秒的范围为[‘00’,‘01’…‘59’]。
 * @author lihaoyu
 * @date 2019/12/24 11:52
 */
public class Main6 {



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        for (int i = 0; i < N; i++) {
            System.out.println(fun(scanner.next()));
        }
    }

    private static String fun(String next) {
        String[] split = next.split(":");
        StringBuilder res = new StringBuilder();
        if(split[0].compareTo("24") >= 0){
            res.append(0);
            res.append(split[0].charAt(1));
        }else{
            res.append(split[0]);
        }
        res.append(":");
        for (int i = 1; i <= 2; i++) {
            if(split[i].compareTo("60") >= 0){
                res.append(0);
                res.append(split[i].charAt(1));
            }else{
                res.append(split[i]);
            }
           if(i == 1) res.append(":");
        }
        return res.toString();
    }
}
