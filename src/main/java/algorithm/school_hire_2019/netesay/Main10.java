package algorithm.school_hire_2019.netesay;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * 网易校招
 * 题目描述
 * 小易觉得高数课太无聊了，决定睡觉。不过他对课上的一些内容挺感兴趣，所以希望你在老师讲到有趣的部分的时候叫醒他一下。你知道了小易对一堂课每分钟知识点的感兴趣程度，并以分数量化，以及他在这堂课上每分钟是否会睡着，你可以叫醒他一次，这会使得他在接下来的k分钟内保持清醒。你需要选择一种方案最大化小易这堂课听到的知识点分值。
 * 输入描述:
 * 第一行 n, k (1 <= n, k <= 105) ，表示这堂课持续多少分钟，以及叫醒小易一次使他能够保持清醒的时间。
 * 第二行 n 个数，a1, a2, ... , an(1 <= ai <= 104) 表示小易对每分钟知识点的感兴趣评分。
 * 第三行 n 个数，t1, t2, ... , tn 表示每分钟小易是否清醒, 1表示清醒。
 * @author lihaoyu
 * @date 2019/9/13 23:34
 */
public class Main10 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            int n = scanner.nextInt();
            int time = scanner.nextInt();
            int[] score = new int[n];
            for(int i = 0; i < n; i++){
                score[i] = scanner.nextInt();
            }
            int[] awake = new int[n];
            for(int i = 0; i < n; i++){
                awake[i] = scanner.nextInt();
            }
            int res = 0;
            // 置 0
            for(int i = 0; i < n; i++){
                if(awake[i] == 1){
                    res += score[i];
                    score[i] = 0;
                    awake[i] = 0;
                }
            }
            // 题目用例最后一个K为0，他妈的！题目明明是大于1的，日了狗了找了半天的越界
            if(time == 0){
                System.out.println(res);
                continue;
            }
            LinkedList<Integer> list = new LinkedList<>();
            int count = 0;
            for(int i = 0; i < time && i < n; i++){
                list.addLast(score[i]);
                count += score[i];
            }

            int temp_count = count;
            // 开始循环
            for(int i = time; i < n; i++){
                int out = list.pollFirst();
                list.addLast(score[i]);
                temp_count = temp_count - out + score[i];
                count = temp_count > count ? temp_count : count;
            }
            System.out.println(count + res);

        }

    }
}
