package interview.huawei;


import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 35分钟做完，签到题， map和 set 没有 get(obj) 返回 obj 的方式
 * @author lihaoyu
 * @date 2020/4/15 18:53
 */
public class Main1 {

    private static class Person implements Comparable<Person>{
        String name;
        int count;

        public Person(String name, int count) {
            this.name = name;
            this.count = count;
        }
        @Override
        public int compareTo(Person o) {
            if(this.count != o.count) return this.count - o.count;
            for(int i = 0; i < Math.min(this.name.length(), o.name.length()); i++){
                if(name.charAt(i) > o.name.charAt(i)){
                    return -1;
                }
                if(name.charAt(i) < o.name.charAt(i)){
                    return 1;
                }
                // 如果等于则继续
            }
            return -this.name.length() + o.name.length();
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", count=" + count +
                    '}';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String src = scanner.next();
        for (int i = 0; i < src.length(); i++) {
            char c = src.charAt(i);
            if (c == ',' || c >= 'a' && c <= 'z' || c >= 'A' && c <= 'Z') {
            } else {
                System.out.println("error.0001");
                return;
            }
        }
        String[] split = src.split(",");
        for (String s : split) {
            for (int i = 0; i < s.length(); i++) {
                char c = s.charAt(i);
                if (i == 0 && !(c >= 'A' && c <= 'Z')  || i != 0 && !(c >= 'a' && c <= 'z')){
                    System.out.println("error.0001");
                    return;
                }
            }
        }
        Map<String, Person> map = new HashMap<>(16);
        for(String str : split){
            Person person = new Person(str,1);
            if(map.containsKey(str)){
                map.get(str).count++;
            }else{
                 map.put(str,person);
            }
        }
        List<Person> list = new ArrayList<>();
        map.forEach((k,v) -> list.add(v));
        Collections.sort(list);
        System.out.println(list.get(list.size()-1).name);
    }
}














