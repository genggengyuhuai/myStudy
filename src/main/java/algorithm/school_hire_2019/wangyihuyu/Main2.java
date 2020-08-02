package algorithm.school_hire_2019.wangyihuyu;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Scanner;

/**
 * 小云正在参与开发一个即时聊天工具，他负责其中的会话列表部分。
 *
 * 会话列表为显示为一个从上到下的多行控件，其中每一行表示一个会话，每一个会话都可以以一个唯一正整数id表示。
 *
 * 当用户在一个会话中发送或接收信息时，如果该会话已经在会话列表中，则会从原来的位置移到列表的最上方；如果没有在会话列表中，则在会话列表最上方插入该会话。
 *
 * 小云在现在要做的工作是测试，他会先把会话列表清空等待接收信息。当接收完大量来自不同会话的信息后，就输出当前的会话列表，以检查其中是否有bug。
 * @author lihaoyu
 * @date 2019/11/5 15:46
 */
public class Main2 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int T = scanner.nextInt();
        for (int t = 0; t < T; t++) {
            LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(16,0.75f,true);
            int N = scanner.nextInt();
            for(int i = 0; i < N; i++){
                map.put(scanner.nextInt(),null);
            }
            List<Integer> list = new ArrayList<>();
            map.forEach((a,b)-> list.add(a));
            for(int i = list.size() - 1; i >= 0; i--){
                if(i != 0){
                    System.out.print(list.get(i)+" ");
                }else{
                    System.out.println(list.get(i));
                }
            }
        }
    }
}
