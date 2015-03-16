import scala.beans.BeanProperty

/**
 * Created by NaNLagger on 07.03.15.
 * @author Stepan Lyashenko
 */
object Lesson5 {

  class Counter {
    private var value = Int.MaxValue;
    def increment() { if(value != Int.MaxValue) value += 1}
    def current = value
  }

  class BankAccount {
    private var balance = 0

    def deposit(dep: Int): Unit = {
      balance += dep
    }

    def currentBalance = balance
  }

  /*class Time(hrs: Int, min: Int) {
    private var hours = if(hrs >=0 || hrs <= 24) hrs else 0;
    private var minutes = if(min >=0 || min <= 60) min else 0;

    def before(other: Time): Boolean = {
      hours < other.hours || hours == other.hours && minutes < other.minutes
    }
  }*/

  class Time(hrs: Int, min: Int) {
    private var mTime = if((hrs >=0 || hrs <= 24) && (min >=0 || min <= 60)) hrs*60 + min else 0

    def before(other: Time): Boolean = {
      mTime < other.mTime
    }
  }

  class Student(@BeanProperty var name: String, @BeanProperty var id: Long) {

  }
  /*
  class Person(var age: Int = 0) {
    age = if(age < 0) 0 else age
  }*/

  class Person(name: String) {
    val firstName = name.substring(0, name.indexOf(" "))
    val lastName = name.substring(name.indexOf(" ")+1)
  }

  def main(args: Array[String]) {
    val counter = new Counter
    println(counter.current)
    counter.increment()
    println(counter.current)

    val time = new Time(1, 49)
    println(time.before(new Time(0, 48)))
    val student = new Student("Stepan", 1)
    student.getName

    val person = new Person("Stepan Lyashenko")
    println(person.firstName)
    println(person.lastName)
  }
}
