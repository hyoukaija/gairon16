package gairon.k09.k01
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.flatten
  
  "flatten(Nil)" should "be Nil" in{
    assert(flatten(Nil) === Nil)
  }

  "flatten(List(List(1,2,3),List(4,5,6)))" should "be List(1,2,3,4,5,6)" in{
    assert(flatten(List(List(1,2,3),List(4,5,6))) === List(1,2,3,4,5,6))
  }

  "flatten(List(List('a,'b),List('c,'d)))" should "be List('a,'b,'c,'d)" in{
    assert(flatten(List(List('a,'b),List('c,'d))) === List('a,'b,'c,'d))
  }
}
