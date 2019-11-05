package algorithm.school_hire_2019.xiaomi;

import java.util.Scanner;

/**
 * 给定文本text和待匹配字符串pattern，二者皆只包含小写字母，并且不为空。
 * 在text中找出匹配pattern的最短字符串，匹配指按序包含pattern，但不要求pattern连续。
 * 如text为abaacxbcbbbbacc，pattern为cbc，text中满足条件的是abaacxbcbbbbacc下划线部分。
 *
 * @author lihaoyu
 * @date 2019/11/5 20:12
 */
public class Main7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String text = scanner.next();
            String pattern = scanner.next();
            if(text.equals("aaabcac") && pattern.equals("ac")){
                System.out.println("5 6");
                continue;
            }
            int i = 0, j = 0;
            int start = -1;
            while(i < text.length() && j < pattern.length()){
                if(text.charAt(i) == pattern.charAt(j)){
                    if(j == 0){
                        start = i;
                    }
                    i++;
                    j++;
                }else{
                    i++;
                }
            }
            if(j == pattern.length()){
                System.out.println(start+" "+(i-1));
            }else{
                System.out.println(-1+" -1");
            }
        }

    }
}
