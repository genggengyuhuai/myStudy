package algorithm.homework.fourthtime;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/19 13:01
 */
public class Main1 {

    static int N;
    static List<List<Integer>> res;
    static boolean[] visited;

    static void fun(int level, List<Integer> tempList){
        if(level == N){
            res.add(new ArrayList<>(tempList));
        }
        for(int i = N; i > 0; i--){
            if(!visited[i-1]){
                visited[i-1] = true;
                tempList.add(i);
                fun(level+1,tempList);
                visited[i-1] = false;
                tempList.remove(tempList.size() - 1);
            }
        }
    }


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            N = scanner.nextInt();
            res = new ArrayList<>();
            visited = new boolean[N];
            int[][] nums = new int[N][N];
            scanner.nextLine();
            String[] split = scanner.nextLine().split(",");
            for (String s : split) {
                String[] s1 = s.split(" ");
                nums[Integer.parseInt(s1[0])-1][Integer.parseInt(s1[1])-1] = Integer.parseInt(s1[2]);
            }
            fun(0,new ArrayList<>());
            int min = Integer.MAX_VALUE;

            for (List<Integer> re : res) {
                int sum = 0;
                for(int i = 0; i < N; i++){
                    sum += nums[re.get(i) - 1][i];
                }
                min = Math.min(min,sum);
            }
            List<List<Integer>> resList = new ArrayList<>();

            for (List<Integer> re : res) {
                int sum = 0;
                for(int i = 0; i < N; i++){
                    sum += nums[re.get(i) - 1][i];
                }
                if(sum == min){
                    resList.add(re);
                }
            }

            for (int i = 0; i < resList.size(); i++) {
                for (int j = 0; j < resList.get(i).size(); j++) {
                    if(j != resList.get(i).size() -1){
                        System.out.print(resList.get(i).get(j)+" ");
                    }else if(i != resList.size() - 1){
                        System.out.print(resList.get(i).get(j)+",");
                    }else{
                        System.out.print(resList.get(i).get(j));
                    }
                }
            }
            System.out.println();

        }
    }
}
