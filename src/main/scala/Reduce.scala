import java.util.Iterator
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._


class Reduce extends MapReduceBase with Reducer[Text, IntWritable, Text, IntWritable] {
  implicit def j2s(value: java.util.Iterator[IntWritable]) : scala.Iterator[Int] =
    new scala.Iterator[Int] {
      def hasNext = value.hasNext
      def next = value.next.get
    }

  def reduce(key      : Text,
	          values   : Iterator[IntWritable],
	          output   : OutputCollector[Text,IntWritable],
	          reporter : Reporter) {
    val max : Int = values.reduceLeft(Math.max(_,_))
    output.collect(key, new IntWritable(max))
		  }
}
