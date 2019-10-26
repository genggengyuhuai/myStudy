package algorithm.school_hire_2019.netesay;

import java.util.Scanner;

/**
 * 19校招 网易 迷路的牛牛
 * 牛牛去犇犇老师家补课，出门的时候面向北方，但是现在他迷路了。虽然他手里有一张地图，但是他需要知道自己面向哪个方向，请你帮帮他。
 * 输入描述:
 * 每个输入包含一个测试用例。
 * 每个测试用例的第一行包含一个正整数，表示转方向的次数N(N<=1000)。
 * 接下来的一行包含一个长度为N的字符串，由L和R组成，L表示向左转，R表示向右转。
 * 输出描述:
 * 输出牛牛最后面向的方向，N表示北，S表示南，E表示东，W表示西。
 *  @author lihaoyu
 * @date 2019/9/7 9:59
 */
public class Main4 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            scanner.nextInt();
            String next = scanner.next();
            int res = 0;
            for(int i = 0; i < next.length(); i++){
                if(next.charAt(i) == 'L') {
                    res++;
                    continue;
                }
                res--;
            }
            if(res >= 0 && res % 4 == 0 || res < 0 && Math.abs(res) % 4 == 0){
                System.out.println("N");
            }
            else if(res >= 0 && res % 4 == 1 || res < 0 && Math.abs(res) % 4 == 3){
                System.out.println("W");
            }
            else if(res >= 0 && res % 4 == 2 || res < 0 && Math.abs(res) % 4 == 2){
                System.out.println("S");
            }
            else if(res >= 0 && res % 4 == 3 || res < 0 && Math.abs(res) % 4 == 1){
                System.out.println("E");
            }
        }
    }
}
