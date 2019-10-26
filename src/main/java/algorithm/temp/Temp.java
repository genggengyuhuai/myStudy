package algorithm.temp;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/22 16:08
 */
public class Temp {

    public static int fun(String s, int index1, int index2){
        int count = 0;
        int j = 0;
        while (index1 - j >= 0 && index2 + j < s.length()
            && s.charAt(index1 - j) == s.charAt(index2 + j)){
            count++;
            j++;
        }
        return count;
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String string = scanner.next();
        int count = 0;
        for(int i = 0; i < string.length() ;i++){
            count += (fun(string, i,i) + fun(string, i,i+1));
        }
        System.out.println(count);
    }
}
