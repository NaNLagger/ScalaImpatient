package main

import scala.collection.mutable.ArrayBuffer

/**
 * Created by NaNLagger on 08.03.15.
 * @author Stepan Lyashenko
 */
object Lesson8 extends App {
  class BankAccount(private var balance: Double) {
    def deposit(amount: Double) = { balance += amount; balance }
    def withdraw(amount: Double) = { balance -= amount; balance }
    def currentBalance = balance
  }

  class CheckingAccount(initBalance: Double) extends BankAccount(initBalance) {
    override def deposit(amount: Double) = { super.deposit(amount-1) }
    override def withdraw(amount: Double) = { super.withdraw(amount+1) }
  }

  class SavingAccount(initBalance: Double) extends BankAccount(initBalance) {
    val FREE_OPERATION = 3;
    private var countOperation: Int = 0;
    def earnMonthlyInterest() = {
      super.deposit(currentBalance*0.05)
      countOperation = 0
    }

    override def deposit(amount: Double) = {
      countOperation += 1
      if(countOperation <= FREE_OPERATION)
        super.deposit(amount)
      else
        super.deposit(amount-1)
    }
    override def withdraw(amount: Double) = {
      countOperation += 1
      if(countOperation <= FREE_OPERATION)
        super.withdraw(amount)
      else
        super.withdraw(amount+1)
    }
  }

  abstract class Item {
    def price: Double
    def description: String
  }

  class SimpleItem(val price: Double, val description: String) extends Item

  class Bundle extends Item {
    var items = ArrayBuffer[Item]()

    def addItem(item: Item) = items += item

    override def price: Double = {
      var sum: Double = 0
      for (i <- items)
        sum += i.price
      sum
    }

    override def description: String = {
      {for (i <- items) yield i.description}.mkString("< ", ", ", " >")
    }
  }

  val b = new Bundle
  b.addItem(new SimpleItem(10, "huinya"))
  b.addItem(new SimpleItem(5.9, "huinya2"))

  val c = new Bundle
  c.addItem(b)
  c.addItem(new SimpleItem(3.4, "govno"))

  println(c.price + " " + c.description)

  //Ex 5.

  class Point(val x: Float, val y: Float)
  class LabeledPoint(val label: String, initX: Float, initY: Float) extends Point(initX, initY)

  //Ex 6.
  abstract class Shape {
    def centerPoint: Point
  }

  class Rectangle(val x: Float, val y: Float, val width: Float, val height: Float) extends Shape {
    val centerPoint = new Point(x + width/2, y + height/2)
  }

  class Circle(val x: Float, val y: Float, val radius: Float) extends Shape {
    val centerPoint = new Point(x, y)
  }

  //Ex 7.
  class Square(initX: Float, initY: Float, size: Float) extends Rectangle(initX, initY, size, size) {

    def this(size: Float) = {
      this(0, 0, size)
    }

    def this() = {
      this(0, 0, 0)
    }
  }

  //Ex. 8.


}
