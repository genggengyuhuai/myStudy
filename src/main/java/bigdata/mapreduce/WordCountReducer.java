package bigdata.mapreduce;

import java.io.IOException;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
//mapper切分后是a 1 b 1 a 1 c 1 的形式，输出a 2 b 1 c 1形式
public class WordCountReducer extends Reducer<Text,IntWritable,Text, IntWritable>{
	//数据分组合并输出
	@Override
	protected void reduce (Text arg0,Iterable<IntWritable> arg1,Context arg2)
			throws IOException,InterruptedException{
		int sum=0;
		for(IntWritable i:arg1){
			sum=sum+i.get();
		}
		System.out.println("----------------------------"+sum+"---------------------");
		arg2.write(arg0, new IntWritable(sum));
	}
}
