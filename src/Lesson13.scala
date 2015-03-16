/**
 * Created by NaNLagger on 14.03.15.
 * @author Stepan Lyashenko
 */
object Lesson13 extends App {
  //Ex 1.
  {
    import scala.collection.mutable.Map
    def indexes(str: String) = {
      (str zipWithIndex).foldLeft(Map[Char, Set[Int]]()) {
        (m, c) => m(c._1) = (m.getOrElse(c._1, Set[Int]()) + c._2); m
      }
    }

    println(indexes("Mississippi"))
  }

  //Ex 2.
  {
    import scala.collection.immutable.Map
    def indexes(str: String) = {
      (str zipWithIndex).foldLeft(Map[Char, List[Int]]()) {
        (m, c) => m + (c._1 -> (m.getOrElse(c._1, List[Int]()) :+ c._2))
      }
    }

    println(indexes("Mississippi"))
  }

  //Ex 3.
  {
    val list = List(1, 4, 3, 5, 0, 2, 6, 1, 6, 0, -3)
    def delnull(list: List[Int]) = {
      list.filter(_ != 0)
    }
    println(delnull(list))
  }

  //Ex 4.
  {
    def nevazhno(array: Array[String], maps: Map[String, Int]) = {
      array.flatMap(maps.get(_))
    }

    println(nevazhno(Array("Tom", "Fred", "Harry"), Map("Tom" -> 3, "Dick" -> 4, "Harry" -> 5)).mkString)
  }

  //Ex 5.
  {
    println(Array(1, 3, 5, 2, 5, 2, 3).foldLeft("")(_ + _.toString)) // Var with foldLeft
    println(Array(1, 3, 5, 2, 5, 2, 3).map(_.toString).reduceLeft(_ + _))
  }

  //Ex 6.
  {
    val lst = (1 to 10).toList
    println((lst :\ List[Int]())((x,y) => y :+ x))
    println((List[Int]() /: lst)((x,y) => y :: x))
  }

  //Ex 7.
  {
    val prices = List(5.0, 20.0, 9.95)
    val quantities = List(10, 2, 1)

    (prices zip quantities) map { Function.tupled((x: Double, y: Int) => x * y)(_) }
  }

  //Ex 8.
  {
    def groupEx(mas: Array[Double], columns: Int) = {
      mas.grouped(columns).toArray.map(_.toArray)
    }

    groupEx(Array(1, 2, 3, 4, 5, 6), 3)
  }
}
