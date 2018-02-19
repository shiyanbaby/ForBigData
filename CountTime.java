package KPI;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.LongWritable;
import org.apache.hadoop.io.NullWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
import org.apache.hadoop.mapreduce.Reducer;
import util.JobUtil;

import java.io.IOException;


public class CountTime {
    public static class ForMapper extends Mapper<LongWritable,Text,Text,NullWritable>{
        private Text okey=new Text();
        @Override
        protected void map(LongWritable key, Text value, Context context) throws IOException, InterruptedException {
            String array[]=value.toString().split(" ");
            okey.set(array[3].substring(1));
            context.write(okey,NullWritable.get());
        }
    }

    public static class ForReducer extends Reducer<Text,NullWritable,Text,IntWritable>{
        private IntWritable ovalue =new IntWritable();

        @Override
        protected void reduce(Text key, Iterable<NullWritable> values, Context context) throws IOException, InterruptedException {
           int count=0;
           for(NullWritable i:values){
               count++;
           }
           ovalue.set(count);
           context.write(key,ovalue);
        }
    }

    public static void main(String[] args) {
        JobUtil.commitJob(CountTime.class,"D:\\Program Files\\feiq\\Recv Files\\MapReducer所有内容\\MapReduce经典案例 WordCount 练习题及答案\\MapReduce经典案例 WordCount 练习题及答案\\实验数据","");
    }
}
