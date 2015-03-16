import java.io._

import scala.collection.mutable.ArrayBuffer
import scala.io.Source

/**
 * Created by NaNLagger on 09.03.15.
 * @author Stepan Lyashenko
 */
object Lesson9 extends App {
  //ex 1.
  {
    val z1In = Source.fromFile("lesson8_1.txt").getLines().toArray.reverse;
    val z1Out = new PrintWriter("lesson8_1.txt");
    for (i <- z1In) z1Out.println(i)
    z1Out.close()
  }

  //ex 2.
  {
    val z2In = Source.fromFile("lesson8_2.txt").getLines().toArray;
    val z2Out = new PrintWriter("lesson8_2.txt")
    for (i <- z2In) z2Out.println(i.replaceAll("\t", "    "))
    z2Out.close()
  }

  //ex 3.
  {
    val z3 = Source.fromFile("lesson8_3.txt").mkString.split("\\s+")
    for (i <- z3) if (i.length >= 7) println(i)
  }

  //ex 4.
  {
    val z4 = for (i <- Source.fromFile("lesson8_4.txt").mkString.split("\\s+")) yield i.toDouble
    println(z4.sum + " " + z4.sum / z4.length + " " + z4.max + " " + z4.min);
  }

  //ex 5.
  {
    val z5 = new PrintWriter("lesson8_5.txt")
    for (i <- 0 to 20) z5.println("%8d %1.8f".format(Math.pow(2, i).toInt, 1 / Math.pow(2, i)))
    z5.close()
  }

  //ex 6.
  {
    val regex = """"(?:\\"|.)*?"""".r //it's magic, i don't know how this work, but this work!
    val strFind = Source.fromFile("lesson8_6.txt").mkString
    for (i <- regex.findAllIn(strFind)) println(i)
  }

  //ex 7.
  {
    val regex = "^[0-9]+(\\.[0-9]+)?$".r // if .1 include else "^[0-9]*(\.[0-9]+)?$"
    val strFind = Source.fromFile("lesson8_7.txt").mkString.split("\\s+")
    for (i <- strFind)
      if(regex.findFirstIn(i) == None)
        println(i)
  }

  //ex 8.
  {
    val regex = """<img\s+[^>]*\s+src="((?:\\"|.)*?)"""".r
    //println(Source.fromURL("http://ya.ru").mkString)
    for (regex(src) <- regex.findAllIn(Source.fromURL("http://ya.ru").mkString)) println(src)
  }

  //ex 10.
  {
    class Person(val name: String) extends Serializable {
      var friends = ArrayBuffer[Person]()
      def addFriend(friend: Person) = friends += friend
    }

    val anna = new Person("Anna")
    val boris = new Person("Boris")
    val clair = new Person("Clair")

    anna addFriend boris
    boris addFriend anna
    anna addFriend clair
    clair addFriend boris

    val all = Array(anna, boris, clair)

    println("Original objects: " + all.mkString(", "))

    val out = new ObjectOutputStream(new FileOutputStream("10.out"))
    out.writeObject(all)
    out.close()

    val in = new ObjectInputStream(new FileInputStream("10.out"))
    val res = in.readObject().asInstanceOf[Array[Person]]
    in.close()
  }
}
