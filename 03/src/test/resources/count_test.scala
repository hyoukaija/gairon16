package gairon.k05.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  def getCountOf(s:Symbol,lst:List[SymbolCount]):Int={
    lst match{
      case Nil => -1
      case SymbolCount(sym,num)::rest => if(s==sym) num else getCountOf(s,rest)
    }
  }

  "counts(List('a,'cat))" should "contain 1 'cat" in{
    assert(getCountOf('cat, counts(List('a,'cat))) === 1)
  }

  "counts(List('a,'cat))" should "contain 1 'a" in{
    assert(getCountOf('a, counts(List('a,'cat))) === 1)
  }

  "counts(List('slowly,'and,'slowly))" should "contain 1 'and" in{
    assert(getCountOf('and, counts(List('slowly,'and,'slowly))) === 1)
  }

  "counts(List('slowly,'and,'slowly))" should "contain 2 'slowly" in{
    assert(getCountOf('slowly, counts(List('slowly,'and,'slowly))) === 2)
  }
}
