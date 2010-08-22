import org.scalatest.FunSuite
import org.mockito.Matchers.anyObject
import org.mockito.Mockito._
import org.apache.hadoop.fs.Path
import org.apache.hadoop.io._
import org.apache.hadoop.mapred._


class MapTest extends FunSuite {
  val mapper = new Map()

  test("process vaild record") {
    val value = new Text("1950:-11")

    val output : OutputCollector[Text, IntWritable] =mock(classOf[OutputCollector[Text, IntWritable]])
    mapper.map(null,value,output,null)
    verify(output).collect(new Text("1950"), new IntWritable(-11))
  }

  test("process plus number") {
    val value = new Text("1950:+11")

    val output : OutputCollector[Text, IntWritable] =mock(classOf[OutputCollector[Text, IntWritable]])
    mapper.map(null,value,output,null)
    verify(output).collect(new Text("1950"), new IntWritable(11))
  }

  test("ignore missing temperature") {
    val value = new Text("1950:+9999")

    val output : OutputCollector[Text, IntWritable] =mock(classOf[OutputCollector[Text, IntWritable]])
    mapper.map(null,value,output,null)
    verify(output, never()).collect(anyObject(),anyObject())
  }
}

