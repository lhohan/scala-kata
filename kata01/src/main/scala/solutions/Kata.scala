package solutions

import scala.annotation.tailrec
import java.util.NoSuchElementException
import scala.NoSuchElementException
import scala.reflect.ClassTag

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

  //  Ugly using a while loop.
  //  def reverse[A: ClassTag](list: List[A]): List[A] = {
  //    val arr = list.toArray[A]
  //    val size = arr.size
  //    val last = size - 1
  //    var i = 0
  //    while (i < size / 2) {
  //      val c = arr(i)
  //      arr(i) = arr(last - i)
  //      arr(last - i) = c
  //      i = i + 1
  //    }
  //    arr.toList
  //  }

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
   * Kata:
   *
   * P08 (**) Eliminate consecutive duplicates of list elements.
   * If a list contains repeated elements they should be replaced with a single copy of the element. The order of the elements should not be changed.

   * Example:
   * scala> compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[Symbol] = List('a, 'b, 'c, 'a, 'd, 'e)
   **/
  def compress[A](list: List[A]) = list.foldRight(List[A]()) {
    (h, acc) => if (acc.isEmpty || acc.head != h) h :: acc else acc
  }

  // tail recursive solution:
  //  def compress[A](list :List[A]) = {
  //    def compressAcc(acc :List[A], rest:List[A]):List[A] = rest match {
  //      case Nil => acc.reverse
  //      case h :: tail => compressAcc(h :: acc, tail.dropWhile(_ == h))
  //    }
  //    compressAcc(List[A](), list)
  //  }


  /**
   * Kata:
   *
   * P09 (**) Pack consecutive duplicates of list elements into sublists.
   * If a list contains repeated elements they should be placed in separate
   * sublists.

   * Example:
   * scala> pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[List[Symbol]] = List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
   */
  def pack[A](list: List[A]): List[List[A]] = {
    if (list.isEmpty) List(List())
    else {
      val (current, next) = list.span(_ == list.head)
      if (next == Nil) List(current)
      else current :: pack(next)
    }
  }

  /**
   * Kata:
   *
   * P10 (*) Run-length encoding of a list.
   * Use the result of problem P09 to implement the so-called run-length encoding data compression method. Consecutive duplicates of elements are encoded as tuples (N, E) where N is the number of duplicates of the element E.
   * Example:

   * scala> encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[(Int, Symbol)] = List((4,'a), (1,'b), (2,'c), (2,'a), (1,'d), (4,'e))
   */
  def encode[A](list: List[A]): List[(Int, A)] = pack(list).map(x => (x.length, x.head))

  /**
   * Kata:
   *
   * P11 (*) Modified run-length encoding.
   * Modify the result of problem P10 in such a way that if an element has no duplicates it is simply copied into the result list. Only elements with duplicates are transferred as (N, E) terms.
   * Example:

   * scala> encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e))
   * res0: List[Any] = List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
   **/
  def encodeModified[A](list: List[A]): List[Any] =
    encode(list).map(p => if (p._1 == 1) p._2 else p)

  /**
   * Kata :
   *
   * P12 (**) Decode a run-length encoded list.
   * Given a run-length code list generated as specified in problem P10,
   * construct its uncompressed version.
   *
   * Example:
   * scala> decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e)))
   * res0: List[Symbol] = List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)
   **/
  def decode[A](list: List[(Int, A)]): List[A] = list.flatMap {
    x => List.fill[A](x._1)(x._2)
  }


  /**
   * Implement a parenthesises balancing function returning true if brackets match, false if not.
   *
   * Example:
   * (if (zero? x) max (/ 1 x)) is balanced
   * if (zero? x) max (/ 1 x)) is not
   **/
  def balance(chars: List[Char]): Boolean = ??? // solution not provided

  //TODO Move
  /**
   * Higher order functions.
   **/
  /**
   * Kata:
   *
   * Implement an unless function that will keep on executing a block of code
   * unless a condition is met. (Note the arguments being passed by name.)
   *
   * Example:
   * var x = 1
      unless(x > 5) {
        x += 1
      }
   **/
  def unless(condition: => Boolean)(block: => Unit) {
    if (!condition) {
      block
      unless(condition)(block)
    }
  }


  /**
   * Kata: Fizzbuzz
   *
   * Write a function that returns the list numbers from 1 to 100. But for multiples of three replace the number by "Fizz" instead of the
   * number and for the multiples of five replace by "Buzz". For numbers which are multiples of both three and
   * five use "FizzBuzz".
   */
  def fizzbuzz(s: Int): List[String] = {

    def wordFor(i: Int): String =
      if (i % 15 == 0) "FizzBuzz"
      else
      if (i % 3 == 0) "Fizz"
      else
      if (i % 5 == 0) "Buzz"
      else
        i.toString

    val fb: Stream[String] = Stream.from(1).map(i => wordFor(i))

    (fb take s).toList
  }

}
