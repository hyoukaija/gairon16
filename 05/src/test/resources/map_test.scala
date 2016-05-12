package gairon.k09.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.map

  def id[X](x:X)=x
  val add1:Int=>Int=(x)=>{x+1}
  val hello:(Symbol)=>List[Symbol]=(s)=>{List('Hello,s)}

  "map(id,Nil)" should "be Nil" in{
    assert(map(id,Nil) === Nil)
  }

  "map(add1,Nil)" should "be Nil" in{
    assert(map(add1,Nil) === Nil)
  }

  "map(add1,List(1,2,3,4))" should "be List(2,3,4,5)" in{
    assert(map(add1,List(1,2,3,4)) === List(2,3,4,5))
  }

  "map(hello,List('Tom,'Mary))" should "be List(List('Hello,'Tom),List('Hello,'Mary))" in{
    assert(map(hello,List('Tom,'Mary)) === List(List('Hello,'Tom),List('Hello,'Mary)))
  }
}
