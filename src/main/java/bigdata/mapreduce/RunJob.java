package bigdata.mapreduce;


import java.io.IOException;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

import com.sun.jersey.core.impl.provider.entity.XMLJAXBElementProvider.Text;


/**
 * @author lihaoyu
 * @date 2019/12/2 16:10
 */
public class RunJob {
	public static void main (String []args){		
		Configuration conf=new Configuration();
		//namenode入口ip
		conf.set("fs.defaultFS", "hdfs://localhost:9000");
	    Job job =null;	    
			try {
				//任务名字
				job = Job.getInstance(conf, "mywc");				
			} catch (IOException e1) {				
				e1.printStackTrace();
			}		    		
    //主方法
		    job.setJarByClass(RunJob.class);
		    		    //map方法名
		    job.setMapperClass(WordCountMapper.class); 
		    //reducer方法名
		    job.setReducerClass(WordCountReducer.class);
		    		    //map输出的key类型
		    job.setOutputKeyClass(Text.class);
		    		    //map输出的value类型
		    job.setOutputValueClass(IntWritable.class); 
		    try {
		    	//读取的文件位置
	FileInputFormat.addInputPath(job, new Path("/myC"));
				//处理完之后数据存放位置，注意输出的文件夹如果已经存在会报错
	 FileOutputFormat.setOutputPath(job, new Path("/hh"));
			    boolean f = job.waitForCompletion(true);
		    } catch (Exception e) {
				e.printStackTrace();
			} 			
	}
}


