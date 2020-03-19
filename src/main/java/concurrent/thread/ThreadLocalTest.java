package concurrent.thread;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author lihaoyu
 * @date 2019/11/10 14:30
 */
public class ThreadLocalTest    {
    private static ThreadLocal<SimpleDateFormat> threadLocal = new ThreadLocal<>();

    public static class ParseDate implements Runnable{
        int anInt = 0;

        public ParseDate(int anInt) {
            this.anInt = anInt;
        }

        @Override
        public void run() {
            try{
                if(threadLocal.get() == null){
                    threadLocal.set(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
                    System.out.println("新建了");
                }
                Date date = threadLocal.get().parse("2019-10-10 10:21:"+anInt%60);
                System.out.println(anInt+" : "+date);
            }catch (ParseException e){
                e.printStackTrace();
            }
        }
    }


    public static void main(String[] args) {
        // thread 和 线程池 一起使用，要根据业务判断每个job执行后是否需要
        // 清除  Thread.currentThread().threadLocals = null;
        ExecutorService executorService = Executors.newFixedThreadPool(5);
        for (int i = 0; i < 10; i++) {
            executorService.execute(new ParseDate(i));
        }
    }
}
