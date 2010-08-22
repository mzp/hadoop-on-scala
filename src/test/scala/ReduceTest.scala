import org.scalatest.FunSuite
import org.mockito.Matchers.anyObject
import org.mockito.Mockito._
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._
import scala.collection.JavaConversions._

class ReduceTest extends FunSuite {
  val reducer = new Reduce()
  test("return max int value") {
    val key = new Text("1950")
    val values : Iterator[IntWritable] = List(
      new IntWritable(10),new IntWritable(5)
    ).elements

    val output : OutputCollector[Text, IntWritable] =mock(classOf[OutputCollector[Text, IntWritable]])
    reducer.reduce(key, values, output, null)
    verify(output).collect(key, new IntWritable(10))
  }
}
