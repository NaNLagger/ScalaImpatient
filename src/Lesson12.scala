/**
 * Created by NaNLagger on 13.03.15.
 * @author Stepan Lyashenko
 */
object Lesson12 extends App{
  //Ex 1.
  {
    def values(fun: (Int) => Int, low: Int, high: Int) = {
      for (i <- low to high) yield i -> fun(i)
    }

    println(values(x => x * x, -5, 5))
  }

  //Ex 2.
  {
    println(Array(1,2,3,1,5,2,7,1).reduceLeft((x, y) => if(x < y) y else x))
    println(Array(1,2,3,1,5,2,7,1).reduceLeft(math.max(_,_)))
  }

  //Ex 3.
  {
    def fact(n: Int) = (1 to n).reduceLeft(_ * _)
    println(fact(5))
  }

  //Ex 4.
  {
    def fact(n: Int) = (1 to n).foldLeft(1)(_ * _)
    println(fact(-2))
  }

  //Ex 5.
  {
    def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
      inputs.map(fun).max
    }
    println(largest(x => 10 * x - x * x, 1 to 10))
  }

  //Ex 6.
  {
    def largest(fun: (Int) => Int, inputs: Seq[Int]) = {
      (inputs zip inputs.map(fun)).reduceLeft((x,y) => if(x._2 < y._2) y else x)._1
    }
    println(largest(x => 10 * x - x * x, 1 to 10))
  }

  //Ex 7.
  {
    val pairs = (1 to 10) zip (11 to 20)
    def adjustToPair(fun: (Int, Int) => Int) = {
      (pair: Tuple2[Int, Int]) => fun(pair._1, pair._2)
    }
    println(pairs.map(adjustToPair(_ * _)))
  }

  //Ex 8.
  {
    val a = Array("Hello", "World", "Bro")
    val b = a.map(_.length)
    println(a.corresponds(b)(_.length() == _))
  }

  //Ex 9.
  {
    /** @author Alexander Mikhailov
      * https://github.com/hempalex/scala-impatient/blob/master/Chapter12/09.scala
      **/
    def corresponds[A, B](a: Seq[A], b: Seq[B], f: (A, B) => Boolean) = (a zip b).map(x => f(x._1, x._2)).count(!_) == 0

    val a = Array("Hello", "beautyful", "world", "!")
    val b = a.map(_.length)

    println(a.mkString(", "))
    println(b.mkString(", "))

    val y = corresponds(a, b, (x: String, y: Int) => x.length == y)

    println(y)
  }

  //Ex 10.
  {
    def unless(a: Boolean)(fun: => Unit) = {
      if(!a) fun
    }

    unless(2 != 2) { println("asdsadsad") }
  }
}
