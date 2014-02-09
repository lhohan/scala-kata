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

  // TODO?
  /**
   * Kata: Fizzbuzz
   * Write a program that prints the numbers from 1 to 100. But for multiples of three print "Fizz" instead of the
   * number and for the multiples of five print "Buzz". For numbers which are multiples of both three and
   * five print "FizzBuzz".
   */

}
