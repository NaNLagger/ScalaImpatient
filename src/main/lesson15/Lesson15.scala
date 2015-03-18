package main.lesson15

import com.sun.istack.internal.NotNull
import main.Lesson2

import scala.annotation.varargs
import scala.beans.BeanProperty

/**
 * Created by NaNLagger on 18.03.15.
 * @author Stepan Lyashenko
 */
object Lesson15 extends App {
  //Ex 1. see Lesson2Test

  //Ex 2.
  {
    @Deprecated class WhippingBoy @Deprecated() (@NotNull message: String = "Oh no, stop it!") {
      @BeanProperty var count_shot: Int = 10
      def shot() = {
        if (count_shot > 0) {
          count_shot -= 1 : @Deprecated
          println(message)
        } else {
          println("I'm already dead")
        }
      }
    }
  }

  //Ex 3.
  {
    @varargs def sum(args: Int*) = args.sum
  }


}
