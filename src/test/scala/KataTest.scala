

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

}
