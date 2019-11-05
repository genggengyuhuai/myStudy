package algorithm.temp;

import java.util.LinkedHashMap;

class Main1 {
    public static void main(String[] args) {
        LinkedHashMap<Integer,Integer> map = new LinkedHashMap<>(16,0.75f,false);
        for (int i = 0; i < 5; i++) {
            map.put(i,i);
        }
        map.put(2,2);
        map.get(1);
        System.out.println(map);
    }
}
