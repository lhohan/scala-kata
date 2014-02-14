

import org.scalatest.FunSuite

/**
 * User: hanlho
 * DateTime: 9/02/14 12:26
 */
class KataTest extends FunSuite {

//  import solutions.Kata._
      import kata.Kata._

  test("factorial") {
    assert(1 === factorial(0), "factorial of '0'")
    assert(1 === factorial(1), "factorial of '1'")
    assert(720 === factorial(6), "factorial of '6'")
  }

  test("factorial tailrec") {
    assert(1 === factorialTailRec(0), "factorial tailrec of '0'")
    assert(1 === factorialTailRec(1), "factorial tailrec of '1'")
    assert(720 === factorialTailRec(6), "factorial tailrec of '6'")
  }

  test("Fibonacci Stream") {
    assert(1 === fibonacciStream(1), "fibonacci stream 1")
    assert(1 === fibonacciStream(2), "fibonacci stream 2")
    assert(2 === fibonacciStream(3), "fibonacci stream 3")
    assert(13 === fibonacciStream(7), "fibonacci stream 7")
  }

  /**
   * Lists
   **/
  test("last") {
    assert(8 === last(List(1, 1, 2, 3, 5, 8)))
  }

  test("penultimate") {
    assert(5 === penultimate(List(1, 1, 2, 3, 5, 8)))
  }

  test("kth") {
    assert(2 === kth(2, List(1, 1, 2, 3, 5, 8)))
  }

  test("length") {
    assert(6 === length(List(1, 1, 2, 3, 5, 8)))
  }

  test("reverse") {
    assert(List(8, 5, 3, 2, 1, 1) === reverse(List(1, 1, 2, 3, 5, 8)))
  }

  test("palindrome") {
    assert(isPalindrome(List(1, 2, 3, 2, 1)), "isPalindrome 1")
    assert(isPalindrome(List()), "isPalindrome on empty")
    assert(isPalindrome(List(1, 2, 2, 2, 1)), "isPalindrome 2")
    assert(isPalindrome(List(1, 2, 2, 1)), "isPalindrome 3")
    assert(!isPalindrome(List(1, 2, 3, 3, 1)), "isPalindrome 4")
  }

  test("flatten") {
    assert(List(1, 1, 2, 3, 5, 8) === flatten(List(List(1, 1), 2, List(3, List(5, 8)))))
  }

  test("compress") {
    assert(List('a, 'b, 'c, 'a, 'd, 'e) ===  compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  //  test("factorial streams") {
  //    assert (1 === factorialStreams(0), "factorial tailrec of '0'")
  //    assert (1 === factorialStreams(1), "factorial tailrec of '1'")
  //    assert (720 === factorialStreams(6), "factorial tailrec of '6'")
  //  }

}
