package algorithm.homework.fourthtime;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

/**
 * @author lihaoyu
 * @date 2019/11/19 9:32
 */
public class Main5 {

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
            depth = 0;
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
            dfs(graph,visited,startIndex,0);
            System.out.println(depth);
        }
    }

    static int depth = 0;
    private static void dfs(int[][] graph, boolean[] visited, int i, int tempDepth){
        if(visited[i]){
            return;
        }
        visited[i] = true;
        tempDepth++;
        depth = Math.max(depth, tempDepth);
        for(int j = 0; j < visited.length; j++){
            if(graph[i][j] == 1 && !visited[j]){
                dfs(graph,visited,j,tempDepth);
            }
        }
        visited[i] = false;
    }


}
