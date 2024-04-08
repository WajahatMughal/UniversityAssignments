import java.io.DataInput;
import java.io.DataOutput;
import java.io.IOException;
import org.apache.hadoop.io.Writable;


public class Student implements Writable {
       private Double average = new Double(0);
       private long count = 1;
       private int age;
       private String department;
       private String grade;
       private String module;
       private int id;
       private String name;
       private String sex;
       private double marks;

public Student(){
}
public Student(int id, String name,String sex,int age, String grade,String module, double marks) {
        this.id = id;
        this.name = name;
        this.sex=sex;
        this.age=age;
        this.grade = grade;
        this.marks = marks;
}
public Double getAverage() {
return average;
}
public void setAverage(Double average) {
this.average = average;
}
public long getCount() {
return count;
}
public void setCount(long count) {
this.count = count;
}
public void readFields(DataInput in) throws IOException {
average = in.readDouble();
count = in.readLong();
}
public void write(DataOutput out) throws IOException {
out.writeDouble(average);
out.writeLong(count);
}
public String toString() {
return average + "\t" + count;
}

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getMarks() {
        return marks;
    }

    public void setMarks(double marks) {
        this.marks = marks;
    }
 public String getModule() {
        return module;
    }

    public void setModule(String module) {
        this.module = module;
    }


}






import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Mapper;
public class AverageGradeMapper extends Mapper<Object, Text, Text, Student> {
private Student averageTuple = new Student();
private Text ModuleName = new Text();
@Override
public void map(Object key, Text value, Context context) throws IOException, InterruptedException {
String data = value.toString();
String[] field = data.split(",", -1);
double salary = 0;
if (null != field && field.length == 9 && field[7].length() >0) {
salary=Double.parseDouble(field[7]);
averageTuple.setAverage(salary);
averageTuple.setCount(1);
ModuleName.set(field[3]);
context.write(ModuleName, averageTuple);
}
}
}


import java.io.IOException;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;
public class AverageGradeReducer extends Reducer<Text, Student, Text, Student> {
private Student result = new Student();
public void reduce(Text key, Iterable<Student> values, Context context)
throws IOException, InterruptedException {
double sum = 0;
long count = 0;
for (Student Student : values) {
sum = sum + Student.getAverage() * Student.getCount();
count = count + Student.getCount();
}
result.setCount(count);
result.setAverage(sum / count);
context.write(new Text(key.toString()), result);
}
}






import java.io.File;
import org.apache.commons.io.FileUtils;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;
public class DriverAverage {
public static void main(String[] args) throws Exception {
/*
* I have used my local path in windows change the path as per your
* local machine
*/
args = new String[] { "Replace this string with Input Path location",
"Replace this string with output Path location" };
/* delete the output directory before running the job */
FileUtils.deleteDirectory(new File(args[1]));
/* set the hadoop system parameter */
System.setProperty("hadoop.home.dir", "replace this with hadoop home directory location");
if (args.length != 2) {
System.err.println("Please specify the input and output path");
System.exit(-1);
}
Configuration conf = ConfigurationFactory.getInstance();
Job job = Job.getInstance(conf);
job.setJarByClass(DriverAverage.class);
job.setJobName("Find_Average_Grade");
FileInputFormat.addInputPath(job, new Path(args[0]));
FileOutputFormat.setOutputPath(job, new Path(args[1]));
job.setMapperClass(AverageGradeMapper.class);
job.setReducerClass(AverageGradeReducer.class);
job.setOutputKeyClass(Text.class);
job.setOutputValueClass(CustomAverageTuple.class);
System.exit(job.waitForCompletion(true) ? 0 : 1);
}
}