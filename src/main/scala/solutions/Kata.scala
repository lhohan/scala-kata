package solutions

import scala.annotation.tailrec
import java.util.NoSuchElementException
import scala.NoSuchElementException

object Kata {

  /**
   * Kata :
   * Implement factorial.
   **/
  def factorial(n: Int): Int = if (n <= 1) 1 else n * factorial(n - 1)

  /**
   * Kata :
   * Implement factorial using tail recursion (check using @tailrec).
   **/
  def factorialTailRec(n: Int): Int = {

    @tailrec
    def factorialAcc(n: Int, acc: Int): Int = if (n <= 1) acc else factorialAcc(n - 1, n * acc)

    factorialAcc(n, 1)
  }


  /**
   * Streams
   **/

  /**
   * Kata :
   * Implement Fibonacci using a Stream.
   **/
  def fibonacciStream(n: Int) = fibFrom(1, 1).take(n).toList.last

  def fibFrom(a: Int, b: Int): Stream[Int] = a #:: fibFrom(b, a + b)

  /**
   * Kata :
   * Implement factorial using Streams.
   **/
  def factorialStreams(n: Int): Int = ???


  /**
   * Working with lists
   **/

  /**
   * Kata:
   * 99P1 Find the last but one element of a list, _not_ using list.last
   **/
  def last[A](list: List[A]): A = list match {
    case e :: Nil => e
    case _ :: tail => last(tail)
    case _ => throw new NoSuchElementException
  }

  /**
   * Kata:
   * 99P2 Find the last but one element of a list, _not_ using list.init.last
   **/
  def penultimate[A](list: List[A]): A = list match {
    case e :: _ :: Nil => e
    case _ :: tail => penultimate(tail)
    case _ => throw new NoSuchElementException
  }

  /**
   * Kata:
   * P03 (*) Find the Kth element of a list.
   * By convention, the first element in the list is element 0. (Try not using build in nth.)
   * Example:
   *
   * scala> kth(2, List(1, 1, 2, 3, 5, 8))
   * res0: Int = 2
   **/
  def kth[A](k: Int, list: List[A]): A = (k, list) match {
    case (0, h :: _) => h
    case (k, _ :: tail) => kth(k - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  /** P04 (*) Find the number of elements of a list.
    *
    * Example:
    * scala> length(List(1, 1, 2, 3, 5, 8))
    * res0: Int = 6
    * */
  def length[A](list: List[A]): Int = list.foldLeft(0) {
    (c, _) => c + 1
  }

  // TODO?
  /**
   * Kata: Fizzbuzz
   * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the
   * number and for the multiples of five print "Buzz". For numbers which are multiples of both three and
   * five print "FizzBuzz".
   */

}
