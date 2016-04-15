package gairon.k04.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  "checkColor(SymbolPair('red,'blue),SymbolPair('red,'blue))" should "be 'Perfect" in{
    assert(checkColor(SymbolPair('red,'blue),SymbolPair('red,'blue)) === 'Perfect)
  }

  "checkColor(SymbolPair('red,'blue),SymbolPair('blue,'red))" should "be 'OneColorOccurs" in{
    assert(checkColor(SymbolPair('red,'blue),SymbolPair('blue,'red)) === 'OneColorOccurs)
  }

  "checkColor(SymbolPair('red,'blue),SymbolPair('black,'yellow))" should "'NothingCorrect" in{
    assert(checkColor(SymbolPair('red,'blue),SymbolPair('black,'yellow)) === 'NothingCorrect)
  }

  "checkColor(SymbolPair('red,'blue),SymbolPair('red,'red))" should "be 'OneColorAtCorrectPosition" in{
    assert(checkColor(SymbolPair('red,'blue),SymbolPair('red,'red)) === 'OneColorAtCorrectPosition)
  }
}
