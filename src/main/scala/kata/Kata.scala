package kata

object Kata {

  /**
   * Kata:
   * Implement factorial.
   **/
  def factorial(n: Int): Int = ???

  /**
   * Kata:
   * Implement factorial using tail recursion (check using @tailrec).
   **/
  def factorialTailRec(n: Int): Int = ???

  /**
   * Kata :
   * Implement Fibonacci using a Stream.
   **/
  def fibonacciStream(n: Int) = fibFrom(1, 1).take(n).toList.last

  def fibFrom(a: Int, b: Int): Stream[Int] = ???


  /**
   * Working with lists
   **/

  /**
   * Kata:
   * P01 (*) Find the last element of a list. (Try _not_ using list.last)
   *
   * Example:
   * scala> last(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 8
   **/
  def last[A](list: List[A]): A = ???

  /**
   * Kata:
   * P02 (*) Find the last but one element of a list. (Try _not_ using list.init.last)
   * Example:
   * scala> penultimate(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 5
   **/
  def penultimate[A](list: List[A]): A = ???

  /**
   * Kata:
   * P03 (*) Find the Kth element of a list.
   * By convention, the first element in the list is element 0. (Try not using build in nth.)
   * Example:
   *
   * scala> kth(2, List(1, 1, 2, 3, 5, 8))
   * res0: Int = 2
   **/
  def kth[A](k: Int, list: List[A]): A = ???

  /**
   * Kata:
   * P04 (*) Find the number of elements of a list.
   *
   * Example:
   * scala> length(List(1, 1, 2, 3, 5, 8))
   * res0: Int = 6
   **/
  def length[A](list: List[A]): Int = ???

  /**
   * Kata:
   * P05 (*) Reverse a list.
   * Hint: try varying recursive, tail-recursive or functional.
   *
   * Example:
   * scala> reverse(List(1, 1, 2, 3, 5, 8))
   * res0: List[Int] = List(8, 5, 3, 2, 1, 1)
   **/
  def reverse[A](list: List[A]): List[A] = ???

  /**
   * P06 (*) Find out whether a list is a palindrome.
   *
   * Example:
   * scala> isPalindrome(List(1, 2, 3, 2, 1))
   * res0: Boolean = true
   *
   **/
  def isPalindrome[A](list: List[A]):Boolean = ???

}
