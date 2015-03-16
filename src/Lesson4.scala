import java.io.File
import java.util.Scanner

import scala.collection.SortedMap
import scala.collection.mutable.HashMap

/**
 * Created by NaNLagger on 04.03.15.
 * @author Stepan Lyashenko
 */
object Lesson4 {
  def main(args: Array[String]) {
    val z1 = Map("Notebook" -> 50000, "Guitar" -> 5000, "Freedom" -> 1000000);
    val z1Result = for((k, v) <- z1) yield (k, v * 0.9)
    println(z1Result)

    val in = new Scanner(new File("myfile.txt"));
    val words = new HashMap[String, Int]();
    /*while (in.hasNext) {
      val next = in.next()
      words(next) = if(words.contains(next)) words(next) + 1 else 1
    }*/
    var z3 = Map[String, Int]();
    while (in hasNext) {
      val next = in.next()
      var temp = 0
      val t3 = if(z3.contains(next)) {
        temp = z3(next)
        z3 -= next
        (next -> (temp + 1))
      } else {
        (next -> 1)
      }
      z3 += t3
    }

    println(z3)

    val in1 = new Scanner(new File("myfile.txt"));
    var z4 = SortedMap[String, Int]()
    while (in1 hasNext) {
      val next = in1.next()
      var temp = 0
      val t3 = if(z4.contains(next)) {
        temp = z4(next)
        z4 -= next
        (next -> (temp + 1))
      } else {
        (next -> 1)
      }
      z4 += t3
    }
    println(z4)

    println(lteqgt(Array(1,2,3,4,5,6,7,8,9,-1,4,7,8,2,4,-9), 5))

    println("Hello".zip("World"))
  }

  def minmax(values: Array[Int]): Tuple2[Int, Int] = {
    var min, max = values(0)
    for (value <- values) {
      if (min > value)
        min = value
      if (max < value)
        max = value
    }
    (min, max)
  }

  def lteqgt(values: Array[Int], v: Int): Tuple3[Int, Int, Int] = {
    var less, more, equals = 0
    for (value <- values) {
      if (value < v)
        less += 1
      if (value > v)
        more += 1
      if (value == v)
        equals += 1
    }
    (less, more, equals)
  }
}
