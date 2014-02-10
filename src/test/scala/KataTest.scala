

import org.scalatest.FunSuite

/**
 * User: hanlho
 * DateTime: 9/02/14 12:26
 */
class KataTest extends FunSuite {

//  import solutions.Kata._
  import kata.Kata._

  test("factorial") {
    assert (1 === factorial(0), "factorial of '0'")
    assert (1 === factorial(1), "factorial of '1'")
    assert (720 === factorial(6), "factorial of '6'")
  }

  test("factorial tailrec") {
    assert (1 === factorialTailRec(0), "factorial tailrec of '0'")
    assert (1 === factorialTailRec(1), "factorial tailrec of '1'")
    assert (720 === factorialTailRec(6), "factorial tailrec of '6'")
  }

  test("Fibonacci Stream") {
    assert(1 === fibonacciStream(1), "fibonacci stream 1")
    assert(1 === fibonacciStream(2), "fibonacci stream 2")
    assert(2 === fibonacciStream(3), "fibonacci stream 3")
    assert(13 === fibonacciStream(7), "fibonacci stream 7")
  }

  /**
   * Lists
   * */
  test("last") {
    assert(8 === last(List(1, 1, 2, 3, 5, 8)))
  }

  test("penultimate") {
    assert(5 === penultimate(List(1, 1, 2, 3, 5, 8)))
  }

//  test("factorial streams") {
//    assert (1 === factorialStreams(0), "factorial tailrec of '0'")
//    assert (1 === factorialStreams(1), "factorial tailrec of '1'")
//    assert (720 === factorialStreams(6), "factorial tailrec of '6'")
//  }

}
