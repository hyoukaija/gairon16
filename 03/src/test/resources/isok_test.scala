package gairon.k05.k01
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  "isOK(1000,List(Plate('A,800),Plate('B,900))" should "true" in{
    assert(isOK(1000,List(Plate('A,800),Plate('B,900))) === true)
  }

  "isOK(1000,List(Plate('A,800),Plate('B,1200))" should "false" in{
    assert(isOK(1000,List(Plate('A,800),Plate('B,1200))) === false)
  }

  "isOK(1000,Nil)" should "false" in{
    assert(isOK(1000,Nil) === false)
  }
}
