package gairon.k11.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.triangular

  "triangular(List(List(1,2,3),List(1,1,2)))" should "be List(List(1.0, 2.0, 3.0), List(-1.0, -1.0))" in{
    assert(triangular(List(List(1,2,3),List(1,1,2))) === List(List(1.0, 2.0, 3.0), List(-1.0, -1.0)))
  }

  "triangular(List(List(2,2,3,10), List(2,5,12,31), List(4,1,-2,1)))" should "be List(List(2,2,3,10),List(3,9,21),List(1,2))" in{
    assert(triangular(List(List(2,2,3,10), List(2,5,12,31), List(4,1,-2,1))) == List(List(2,2,3,10),List(3,9,21),List(1,2)))
  }
}
