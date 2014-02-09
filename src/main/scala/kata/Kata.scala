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
  def fibonacciStream(n :Int) = fibFrom(1,1).take(n).toList.last
  def fibFrom(a: Int, b:Int) : Stream[Int] = ???


  /**
   * Working with lists
   **/

  /**
   * Kata:
   * 99P1 implement last _not_ using list.last
   **/
  def last[A](list: List[A]): A = ???


}
