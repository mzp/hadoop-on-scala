import org.apache.hadoop.fs.Path
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._

class Map extends MapReduceBase with Mapper[LongWritable,Text,Text,IntWritable] {
  def map(key      : LongWritable,
	    value    : Text,
	    output   : OutputCollector[Text,IntWritable],
	    reporter : Reporter ) {
	      val xs = value.toString.split(":")
	      val year = xs(0)
	      val temp = parse(xs(1))

	      if(temp !=  9999){
		output.collect(new Text(year),new IntWritable(temp))
	      }
	    }

  def parse(s : String) : Int = {
    if(s(0) == '+')
      s.substring(1,s.length).toInt
    else
      s.toInt
  }
}
