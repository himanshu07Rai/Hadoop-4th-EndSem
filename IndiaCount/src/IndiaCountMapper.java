import java.io.IOException;
import org.apache.hadoop.io.DoubleWritable;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Mapper.Context;

public class IndiaCountMapper extends Mapper<LongWritable, Text, Text, IntWritable> {

	public void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
		String inputstring = value.toString();
		for (String x : inputstring.split(" ")) {
			if(x.compareTo("Indian")!=0 && x.contains("India"))
				context.write(new Text("India"),new IntWritable(1));
		}
	}
}