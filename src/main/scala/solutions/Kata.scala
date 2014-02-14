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
   * By convention, the first element in the list is element 0. (Try not to use 'built ins' :-)
   *
   * Example:
   * scala> kth(2, List(1, 1, 2, 3, 5, 8))
   * res0: Int = 2
   **/
  def kth[A](k: Int, list: List[A]): A = (k, list) match {
    case (0, h :: _) => h
    case (k, _ :: tail) => kth(k - 1, tail)
    case (_, Nil) => throw new NoSuchElementException
  }

  /** P04 (*) Find the number of elements of a list. (Try not to use 'built ins' :-)
    *
    * Example:
    * scala> length(List(1, 1, 2, 3, 5, 8))
    * res0: Int = 6
    * */
  def length[A](list: List[A]): Int = list.foldLeft(0) {
    (c, _) => c + 1
  }

  /**
   * P05 (*) Reverse a list.
   * Hint: try varying recursive, tail-recursive or functional.
   *
   * Example:
   * scala> reverse(List(1, 1, 2, 3, 5, 8))
   * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
   **/
  def reverse[A](list: List[A]): List[A] = list.foldLeft(List[A]()) {
    (acc, el) => el :: acc
  }

  /**
   * P06 (*) Find out whether a list is a palindrome.
   *
   * Example:
   * scala> isPalindrome(List(1, 2, 3, 2, 1))
   * res0: Boolean = true
   *
   **/
  def isPalindrome[A](list: List[A]): Boolean = list == list.reverse

  /**
   * P07 (**) Flatten a nested list structure.
   *
   * Example:
   * scala> flatten(List(List(1, 1), 2, List(3, List(5, 8))))
   * res0: List[Any] = List(1, 1, 2, 3, 5, 8)
   **/
  def flatten(list: List[Any]): List[Any] = list.flatMap {
    case xel: List[_] => flatten(xel)
    case el@_ => List(el)
  }

  /**
   * P08 (**) Eliminate consecutive duplicates of list elements.
   * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

   * Example:
   * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
   **/
  def compress[A](list :List[A]) = list.foldRight(List[A]()){
    (h, acc)  => if(acc.isEmpty || acc.head != h) h :: acc else acc
  }

  // tail recursive solution:
//  def compress[A](list :List[A]) = {
//    def compressAcc(acc :List[A], rest:List[A]):List[A] = rest match {
//      case Nil => acc.reverse
//      case h :: tail => compressAcc(h :: acc, tail.dropWhile(_ == h))
//    }
//    compressAcc(List[A](), list)
//  }


  //  def reverse[A](list:List[A]):List[A] = {
  //    def reverseAcc(acc:List[A], list:List[A]):List[A] = list match {
  //      case Nil => acc
  //      case h :: tail => reverseAcc(h :: acc, tail)
  //    }
  //    reverseAcc(Nil, list)
  //  }

  //  def reverse[A](list:List[A]):List[A] = list match {
  //    case Nil => Nil
  //    case h :: tail => reverse(tail) :+ h
  //  }

  // TODO?
  /**
   * Kata: Fizzbuzz
   * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the
   * number and for the multiples of five print "Buzz". For numbers which are multiples of both three and
   * five print "FizzBuzz".
   */

}
