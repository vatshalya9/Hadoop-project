

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;




public class MarketMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

public static final int DEFAULT_NUMBER_OF_PAIRS = 2;

// output key2: list of items paired; can be 2 or 3 ...
 private static final Text reducerKey = new Text();

// output value2: number of the paired items in the item list
private static final IntWritable NUMBER_ONE = new IntWritable(1);

int numberOfPairs; // will be read by setup(), set by driver

 protected void setup(Context context)
throws IOException, InterruptedException {
 this.numberOfPairs = context.getConfiguration( ).getInt("number.of.pairs", DEFAULT_NUMBER_OF_PAIRS);
 }

 
public void map(LongWritable key, Text value, Context context)
 throws IOException, InterruptedException {
 String line = value.toString().trim();
 List<String> items = convertItemsToList(line);
if ((items == null) || ( items.isEmpty())) {
// no mapper output will be generated
 return;
 }
 generateMapperOutput(numberOfPairs, items, context);
 }

 private static List<String> convertItemsToList(String line) {
if ((line == null) || ( line.length() == 0)) {
// no mapper output will be generated
 return null;
 }
 String[] tokens = StringUtils.split(line, ",");
 if (( tokens == null) || ( tokens.length == 0) ) {
 return null;
 }
 List<String> items = new ArrayList<String>();
 for (String token : tokens) {
 if (token != null) {
 items.add(token.trim());
 }
 }
 return items;
 }

 private void generateMapperOutput(int numberOfPairs,
		 List<String> items,
		  Context context)
		  throws IOException, InterruptedException {
		  List<List<String>> sortedCombinations =
		  Combination.findSortedCombinations(items, numberOfPairs);
		  for (List<String> itemList: sortedCombinations) {
		  reducerKey.set(itemList.toString());
		  context.write(reducerKey, NUMBER_ONE);
		  }
		  }
		  }