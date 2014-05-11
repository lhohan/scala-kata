
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

}
