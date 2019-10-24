package algorithm.jiu_shi_gan.meituan;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/10/21 17:57
 */
public class Main1 {

    // 求树的所有深度
    public static void fun(ArrayList<ArrayList<Integer>> list, ArrayList<Integer> res, int i,int count){
            if(list.get(i).size() == 0){
                res.add(count);
                return;
            }
            for(int k = 0; k < list.get(i).size(); k++){
                fun(list,res,list.get(i).get(k),count + 1);
            }
    }



    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int N = scanner.nextInt();
        ArrayList<ArrayList<Integer>> list = new ArrayList<>(N+1);
        for(int i = 0; i <= N; i++){
            list.add(new ArrayList<>());
        }
        for(int i = 0; i < N-1; i++){
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            list.get(x).add(y);
        }
        ArrayList<Integer> countList = new ArrayList<>();
        fun(list, countList, 1,0);
        int max = 0;
        int sum = 0;
        for (Integer integer : countList) {
            max = max > integer ? max : integer;
            sum += integer;
        }
        System.out.println(sum * 2 - max);




    }
}
