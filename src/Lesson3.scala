import scala.collection.mutable.ArrayBuffer

/**
 * Created by NaNLagger on 03.03.15.
 * @author Stepan Lyashenko
 */
object Lesson3 {
  def main (args: Array[String]) {
    val z1 = for(i <- 0 until 10) yield i
    println(z1.toArray.mkString(" "))
    val z2 = Array(1, 2, 3, 4, 5)
    /*for(i <- 0 until z2.length-1 if i % 2 == 0) {
      var temp = z2(i)
      z2(i) = z2(i+1)
      z2(i+1) = temp
    }*/
    val z3 = for(i <- 0 until z2.length) yield {
      if (i % 2 == 0)
        if (i+1 == z2.length)
          z2(i)
        else
          z2(i+1)
      else z2(i-1)
    }
    println(z3.mkString(" "))

    val z4 = Array(1, 3, 2, -1, 3, 0, -3, 2, -1)
    var res4 = ArrayBuffer[Int]()
    res4 ++= {for(i <- 0 until z4.length if z4(i) > 0) yield z4(i) }.toArray
    res4 ++= {for(i <- 0 until z4.length if z4(i) <= 0) yield z4(i) }.toArray
    println(res4.mkString(" "))

    val z5 = Array[Double](1, 3.2, 5.6, 13.5, 64.1)
    println(z5.sum/z5.length)
    println(z4.distinct.mkString(" "))
  }
}
