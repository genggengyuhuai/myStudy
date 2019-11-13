package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 给出一个数字N，对于数字序列 1,2,3 ... N。现在在其中插入“+”, "-", " "，
 * 使得表达式的和为M。" "的含义是把相邻的两个数字组成一个数。例如：1 + 2 3 - 4，含义是：1 + 23 - 4 = 20。
 * 给出N和M，求出所有合法的序列的个数。
 * @author lihaoyu
 * @date 2019/11/13 12:27
 */
public class Main23 {

    private static boolean valid(String string,  int target){
        int res = 0;
        boolean plus = true;
        int i = 0, j, temp, len = string.length();
        while(i < len){
            if(string.charAt(i) == '+'){
                plus = true;
                i++;
                continue;
            }else  if(string.charAt(i) == '-'){
                plus = false;
                i++;
                continue;
            }
            j = i;
            while(j + 1 < len && !(string.charAt(j+1) == '+' || string.charAt(j+1) == '-')){
                j++;
            }
            temp = Integer.parseInt(string.substring(i,j+1));
            res += plus ? temp : -temp;
            i = j + 1;
        }
//        if(res == target) System.out.println(string);
        return res == target;
    }

    private static int count = 0;
    private static String src;
    private static int target;
    private static void fun(int i, String string){
        if(i == src.length() - 1){
            count += valid(string, target) ? 1 : 0;
            return;
        }
        fun(i + 1, string +  "+" +  src.charAt(i+1));
        fun(i + 1, string +  "-" +  src.charAt(i+1));
        fun(i + 1, string +  "" +  src.charAt(i+1));
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        StringBuilder sb = new StringBuilder();
        for(int i = 1; i <= N; i++){
            sb.append(i);
        }
        src = sb.toString();
        target = scanner.nextInt();
        fun(0,src.charAt(0)+"");
        System.out.println(count);
    }
}
