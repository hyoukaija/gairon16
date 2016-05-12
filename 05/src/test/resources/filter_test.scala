package gairon.k10.k01
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.filter

  def map[A,B]: (A=>B)=>(List[A])=>List[B] =
    (f) => (lst) => lst match{
      case Nil => Nil
      case e::rst => f(e)::map(f)(rst)
    }

  def isEven: Int => Boolean =
  (n) =>{(n & 1) == 0}

  def isOdd: Int => Boolean =
  (n) =>{!isEven(n)}

  def isSingleton[X]: (List[X]) => Boolean =
  (lst) => lst match{
    case Nil => false; case e::Nil => true; case e::rst => false
  }

  "filter(isEven)(List(1,2,3))" should "be List(2)" in {
    assert(filter(isEven)(List(1,2,3)) === List(2))
  }

  "filter(isOdd)(List(1,2,3))" should "be List(1,3)" in {
    assert(filter(isOdd)(List(1,2,3)) === List(1,3))
  }

  "filter(isSingleton)(map(filter(isEven))(List(List(1,2,3),List(4,5,6))))" should "be List(List(2))" in {
    assert(filter(isSingleton)(map(filter(isEven))(List(List(1,2,3),List(4,5,6)))) === List(List(2)))
  }
}
