package algorithm.school_hire_2019.xiaomi;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

/**
 * 小米	ipv4地址白名单
 * @author lihaoyu
 * @date 2019/11/5 21:53
 */
public class Main9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next;
        Set<String> set = new HashSet<>();
        while(!(next = scanner.next()).equals("end")){
            String[] split = next.split(":");
            if(split[0].equals("i")){
                set.add(split[1]);
                System.out.println("ok");
            }else if(split[0].equals("d")){
                set.remove(split[1]);
                System.out.println("ok");
            }else if(split[0].equals("s")){
                System.out.println(set.contains(split[1]));
            }
        }
    }
}
