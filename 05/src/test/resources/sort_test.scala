package gairon.k09.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.sort

  val lt: (Int,Int) => Boolean = (l,r) => l < r
  val gt: (Int,Int) => Boolean = (l,r) => l > r 

  case class Plate(name:Symbol, price:Int)

  def ltP: (Plate,Plate) => Boolean = (l,r) => l.price < r.price
  def leqP: (Plate,Plate) => Boolean = (l,r) => l.price <= r.price
  
  "sort(lt,Nil)" should "be Nil" in{
    assert(sort(lt,Nil) === Nil);
  }

  "sort(lt,List(9,1))" should "be List(1,9)" in{
    assert(sort(lt,List(9,1)) === List(1,9));
  }

  "sort(gt,List(1,9))" should "be List(9,1)" in{
    assert(sort(gt,List(1,9)) === List(9,1));
  }

  "sort(ltP,Nil)" should "be Nil" in{
    assert(sort(ltP,Nil) === Nil)
  }

  "sort(ltP,List(Plate('A,200),Plate('B,400),Plate('C,200)))" should "be List(Plate('A,200),Plate('C,200),Plate('B,400))" in{
    assert(sort(ltP,List(Plate('A,200),Plate('B,400),Plate('C,200))) === List(Plate('A,200),Plate('C,200),Plate('B,400)));
  }

  "sort(leqP,List(Plate('A,200),Plate('B,400),Plate('C,200)))" should "be List(Plate('A,200),Plate('C,200),Plate('B,400))" in{
    assert(sort(leqP,List(Plate('A,200),Plate('B,400),Plate('C,200))) === List(Plate('A,200),Plate('C,200),Plate('B,400)));
  }

  "sort(ltP,List(Plate('A,200),Plate('B,400),Plate('C,200), Plate('D, 400), Plate('E,100)))" should "be List(Plate('E,100), Plate('A,200), Plate('C,200), Plate('B,400), Plate('D, 400))" in{
    assert(sort(ltP,List(Plate('A,200),Plate('B,400),Plate('C,200),Plate('D, 400), Plate('E, 100))) === List(Plate('E,100), Plate('A,200),Plate('C,200),Plate('B,400), Plate('D, 400)));
  }

  "sort(leqP,List(Plate('A,200),Plate('B,400),Plate('C,200), Plate('D, 400), Plate('E,100)))" should "be List(Plate('E,100), Plate('A,200), Plate('C,200), Plate('B,400), Plate('D, 400))" in{
    assert(sort(leqP,List(Plate('A,200),Plate('B,400),Plate('C,200),Plate('D, 400), Plate('E, 100))) === List(Plate('E,100), Plate('A,200),Plate('C,200),Plate('B,400), Plate('D, 400)));
  }
}
