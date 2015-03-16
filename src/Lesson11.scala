import scala.collection.mutable.ArrayBuffer

/**
 * Created by NaNLagger on 12.03.15.
 * @author Stepan Lyashenko
 */
object Lesson11 extends App {
  //Ex 3.
  {
    class Fraction(n: Int, d: Int) {
      private val num: Int = if (d == 0) 1 else n * sign(d) / gcd(n, d)
      private val den: Int = if (d == 0) 0 else d * sign(d) / gcd(n, d)
      override def toString() = num + "/" + den
      def sign(a: Int) = if (a > 0) 1 else if (a < 0) -1 else 0
      def gcd(a: Int, b: Int): Int = if (b == 0) math.abs(a) else gcd(b, a % b)
      def + (other: Fraction): Fraction = new Fraction(num*other.den + other.num*den, den * other.den)
      def - (other: Fraction): Fraction = new Fraction(num*other.den - other.num*den, den * other.den)
      def * (other: Fraction): Fraction = new Fraction(num * other.num, den * other.den)
      def / (other: Fraction): Fraction = new Fraction(num * other.den, den * other.num)
    }

    object Fraction {
      def apply(n: Int, d: Int): Fraction = new Fraction(n, d)
    }

    val z = Fraction(2, 5) + Fraction(1, -8)
    println(z)
  }

  //Ex 4.
  {
    class Money(a: Int, b: Int) {
      private val dollars = a + b / 100
      private val cents = b % 100
      def + (other: Money) = new Money(dollars + other.dollars, cents + other.cents)
      def - (other: Money) = new Money(dollars - other.dollars, cents - other.cents)
      def == (other: Money) = dollars == other.dollars && cents == other.cents
      def < (other: Money) = dollars < other.dollars || dollars == other.dollars && cents < other.cents
    }

    object Money {
      def apply(a: Int, b: Int) = new Money(a, b)
    }

    println(Money(1, 75) + Money(0, 50) == Money(2, 25))
  }

  //Ex 5.
  {
    class Table(val table: ArrayBuffer[String]) {

      def this() {
        this(ArrayBuffer(""))
      }

      def | (string: String) = {
        table(table.size-1) = table.last + "<td>" + string + "</td>"
        this
      }

      def || (string: String) = {
        table += "<td>" + string + "</td>"
        this
      }

      override def toString() = "<table>" + (for(tr <- table) yield "<tr>" + tr + "</tr>").mkString("\n", "\n", "\n") + "</table>"
    }

    object Table {
      def apply() = new Table()
    }

    val z = Table() | "Java" | "Scala" || "Gosling" | "Odersky" || "JVM" | "JVM, .NET"
    println(z)
  }

  //Ex 6.
  {
    class ASCIIArt(val table: Array[String]) {

      def | (other: ASCIIArt) = {
        val temp = {for (i <- 0 until math.max(table.size, other.table.size)) yield {
          if (i < table.size && i < other.table.size)
            table(i) + other.table(i)
          else
            if (i < table.size)
              table(i)
            else
              other.table(i)
        } }.toArray
        new ASCIIArt(temp);
      }

      def || (other: ASCIIArt) = {
        new ASCIIArt(table ++ other.table)
      }

      override def toString = {
        table.mkString("\n")
      }
    }

    val z1 = new ASCIIArt(Array(" /\\_/\\ ",
                                "( ' ' )",
                                "(  -  )"))
    println(z1 | z1)
  }

  //Ex 7.
  {
    class BitSequence(private var seq: Long) {
      def apply(index: Long) = (seq >> index) & 0x1
      def update(index: Long, value: Int) = {
        if(value == 1)
          seq |= (1L << index)
        else
          seq &= ~(1L << index)
      }
    }

    val z1 = new BitSequence(0L)
    z1(2) = 1
    println(z1(2))
    z1(2) = 0
    println(z1(2))
  }

  //Ex 8.
  {
    class Matrix {
      private val size = 2
      val mat = Array.ofDim[Int](size,size)
      def + (other: Matrix) = {
        val temp = new Matrix
        for (i <- 0 until size; j <- 0 until size) {
          temp(i,j) = this(i,j) + other(i,j)
        }
        temp
      }
      def * (other: Matrix) = {
        val temp = new Matrix
        for (i <- 0 until size; j <- 0 until size) {
          temp(i,j) = (for (k <- 0 until size) yield this(i,k) * other(k,i)).sum
        }
        temp
      }
      def * (value: Int) = {
        val temp = new Matrix
        for (i <- 0 until size; j <- 0 until size) {
          temp(i,j) *= value
        }
      }
      def apply(i: Int, j: Int) = mat(i)(j)
      def update(i: Int, j: Int, value: Int) = mat(i)(j) = value
    }
  }

  //Ex 9 && 10.
  {
    class RichFile(src: String) {
      def unapply(input: String) = {
        val posS = input.lastIndexOf("/");
        val posD = input.lastIndexOf(".")
        if (posS != -1 && posD != -1) {
          val path = input.substring(0,posS)
          val filename = input.substring(posS+1, posD)
          val ex = input.substring(posD+1)
          Some(path, filename, ex)
        }
        else
          None
      }

      def unapplySeq(input: String) = {
        if (input.trim == "") None else Some(input.trim.split("/"))
      }
    }
  }

}
