package algorithm.homework.fourthtime;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/19 9:32
 */
public class Main6 {

    private static int findIndex(String[] strings, String s){
        for (int i = 0; i < strings.length; i++) {
            if(s.equals(strings[i])){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            int N = scanner.nextInt();// 节点数目
            String start = scanner.next(); // 开始节点
            scanner.nextLine();
            String[] nodes = scanner.nextLine().split(" ");
            int startIndex = findIndex(nodes, start);
            int[][] graph = new int[N][N];
            boolean[] visited = new boolean[N];
            for(int i = 0; i < N; i++){
                String next = scanner.next();
                for(int j = 0; j < N; j++){
                    graph[i][j] = scanner.nextInt();
                }
            }
            LinkedList<Integer> list = new LinkedList<>();
            List<String> res = new ArrayList<>();
            res.add(nodes[startIndex]);
            list.addLast(startIndex);
            visited[startIndex] = true;
            while(!list.isEmpty()){
                Integer integer = list.pollFirst();
                for(int i = 0; i < N; i++){
                    if(graph[integer][i] == 1 && !visited[i]){
                        res.add(nodes[i]);
                        list.addLast(i);
                        visited[i] = true;
                    }
                }
            }

            for (int i = 0; i < res.size(); i++) {
                if(i != res.size() - 1){
                    System.out.print(res.get(i)+" ");
                }else{
                    System.out.print(res.get(i));
                }
            }
        }
    }
}
