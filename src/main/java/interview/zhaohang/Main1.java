package interview.zhaohang;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2020/4/8 19:31
 */
public class Main1 {

    private static boolean fun(String str){
        int len = str.length();
        for(int i = 0; i < (len+1)/2; i++){
            if(str.charAt(i) == '1' && str.charAt(len-i-1) != '1') return false;
            if(str.charAt(i) == '2' && str.charAt(len-i-1) != '5') return false;
            if(str.charAt(i) == '3' && str.charAt(len-i-1) != '8') return false;
            if(str.charAt(i) == '4' && str.charAt(len-i-1) != '7') return false;
            if(str.charAt(i) == '5' && str.charAt(len-i-1) != '2') return false;
            if(str.charAt(i) == '6' && str.charAt(len-i-1) != '9') return false;
            if(str.charAt(i) == '7' && str.charAt(len-i-1) != '4') return false;
            if(str.charAt(i) == '8' && str.charAt(len-i-1) != '3') return false;
            if(str.charAt(i) == '9' && str.charAt(len-i-1) != '6') return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()){
            int t = scanner.nextInt();
            boolean[] res = new boolean[t];
            for (int i = 0; i < t; i++) {
                if(fun(scanner.next())) res[i] = true;
            }
            for (int i = 0; i < res.length; i++) {
                if(res[i]) System.out.println("YES");
                else System.out.println("NO");
            }
        }



    }
}
