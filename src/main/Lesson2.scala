package main

/**
 * Created by NaNLagger on 02.03.15.
 * @author Stepan Lyashenko
 */
object Lesson2 {
  def main (args: Array[String]) {
    println(pow(2,10))
  }

  def pow(x: Int, n: Int): Int = {
    if(n >= 31) throw new IllegalArgumentException() //need for Lesson15
    if(n > 0 && n % 2 == 0) {
      var y = pow(x,n/2)
      y *= y
      y
    } else {
      if (n > 0 && n % 2 == 1) {
        x * pow(x, n - 1)
      } else {
        if(n == 0)
          1
        else {
          if(n < 0) {
            1/pow(x, -n)
          } else {
            1
          }
        }
      }
    }
  }
}
