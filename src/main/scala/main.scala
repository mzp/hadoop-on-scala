import org.apache.hadoop.fs.Path
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._

object Main {
  def main(args : Array[String]){
    if(args.length != 2){
      System.err.println("Usage: max <input path> <output path>")
      println(args(0))
      System.exit(-1)
    }

    val conf : JobConf = new JobConf( Class.forName("Main") )
    conf.setJobName("max")

    FileInputFormat .addInputPath ( conf, new Path(args(0)) )
    FileOutputFormat.setOutputPath( conf, new Path(args(1)) )

    conf.setMapperClass(classOf[Map])
    conf.setReducerClass(classOf[Reduce])

    conf.setOutputKeyClass(classOf[Text])
    conf.setOutputValueClass(classOf[IntWritable])

    JobClient.runJob(conf)
  }
}
