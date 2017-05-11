import org.apache.hadoop.conf.Configured;
import org.apache.hadoop.fs.FileSystem;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
import org.apache.hadoop.mapreduce.lib.output.TextOutputFormat;
import org.apache.hadoop.util.Tool;
import org.apache.hadoop.util.ToolRunner;







 public  class MarketDriver extends Configured implements Tool {
	 
	 public static void main(String[] args) throws Exception {

		    /*
		     * Validate that two arguments were passed from the command line.
		     */
		    if (args.length !=2) {
		      System.out.printf("Usage: StubDriver <input dir> <output dir>\n");
		      System.exit(-1);
		    }
		    
		    int exitStatus=ToolRunner.run(new MarketDriver(), args);
		    System.out.println(exitStatus);
	 } 
	 

 public int run(String args[]) throws Exception {
 String inputPath = args[0];
 String outputPath = args[1];
// int numberOfPairs = Integer.parseInt(args[2]);

 // job configuration
 @SuppressWarnings("deprecation")
Job job = new Job(getConf());
 job.setJarByClass(MarketDriver.class);
 job.setJobName("Market Basket Analysis");
 //job.getConfiguration().setInt("number.of.pairs", numberOfPairs);
 
 // set input/output path
 FileInputFormat.setInputPaths(job, new Path(inputPath));
 FileOutputFormat.setOutputPath(job, new Path(outputPath));

 // mapper K, V output

 job.setMapOutputKeyClass(Text.class);
 job.setMapOutputValueClass(IntWritable.class);
// output format
 job.setOutputFormatClass(TextOutputFormat.class);

 // reducer K, V output
 job.setOutputKeyClass(Text.class);
 job.setOutputValueClass(IntWritable.class);

 // set mapper/reducer/combiner
 job.setMapperClass(MarketMapper.class);
 job.setCombinerClass(MarketReducer.class);
 job.setReducerClass(MarketReducer.class);

 //delete the output path if it exists to avoid "existing dir/file" error
 Path outputDir = new Path(outputPath);
 FileSystem.get(getConf()).delete(outputDir, true);

 // submit job
 boolean status = job.waitForCompletion(true);
 return status ? 0:1;

 }







 }