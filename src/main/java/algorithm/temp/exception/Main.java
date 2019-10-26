package algorithm.temp.exception;

import java.util.HashMap;
import java.util.Map;

/**
 * @author lihaoyu
 * @date 2019/9/19 17:08
 */
public class Main {




    public static void main(String[] args){
        Map<Integer,Integer> map = new HashMap<>();
        map.put(1,2);
        map.put(1,map.get(1)+1);
        System.out.println();
    }
}
