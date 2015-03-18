package main

/**
 * Created by NaNLagger on 11.03.15.
 * @author Stepan Lyashenko
 */
object Lesson10 extends App {
  //Ex 1.
  {
    import java.awt.geom.Ellipse2D
    trait RectangleLike {
      def getX: Double
      def getY: Double
      def setFrame(x: Double, y: Double, w: Double, h: Double)
      def getWidth: Double
      def getHeight: Double
      def translate(x: Double, y: Double)= {
        setFrame(getX + x, getY + y, getWidth, getHeight)
      }
      def grow(x: Double, y: Double) = {
        setFrame(getX, getY, getWidth + x, getHeight + y)
      }
    }

    val egg = new Ellipse2D.Double(5, 10, 20, 30) with RectangleLike
    egg.translate(10, -10)
    egg.grow(10, 20)
  }

  //Ex 2.
  {
    import java.awt.Point
    class OrderedPoint extends Point with scala.math.Ordered[Point] {
      override def compare(that: Point): Int = {
        if (x < that.x || x == that.x && y < that.y)
          -1
        else
          if (x == that.x && y == that.y) 0 else 1
      }
    }

    val orderedPoint = new OrderedPoint
    orderedPoint.setLocation(1,1)
    orderedPoint.compare(new Point(1,2))
  }

  //Ex 3.
  {
    //
  }

  //Ex 4.
  {
    trait Coder {
      def coder(message: String): String
      def decoder(codMessage: String): String
    }

    trait Logger {
      def log(message: String)
    }

    trait ConsoleLogger extends Logger {
      def log(message: String) = {
        println(message)
      }
    }

    trait CaesarLogger extends ConsoleLogger with Coder {
      val key: Int = 3
      override def coder(message: String): String = {
        (for (char <- message) yield (char + key).toChar).mkString
      }
      override def decoder(message: String): String = {
        (for (char <- message) yield (char - key).toChar).mkString
      }
      override def log(message: String) = {
        super.log(coder(message))
      }
    }

    class CryptoLogger extends Logger {
      override def log(message: String): Unit = {}
    }

    val z = new CryptoLogger with CaesarLogger
    z.log("Hello World")
    val z2 = new {override val key = -3} with CaesarLogger
    z2.log("Khoor#Zruog")
  }

  //Ex 5.
  {
    import java.beans.{PropertyChangeEvent, PropertyChangeListener, PropertyChangeSupport}

    trait PropertyChangeSupportLike {
      var support = new PropertyChangeSupport(this);
      def addPropertyChangeListener(listener: PropertyChangeListener) =
        support.addPropertyChangeListener(listener)
      def removePropertyChangeListener(listener: PropertyChangeListener) =
        support.removePropertyChangeListener(listener)
      def getPropertyChangeListeners: Array[PropertyChangeListener] =
        support.getPropertyChangeListeners()
      def addPropertyChangeListener(propertyName: String, listener: PropertyChangeListener) =
        support.addPropertyChangeListener(propertyName, listener)
      def removePropertyChangeListener(propertyName: String, listener: PropertyChangeListener) =
        support.removePropertyChangeListener(propertyName, listener)
      def getPropertyChangeListeners(propertyName: String): Array[PropertyChangeListener] =
        support.getPropertyChangeListeners(propertyName)
      def firePropertyChange(propertyName: String, oldValue: AnyRef, newValue: AnyRef) =
        support.firePropertyChange(propertyName, oldValue, newValue)
      def firePropertyChange(propertyName: String, oldValue: Int, newValue: Int) =
        support.firePropertyChange(propertyName, oldValue, newValue)
      def firePropertyChange(propertyName: String, oldValue: Boolean, newValue: Boolean) =
        support.firePropertyChange(propertyName, oldValue, newValue)
      def firePropertyChange(event: PropertyChangeEvent) =
        support.firePropertyChange(event)
      def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: AnyRef, newValue: AnyRef) =
        support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
      def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Int, newValue: Int) =
        support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
      def fireIndexedPropertyChange(propertyName: String, index: Int, oldValue: Boolean, newValue: Boolean) =
        support.fireIndexedPropertyChange(propertyName, index, oldValue, newValue)
      def hasListeners(propertyName: String): Boolean =
        support.hasListeners(propertyName)
    }
  }

  //Ex 7.
  {
    trait Animal {
      def name: String
      def say(message: String) = println(message)
    }

    trait TouretteSyndrome extends Animal {
      override def say(message: String) = {
        super.say((for(word <- message.split("\\s+")) yield word + " fuck").mkString(" "))
      }
    }

    trait IKnowMyName extends Animal {
      override def say(message: String) = {
        super.say("My name is " + name + ". " + message)
      }
    }

    val person1 = new {override val name = "Orange"} with TouretteSyndrome with IKnowMyName
    person1.say("What's up bro?")
    val person2 = new {override val name = "Apple"} with IKnowMyName with TouretteSyndrome
    person2.say("I'm sad :(")
  }

  //Ex 8.
  {
    import java.io.InputStream
    trait BufferedInputStreamLike {
      this: InputStream =>

      val BUF_SIZE: Int = 5
      private val buf = new Array[Byte](BUF_SIZE)
      private var bufsize: Int = 0
      private var pos: Int = 0

      override def read(): Int = {
        if (pos >= bufsize) {
          bufsize = this.read(buf, 0, BUF_SIZE)
          if (bufsize > 0) -1
          pos = 0
        }
        pos += 1
        buf(pos-1)
      }
    }

  }

  //Ex 9.
  {

  }

  //Ex 10.
  {

  }
}
