package algorithm.homework.fourthtime;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2019/11/23 19:12
 */
public class Main7 {

    private static final int N = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        scanner.nextLine();
        for (int t = 0; t < T; t++) {
            Map<String,ArrayList<String>> map = new HashMap<>();
            Map<String,Integer> indexMap = new HashMap<>();
            String[] split = scanner.nextLine().split(",");
            boolean[][] matrix;
            List<String> startList = new ArrayList<>();
            List<String> endList = new ArrayList<>();
            for (String s : split) {
                String[] s1 = s.split(" ");
                if(!indexMap.containsKey(s1[0])){
                    indexMap.put(s1[0],indexMap.size());
                }
                startList.add(s1[0]);
                if(!indexMap.containsKey(s1[1])){
                    indexMap.put(s1[1],indexMap.size());
                }
                endList.add(s1[1]);
            }
            int capacity = indexMap.size();
            matrix = new boolean[capacity][capacity];
            for (int i = 0; i < startList.size(); i++) {
                matrix[indexMap.get(startList.get(i))][indexMap.get(endList.get(i))] = true;
            }


            Set<Integer> set = new HashSet<>();
            int res = 1;
            while (set.size() != capacity){
            int tempCount = 0;
            boolean flag;
            for(int j = 0; j < capacity; j++){
                if(set.contains(j)){
                    continue;
                }
                flag = false;
                for(int i = 0; i < capacity; i++){
                    if(matrix[i][j]){
                        flag = true;
                        break;
                    }
                }
                if(!flag){
                    tempCount++;
                    set.add(j);
                }
            }
            res *= tempCount;
            for (Integer j : set) {
                for(int k = 0; k < capacity; k++){
                    matrix[j][k] = false;
                }
            }
            }
            System.out.println(res);
        }
    }
}
