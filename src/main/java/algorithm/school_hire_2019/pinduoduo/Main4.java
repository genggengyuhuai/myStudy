package algorithm.school_hire_2019.pinduoduo;

import java.util.Scanner;

/**
 * 回合制游戏
 * @author lihaoyu
 * @date 2019/12/12 15:01
 */
public class Main4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int HP = scanner.nextInt();
        int normal = scanner.nextInt();
        int buffer = scanner.nextInt();
        if(buffer <= 2*normal){
            if(HP % normal == 0) System.out.println(HP / normal);
            else System.out.println(HP / normal + 1);
            return;
        }
        if(HP % buffer == 0){
            System.out.println(HP / buffer * 2);
        }
        else if(HP % buffer <= normal){
            System.out.println(HP / buffer * 2 + 1);
        }else{
            System.out.println(HP / buffer * 2 + 2);
        }
    }
}
