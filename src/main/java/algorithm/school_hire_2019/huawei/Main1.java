package algorithm.school_hire_2019.huawei;

import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2/4/2020 10:27 AM
 */
public class Main1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            char[] chars = scanner.next().toCharArray();
            int count = 0;
            for (char aChar : chars) {
                count += (aChar == 'U' ? -1 : 1);
            }
            int pageStart = 1;
            int res = 1;
            if (count >= 0) {
                count = count % n;
                res += count;
                if (count > 3) pageStart += (count - 3);
            }
            else{
                count = (-count) % n;
                if(count != 0){
                    res = n + 1 - count;
                    if (count > 4) pageStart = (n - count + 1);
                    else pageStart = n - 3;
                }
            }

            for (int i = 0; i < 4; i++) {
                if(i != 3)
                    System.out.print(pageStart+i+" ");
                else System.out.print(pageStart+i);
            }
            System.out.println();
            System.out.println(res);
        }

    }

}
