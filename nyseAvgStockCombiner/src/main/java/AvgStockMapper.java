import java.io.IOException;

import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;

public class AvgStockMapper extends Mapper<LongWritable, Text, CustomTextPair, CustomLongPair> {

	private static NYSEParser parser = new NYSEParser();
	private static CustomTextPair mapOutputKey = new CustomTextPair();
	private static CustomLongPair mapOutputValue = new CustomLongPair();
	
	public void map(LongWritable LineOffset, Text record, Context context) throws IOException, InterruptedException{
		parser.parse(record.toString());
		
		mapOutputKey.setFirst(new Text(parser.getTradeDate()));
		mapOutputKey.setSecond(new Text(parser.getStockTicker()));
		
		mapOutputValue.setFirst(new LongWritable(parser.getVolume()));
		mapOutputValue.setSecond(new LongWritable(1));
		
		context.write(mapOutputKey, mapOutputValue);
	}
}
