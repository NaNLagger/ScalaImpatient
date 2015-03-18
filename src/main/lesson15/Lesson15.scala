package main.lesson15

import main.Lesson2

/**
 * Created by NaNLagger on 18.03.15.
 * @author Stepan Lyashenko
 */
object Lesson15 extends App {

  {
    import org.junit.Assert._
    import org.junit.Test
    class Lesson2Test {
      @Test
      def testLesson14(): Unit = {
        assertEquals(Lesson2.pow(2,10), 1020)
      }
    }
  }


}
