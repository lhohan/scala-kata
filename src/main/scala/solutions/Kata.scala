package solutions

import scala.annotation.tailrec

object Kata {

  /**
   * Kata :
   * Implement factorial.
   **/
  def factorial(n: Int): Int =  if(n <= 1) 1 else n * factorial(n-1)

  /**
   * Kata :
   * Implement factorial using tail recursion (check using @tailrec).
   **/
  def factorialTailRec(n: Int): Int = {

    @tailrec
    def factorialAcc(n:Int, acc:Int):Int = if (n <= 1) acc else factorialAcc(n-1, n * acc)

    factorialAcc(n, 1)
  }

}
