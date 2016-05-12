package gairon.k10.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.conj2disj
  import Main.foldr

  def add: (Int) => Int => Int =
  (x) => {
    def xaddr: (Int) => Int = (y) => {x + y};
    xaddr
  }

  def map[A,B]: (A=>B)=>(List[A])=>List[B] =
    (f) => (lst) => lst match{
      case Nil => Nil
      case e::rst => f(e)::map(f)(rst)
    }

  def mul: (Int) => (Int) => Int =
  (x) => (y) => {x * y}

  def or: Boolean => Boolean => Boolean =
  (x) => (y) => {x || y}
  
  def and: Boolean => Boolean => Boolean =
  (x) => (y) => {x && y}

  "conj2disj(List(List(1,2,3),List(4,5,6))))" should "be evaluated to 90" in{
    assert(foldr(add)(0)(map(foldr(mul)(1))(conj2disj(List(List(1,2,3),List(4,5,6))))) == 90)
  }


  "conj2disj(List(List(true,false),List(false,true)))" should "be evaluated to true" in{
    assert(foldr(or)(false)(map(foldr(and)(true))(conj2disj(List(List(true,false),List(false,true))))) == true)
  }
}
