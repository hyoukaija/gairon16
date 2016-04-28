package gairon.k07.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._
  val Gustav = MakeParent(Nil,'Gustav, 1988, 'brown)
  val Adam = MakeParent(Nil, 'Adam, 1950, 'yellow)
  val Dave = MakeParent(Nil, 'Dave, 1955, 'black)
  val Eva = MakeParent(List(Gustav), 'Eva, 1965, 'blue)
  val Fred = MakeParent(List(Gustav), 'Fred, 1966, 'pink)
  val Carl = MakeParent(List(Adam,Dave,Eva), 'Carl, 1926, 'green)
  val Bettina = MakeParent(List(Adam,Dave,Eva), 'Bettina, 1926, 'green)

  "colors(Bettina)" should "contain 'green" in{
    assert(colors(Bettina) contains 'green)
  }

  "colors(Bettina)" should "contain 'blue" in{
    assert(colors(Bettina) contains 'blue)
  }

  "colors(Bettina)" should "contain 'black" in{
    assert(colors(Bettina) contains 'black)
  }

  "colors(Bettina)" should "contain 'yellow" in{
    assert(colors(Bettina) contains 'yellow)
  }

  "colors(Bettina)" should "contain 'brown" in{
    assert(colors(Bettina) contains 'brown)
  }

  "colors(Bettina)" should "not contain 'pink" in{
    assert(!(colors(Bettina) contains 'pink))
  }

  "colors(Fred)" should "contain 'pink" in{
    assert(colors(Fred) contains 'pink)
  }
}
