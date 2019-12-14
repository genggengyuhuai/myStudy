package algorithm.school_hire_2019.xiaomi;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    private static class Point implements Comparable<Point>{
        int start;
        int end;

        public Point(int start, int end) {
            this.start = start;
            this.end = end;
        }

        @Override
        public int compareTo(Point o) {
            if((end - start) != (o.end - o.start)){
              return  (end - start) - (o.end - o.start);
            }
            return start - o.start;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            String text = scanner.next();
            String pattern = scanner.next();
            int i = 0, j = 0, k = 0;
            int start = -1, end = -1;
            List<Point> res = new ArrayList<>();
            while(k < text.length()){
                start = -1;
                end = -1;
                i = k;
                j = 0;
                while(i < text.length() && j < pattern.length()){
                    if(text.charAt(i) == pattern.charAt(j)){
                        if(j == 0){
                            start = i;
                        }
                        if(j == pattern.length() - 1){
                            end = i;
                            break;
                        }
                        i++;
                        j++;
                    }else{
                        i++;
                    }
                }
                if(end != -1){
                    res.add(new Point(start,end));
                }
                k++;
                while(k < text.length() && text.charAt(k) != pattern.charAt(0)){
                    k++;
                }
            }
            if(res.isEmpty()){
                System.out.println("-1 -1");
            }
            else{
                Collections.sort(res);
                System.out.println(res.get(0).start+" " +res.get(0).end);
            }
        }

    }
}
