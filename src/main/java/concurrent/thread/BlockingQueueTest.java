package concurrent.thread;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.logging.Logger;

/**
 * @author lihaoyu
 * @date 2019/12/2 16:10
 */

public class BlockingQueueTest {

    private static ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5,false);

    public static void main(String[] args) {
        Configuration conf = new Configuration();
        try{
            FileSystem fs = FileSystem.get(conf);
            Path dest = new Path("/lihaoyu");
            fs.mkdirs(dest);
        }catch (Exception e){
        e.printStackTrace();
        }
    }
}
