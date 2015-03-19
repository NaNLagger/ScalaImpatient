package main.lesson15

import java.io.IOException

import com.sun.istack.internal.NotNull
import main.Lesson2

import scala.annotation.varargs
import scala.beans.BeanProperty
import scala.io.Source

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

  //Ex 4.
  {
    @varargs def sum(args: Int*) = args.sum
  }

  //Ex 5.
  @throws(classOf[IOException]) def fileToString(filename: String): String = {
    Source.fromFile(filename).getLines().mkString(" ")
  }

  //Ex 6.
  {
    object TestThread {
      @volatile var flag = false;
    }

    val a = new Thread(new Runnable {
      override def run(): Unit = {
        Thread.sleep(10000)
        TestThread.flag = true
        println("Thread a finish")
      }
    })

    val b = new Thread(new Runnable {
      override def run(): Unit = {
        while(!TestThread.flag) {
          println("No")
          Thread.sleep(1100)
        }
        println("Thread b finish")
      }
    })

    a.start()
    b.start()

  }

}
