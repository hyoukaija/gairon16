package gairon.k04.k01
import org.scalatest.FlatSpec

class SimpleTest extends FlatSpec{
  import Main._

  "perimeter(Square(Position(10,10),4))" should "be 16" in{
    assert(perimeter(Square(Position(10,10),4)) === 16)
  }

  "perimeter(Circle(Position(10,10),20))" should "be 40*PI" in{
    assert(perimeter(Circle(Position(10,10),20)) === 40*PI)
  }
}
