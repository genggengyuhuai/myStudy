package algorithm.school_hire_2019.xiaomi;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * @author lihaoyu
 * @date 2019/11/13 16:16
 */
public class Main27 {

    static boolean flag;
    static int target = 24;
    private static void fun(int i, int[] nums, int sum){
        if(flag){
            return;
        }
        if(i == 4){
            if(sum == target){
                flag = true;
            }
            return;
        }



    }

    public static void main(String[] args) throws ScriptException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine js = manager.getEngineByName("nashorn");
        String string = "1+2+5/3";
        Double eval = (Double) js.eval(string);
        System.out.println(eval);
        System.out.format("%.2f", eval);
    }
}
