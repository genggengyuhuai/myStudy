package interview.tecent;

/**
 * 实现一个微信红包分配算法，输入红包总额和个数后，输出每个红包的数额
 * @author lihaoyu
 * @date 3/13/2020 8:38 PM
 */
import java.util.Random;
public class Main2 {
    // 按分计算
    private static int total = 19500;
    // 人数
    private static int count;
    private static Random random = new Random();

    private static void fun(){
        if(count * 200 * 100 < total){
            System.out.println("红包总额过大");
        }
        for(int i = 0; i < count; i++){
            int money;
            if(i == count - 1){
                System.out.println(total);
                break;
            }
            // 保证之后的人每个至少能分到 1 分钱
            while(true){
                money = random.nextInt() % (Math.min(total, 20000));
                // 过大或过小都重新取
                // 过大： 超过200或者 剩下的人取不到 1分
                if(money > 200 * 100 || (total - money) < count - i){
                    continue;
                }
                // 过小：剩下的人都取200也取不完
                if(total - money > (count - i) * 200 * 100){
                    continue;
                }
                break;
            }
            total -= money;
            System.out.println("分到 " + money);
        }
    }


    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        //int a = in.nextInt();
        //System.out.println(a);
        System.out.println("Hello World!");
    }
}
