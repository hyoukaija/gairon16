package gairon.k10.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.foldr

  def mul: (Int) => (Int) => Int =
  (x) => (y) => {x * y}

  def add: (Int) => Int => Int =
  (x) => {
    def xaddr: (Int) => Int = (y) => {x + y};
    xaddr
  }

  "foldr(mul)(1)(List(1,2,3))" should "be 6" in{
    assert(foldr(mul)(1)(List(1,2,3)) == 6)
  }

  "foldr(add)(0)(List(1,2,3))" should "be 6" in{
    assert(foldr(add)(0)(List(1,2,3)) == 6)
  }
}
