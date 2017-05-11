
import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

public class MarketReducer extends Reducer<Text, IntWritable, Text, IntWritable> {
	// key is in form of Tuple2(Si, Sj)
	// value = List<integer>, where each element is an integer number
	//public void reduce(Tuple2(Si, Sj) key, List<integer> values)
	public void reduce(Text key,Iterable< IntWritable> values,Context context) throws IOException, InterruptedException
	{
	   int sum = 0;
	
	
	 for (IntWritable i : values) {
     sum += i.get();
	}
	
	 context.write(key, new IntWritable(sum));

}
}
