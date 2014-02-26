

import org.scalacheck.Gen
import org.scalatest.FunSuite
import org.scalacheck.Prop.forAll
import org.scalatest.prop.Checkers

/**
 * User: hanlho
 * DateTime: 9/02/14 12:26
 */
class KataTest extends FunSuite with Checkers {

    import solutions.Kata._
//  import kata.Kata._

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
    assert(List('a, 'b, 'c, 'a, 'd, 'e) === compress(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  test("pack") {
    assert(List(List('a, 'a, 'a, 'a), List('b), List('c, 'c), List('a, 'a), List('d), List('e, 'e, 'e, 'e))
      === pack(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  test("encode") {
    assert(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))
      === encode(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  test("encodeModified") {
     assert(List((4,'a), 'b, (2,'c), (2,'a), 'd, (4,'e))
       === encodeModified(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e)))
  }

  test("decode"){
      assert(List('a, 'a, 'a, 'a, 'b, 'c, 'c, 'a, 'a, 'd, 'e, 'e, 'e, 'e) ===
        decode(List((4, 'a), (1, 'b), (2, 'c), (2, 'a), (1, 'd), (4, 'e))))
  }

  test("balance") {
    assert(balance("(if (zero? x) max (/ 1 x))".toList), "balance: '(if (zero? x) max (/ 1 x))' is balanced")
    assert(balance("I told him (that it's not (yet) done).\n(But he wasn't listening)".toList), "balance: 'I told him ...' is balanced")
    assert(!balance(":-)".toList), "balance: ':-)' is unbalanced")
    assert(!balance("())(".toList), "balance: counting is not enough")
  }


  /**
   * Higher order functions
   * */
  test("unless") {
    var x = 1
    unless(x > 5) {
      x += 1
    }
    assert(6 === x)
  }

  /**
   * TODO: move out to different kind of kata
   **/
  test("fizzbuzz") {
    val fb = fizzbuzz(100)
    val range = Gen.choose[Int](1, 100)
    val fizzbuzzProperty = forAll(range) {
      n =>
        if (n % 15 == 0) fb(n - 1) == "FizzBuzz"
        else
        if (n % 5 == 0) fb(n - 1) == "Buzz"
        else
        if (n % 3 == 0) fb(n - 1) == "Fizz"
        else
          fb(n - 1) == n.toString

    }
    check(fizzbuzzProperty)
  }

}
