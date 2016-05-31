package gairon.k14.k01
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  "solve(1)(2)" should "not be None" in{
    assert(solve(1)(2)!=None)
  }

  "solve(1)(1)" should "be None" in{
    assert(solve(1)(1)==None)
  }

  "solve(3)(1)" should "be None" in{
    assert(solve(3)(1)==None)
  }

  "solve(3)(2)" should "not be None" in{
    assert(solve(3)(2)!=None)
  }

  "solve(4)(3)" should "not be None" in{
    assert(solve(4)(3)!=None)
  }

  "solve(5)(3)" should "not be None" in{
    assert(solve(5)(3)!=None)
  }
}
