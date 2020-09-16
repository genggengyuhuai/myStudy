package interview.huawei;

import java.util.HashSet;
import java.util.Set;

/**
 * @author lihaoyu
 * @date 2020/9/16 2:13 下午
 */
public class Main11 {

    private static Set<String> quhaoSet;

    static {
        quhaoSet = new HashSet<>(128);
        // 读取配置文件加载区号...
    }

    private static boolean validate(String telephone){
        if(telephone == null || telephone.length() == 0) return false;
        try{
            // 手机号解析为 Long，出错不合法
            long l = Long.parseLong(telephone);
        }catch (Exception e){
            return false;
        }
        return true;
    }

    private static String fun(String telephone) throws Exception {
        if (!validate(telephone)){
           throw new Exception("不合法");
        }
        String tempRes = "";
        for (int i = 0; i <= 5; i++) {
            if(quhaoSet.contains(telephone.substring(0,i+1)) && tempRes.length() <= i){
                tempRes = telephone.substring(0,i+1);
            }
        }
        return tempRes;
    }


    public static void main(String[] args) {

    }
}
