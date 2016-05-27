package gairon.k11.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.solve

  "solve(List(List(1,1,3),(1,2,5)))" should "be List(1,2)" in{
    assert(solve(List(List(1,1,3),List(1,2,5))) == List(1,2))
  }

  "solve(List(List(2,2,3,10), List(2,5,12,31), List(4,1,-2,1)))" should "be List(1,1,2)" in{
    assert(solve(List(List(2,2,3,10), List(2,5,12,31), List(4,1,-2,1))) == List(1,1,2))
  }
}
