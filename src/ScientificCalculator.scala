/**
 * Created by NaNLagger on 28.02.15.
 * @author Stepan Lyashenko
 */
class ScientificCalculator(brand: String) extends Calculator(brand) {
  def log(m: Double, base: Double) = math.log(m) / math.log(base)
}

class EvenMoreScientificCalculator(brand: String) extends ScientificCalculator(brand) {
  def log(m: Int): Double = log(m, math.exp(1))
}

trait Car {
  val brand: String
}

class BMW extends Car {
  override val brand: String = "ddd"
}


