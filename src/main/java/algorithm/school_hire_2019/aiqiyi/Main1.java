package algorithm.school_hire_2019.aiqiyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 牛牛又从生物科研工作者那里获得一个任务,这次牛牛需要帮助科研工作者从DNA序列s中找出最短没有出现在DNA序列s中的DNA片段的长度。
 * 例如:s = AGGTCTA
 * 序列中包含了所有长度为1的('A','C','G','T')片段,但是长度为2的没有全部包含,例如序列中不包含"AA",所以输出2。
 * @author lihaoyu
 * @date 2/17/2020 6:45 PM
 */
public class Main1 {


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String next = scanner.next();
        char[] cs = new char[]{'A','G','C','T'};
        List<StringBuilder> list = new ArrayList<>();
        for (int i = 0; i < cs.length; i++) {
            list.add(new StringBuilder(""+cs[i]));
        }
        int res = 1;
        while(true){
            int len = list.size();
            for (int i = 0; i < len; i++) {
                if(!next.contains(list.get(i).toString())){
                        System.out.println(res);
                        return;
                }
            }
            res++;
            List<StringBuilder> temp = new ArrayList<>();
            for (int i = 0; i < cs.length; i++) {
                for (int j = 0; j < list.size(); j++) {
                    temp.add(new StringBuilder(list.get(j)).append(cs[i]));
                }
            }
            list = temp;
        }

    }
}
