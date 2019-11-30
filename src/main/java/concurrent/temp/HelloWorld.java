package concurrent.temp;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author lihaoyu
 * @date 2019/11/9 11:34
 */
public class HelloWorld{
public static void main(String[] args) {
    List<String> list1 = new ArrayList<>();
    Object[] objects1 = list1.toArray();
    // 输出结果是 class [Ljava.lang.Object;
    System.out.println(objects1.getClass());

    List<String> list2 = Arrays.asList("");
    Object[] objects2 = list2.toArray();
    // 输出结果是  class [Ljava.lang.String;
    System.out.println(objects2.getClass());

    Object[] number = new Integer[3];

    // 抛出异常 Exception in thread "main" java.lang.ArrayStoreException: java.lang.Object
    objects2[0] = new Object();
}
}
