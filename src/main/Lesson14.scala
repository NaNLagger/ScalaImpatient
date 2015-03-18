package main

/**
 * Created by NaNLagger on 16.03.15.
 * @author Stepan Lyashenko
 */
object Lesson14 extends App {
  //Ex 2.
  {
    def swap(pair: Tuple2[Int, Int]) = {
      pair match {
        case (x, y) => (y, x)
        case _ => None
      }
    }

    println(swap(10 -> 20))
  }

  //Ex 3.
  {
    def swap(array: Array[Any]) = {
      array match {
        case Array(x, y, other @ _*) => Array(y, x) ++ other
        case _ => array
      }
    }

    println(swap(Array(1,2,3,4,5,6,7)).mkString(" "))
  }

  //Ex 4.
  {
    abstract class Item
    case class Article(description: String, price: Double) extends Item
    case class Bundle(description: String, discount: Double, items: Item*) extends Item
    case class Multiple(size: Int, item: Item) extends Item

    def price(it: Item): Double = it match {
      case Article(_, p) => p
      case Bundle(_, disc, its @ _*) => its.map(price _).sum - disc
      case Multiple(size, item) => price(item) * size
      case _ => 0
    }
  }

  //Ex 5.
  {
    def leafSum(list: List[Any]): Int = {
      list.map(_ match {
        case k: Int => k
        case k: List[Any] => leafSum(k)
        case _ => 0
      }).sum
    }

    println(leafSum(List(List(3, List(1, 3), 8), 2, List(5))))
  }

  //Ex 6.
  {
    sealed abstract class BinaryTree
    case class Leaf(value: Int) extends BinaryTree
    case class Node(left: BinaryTree, right: BinaryTree) extends BinaryTree

    def leafSum(tree: BinaryTree): Int = {
      tree match {
        case Leaf(value) => value
        case Node(left, right) => leafSum(left) + leafSum(right)
      }
    }

    val tree = Node(Leaf(2), Node(Node(Leaf(2), Leaf(4)), Leaf(5)))
    println(leafSum(tree))
  }

  //Ex 7.
  {
    sealed abstract class BinaryTree
    case class Leaf(value: Int) extends BinaryTree
    case class Node(trees: BinaryTree*) extends BinaryTree

    def leafSum(tree: BinaryTree): Int = {
      tree match {
        case Leaf(value) => value
        case Node(other @ _*) => other.map(leafSum _).sum
      }
    }

    val tree = Node(Node(Leaf(3), Leaf(8)), Leaf(2), Node(Leaf(5)))
    println(leafSum(tree))
  }

  //Ex 8.
  {
    sealed abstract class BinaryTree
    case class Leaf(value: Int) extends BinaryTree
    case class Node(operator: Char, trees: BinaryTree*) extends BinaryTree

    def eval(tree: BinaryTree): Int = {
      tree match {
        case Leaf(value) => value
        case Node(op, other @ _*) if(op == '+') => other.map(eval _).sum
        case Node(op, other @ _*) if(op == '-') => other.map(eval _).foldLeft(0){_ - _}
        case Node(op, other @ _*) if(op == '*') => other.map(eval _).product
        case _ => 0
      }
    }

    val tree = Node('+', Node('*', Leaf(3), Leaf(8)), Leaf(2), Node('-', Leaf(5)))
    println(eval(tree))
  }

  //Ex 9.
  {
    def sumNotNull(list: List[Option[Int]]) = {
      list.map(_.getOrElse(0)).sum
    }

    println(sumNotNull(List(Some(1), None, Some(4))))
  }

  //Ex 10.
  {
    def f(x: Double) = if (x >= 0) Some(math.sqrt(x)) else None
    def g(x: Double) = if (x != 1) Some(1 / (x - 1)) else None

    def compose(fun1: Double => Option[Double], fun2: Double => Option[Double]): Double => Option[Double] = {
      (arg: Double) => if(fun1(arg) == None || fun2(arg) == None) None else fun2(arg)
    }
  }
}
