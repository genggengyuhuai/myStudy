package bigdata.mapreduce;


import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class WordCountMapper extends Mapper<LongWritable, Text, Text,IntWritable >{
	@Override
	protected void map(LongWritable key,Text value,Context context)
		throws IOException,InterruptedException{
		//用空格进行分词
		 String [] str=value.toString().split(" "); 
		 //for循环输出 
		 for(int i=0;i<str.length;i++){
			 //new Tex，new IntWritable进行可序列化
			 context.write(new Text(str[i]), new IntWritable(1)); 
		 } 
	}
}
