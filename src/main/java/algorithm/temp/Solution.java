package algorithm.temp;


import jdk.nashorn.internal.runtime.arrays.IteratorAction;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/9/29 11:05
 */

class Temp{
    public int sum = 1;
    public Temp() {
        System.out.println("Temp类构造函数");
    }
}

class Lihaoyu{
    public static final double count = 0;

    public static final Temp temp = new Temp();
    static {
        System.out.println("静态的");
    }
}


public class Solution {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(10);
        list.add(13);
        list.add(15);
        for (Iterator<Integer> iterator = list.iterator(); iterator.hasNext(); ) {
            Integer next = iterator.next();
            if(next == 13){
                iterator.remove();
            }
        }
        System.out.println(list);
        Scanner scanner = new Scanner(System.in);
        System.out.println(Lihaoyu.count);
//        System.out.println(Lihaoyu.temp);
//        Lihaoyu.temp.sum++;
//        System.out.println(Lihaoyu.temp.sum);
    }

}