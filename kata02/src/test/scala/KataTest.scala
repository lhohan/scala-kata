
import org.scalatest.concurrent.Timeouts
import org.scalatest.FunSuite

class KataTest extends FunSuite with Timeouts {

  //    import solutions.Kata._

  import kata.Kata._

  test("and - default cases") {
    assert(false === and(false, true), "Test case: and false true")
    assert(false === and(false, false), "Test case: and false false")
    assert(true === and(true, true), "Test case: and true true")
    assert(false === and(true, false), "Test case: and true false")
  }

  test("and - pass by name") {
    def methodTakingTooLongSoWeCanDetectNoPassByName = {
      Thread.sleep(100)
      false
    }

    import org.scalatest.time.SpanSugar._
    failAfter(30 millis) {
      and(false, methodTakingTooLongSoWeCanDetectNoPassByName)
    }
  }

  def cube = (x: Int) => x * x

  /**
   * Implement the sum of the numbers between a and b (a smaller than b) with the function passed applied to each number.
   **/
  def sum(f: Int => Int)(a: Int, b: Int): Int = a match {
    case a if a > b => 0
    case _ => f(a) + sum(f)(a + 1, b)
  }

  def sum2(f: Int => Int): (Int, Int) => Int = {
    def sumF(a: Int, b: Int): Int = if (a > b) 0 else f(a) + sumF(a + 1, b)
    sumF
  }


  /**
   * Implement the product of the numbers between a and b (a smaller than b) with the function passed applied to each number.
   **/
  def product(f: Int => Int)(a: Int, b: Int): Int = a match {
    case a if a > b => 1
    case _ => f(a) * product(f)(a + 1, b)
  }

  /**
   * Write factorial in terms of product.
   **/
  def factorial(n: Int): Int = product(x => x)(1, n)

  /** Write a more general function which generalizes both sum and product */
  def mapReduce(identity: Int, combine: (Int, Int) => Int)(f: Int => Int)(a: Int, b: Int): Int = a match {
    case a if a > b => identity
    case _ => combine(f(a), mapReduce(identity, combine)(f)(a + 1, b))
  }

  test("sum") {
    assertResult(14) {
      sum(cube)(1, 3)
    }
  }

  test("sum2") {
    assertResult(14) {
      sum2(cube)(1, 3)
    }
  }

  test("product") {
    assertResult(36) {
      product(cube)(1, 3)
    }
  }

  test("factorial") {
    assertResult(120)(factorial(5))
  }

  test("product generalized") {
    assertResult(36) {
      mapReduce(1, (x, y) => x * y)(cube)(1, 3)
    }
  }

}
