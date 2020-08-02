package algorithm.contest.third;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/31 9:14
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int i = 0; i < T; i++) {
            String next = scanner.nextLine();
            String[] split = next.split(",");
            String source = split[0];
            String model = split[1];
            List<Integer> list = new ArrayList<>();
            int index = 0;
            while(index != -1){
                index = source.indexOf(model,index);
                if(index == -1){
                    break;
                }
                list.add(index);
                index++;
            }
            if(list.size() == 0) {
                System.out.println();
                continue;
            }
            for (int i1 = 0; i1 < list.size(); i1++) {
                if(i1 != list.size() - 1){
                    System.out.print(list.get(i1)+" ");
                }else{
                    System.out.println(list.get(i1));
                }
            }
        }
    }
}
