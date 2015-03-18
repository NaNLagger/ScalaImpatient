package main.lesson15

import main.Lesson2
import org.junit.Assert._
import org.junit.Test
/**
 * Created by NaNLagger on 18.03.15.
 * @author Stepan Lyashenko
 */
class Lesson2Test {

  @Test
  def testLesson2(): Unit = {
    assertEquals(Lesson2.pow(2,10), 1024)
  }

  @Test(timeout = 1)
  def testLesson2_1() = {
    assertEquals(Lesson2.pow(2,30), 1073741824)
  }

  @Test(timeout = 1, expected = classOf[IllegalArgumentException])
  def testLesson2_2() = {
    Lesson2.pow(2,31)
    ()
  }
}
