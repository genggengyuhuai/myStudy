package algorithm.jiu_shi_gan.netesay;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

/**
 * 19 网易 牛牛找工作
 * 时间复杂度 n * log(n) 通过2500ms 每个输入包含一个测试用例。 每个测试用例的第一行包含两个正整数，分别表示工作的数量N(N<=100000)和小伙伴的数量M(M<=100000)。
 * 接下来的N行每行包含两个正整数，分别表示该项工作的难度Di(Di<=1000000000)和报酬Pi(Pi<=1000000000)。 接下来的一行包含M个正整数，分别表示M个小伙伴的能力值Ai(Ai<=1000000000)。
 * 保证不存在两项工作的报酬相同。
 * 
 * @author lihaoyu
 * @date 2019/9/6 20:03
 */

public class Main1 {

    private static class Work implements Comparable<Work> {
        /***
         * 能力值
         */
        public int Di;
        /***
         * 报酬
         */
        public int Pi;

        public Work(int di, int pi) {
            Di = di;
            Pi = pi;
        }

        @Override
        public int compareTo(Work o) {
            return this.Pi - o.Pi;
        }
    }

    private static class Student {
        public int Di;

        public int index;

        public int salary;

        public Student(int di, int index, int salary) {
            this.Di = di;
            this.index = index;
            this.salary = salary;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (scanner.hasNext()) {
            int N = scanner.nextInt();
            int M = scanner.nextInt();
            List<Work> workList = new ArrayList<>();
            List<Student> studentList = new ArrayList<>();
            for (int i = 0; i < N; i++) {
                workList.add(new Work(scanner.nextInt(), scanner.nextInt()));
            }
            Collections.sort(workList);
            for (int i = 0; i < M; i++) {
                studentList.add(new Student(scanner.nextInt(), i, 0));
            }
            Collections.sort(studentList, (o1, o2) -> o2.Di - o1.Di);
            int lastIndex = N - 1;
            for (int m = 0; m < M; m++) {
                for (int n = lastIndex; n >= 0; n--) {
                    if (studentList.get(m).Di >= workList.get(n).Di) {
                        studentList.get(m).salary = workList.get(n).Pi;
                        lastIndex = n;
                        break;
                    }
                    if (n == 0) {
                        lastIndex = 0;
                    }
                }
            }
            Collections.sort(studentList, (Comparator.comparingInt(o -> o.index)));
            for (int i = 0; i < M; i++) {
                System.out.println(studentList.get(i).salary);
            }

        }

    }
}
