/**
 * Created by NaNLagger on 28.02.15.
 * @author Stepan Lyashenko
 */
class Calculator(brand: String) {
  /**
   * Конструктор.
   */
  val color: String = if (brand == "TI") {
    "blue"
  } else if (brand == "HP") {
    "black"
  } else {
    "white"
  }

  // Метод экземпляра класса.
  def add(m: Int, n: Int): Int = m + n
}
