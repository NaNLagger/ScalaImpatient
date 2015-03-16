/**
 * Created by NaNLagger on 28.02.15.
 * @author Stepan Lyashenko
 */
object HelloWorld {
  def main (args: Array[String]) {
    println("HelloWorld")
    val z = Math.abs(-12)
    println(z)
    val calc = new EvenMoreScientificCalculator("HP")
    val calc2 = new ScientificCalculator("HP")

    calc match {
      case i: ScientificCalculator => println("calc2 " + i.color)
      case i: EvenMoreScientificCalculator => println("calc " + i.color)
    }
  }
}
