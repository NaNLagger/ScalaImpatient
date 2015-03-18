package main


/**
 * Created by NaNLagger on 07.03.15.
 * @author Stepan Lyashenko
 */
object Lesson6 extends App {
  object Conversions {
    def inchesToCentimeters(inches: Float): Float = {
      inches * 2.54f
    }

    def gallonsToLiters(gallons: Float): Float = {
      gallons * 3.78f
    }

    def milesToKilometers(miles: Float): Float = {
      miles * 1.6f
    }
  }

  abstract class UnitConversion {
    def convert(value: Float): Float
  }

  object InchesToCentimeters extends UnitConversion {
    override def convert(value: Float): Float = value * 2.54f
  }

  object GallonsToLiters extends UnitConversion {
    override def convert(value: Float): Float = value * 3.78f
  }

  object MilesToKilometers extends UnitConversion {
    override def convert(value: Float): Float = value * 1.6f
  }

  /*class UnitConversion(val conversionFactor: Double) {
    private def convert(value: Double) = value * conversionFactor

    def apply(value: Double) = convert(value)
  }

  object InchesToCentimeters extends UnitConversion(2.54) {}
  object GallonsToLiters extends UnitConversion(3.78541) {}
  object MilesToKilometers extends UnitConversion(1.60934) {}*/

  var convert: UnitConversion = InchesToCentimeters;
  println(convert.convert(123))
  convert = MilesToKilometers
  println(convert.convert(123))

  class Point(var x: Float, var y: Float)

  object Point {
    def apply(x: Float, y: Float): Point = new Point(x, y)
  }

  val point = Point(3,4)

  for (i <- args reverse) println(i)

  object Cards extends Enumeration {
    //type Cards = Value
    val Kresti = Value("+")
    val Bubni = Value("^")
    val Piki = Value("#")
    val Chervi = Value("*")
  }

  println(Cards.Bubni)

  def isRed(cards: Cards.Value) = cards == Cards.Bubni || cards == Cards.Chervi

  object VertexCube extends Enumeration {
    type VertexCube = Value
    val Red = Value(0xff0000, "Red")
  }
}
