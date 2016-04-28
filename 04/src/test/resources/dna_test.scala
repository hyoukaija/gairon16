package gairon.k08.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._
  
  "DNAprefix(List('a,'t),List('a,'t,'c))" should "be true" in{
    assert(DNAprefix(List('a,'t),List('a,'t,'c)) === true)
  }

  "DNAprefix(List('a,'t),List('a))" should "be false" in{
    assert(DNAprefix(List('a,'t),List('a)) === false)
  }

  "DNAprefix(List('a,'t),List('a,'t))" should "be true" in{
    assert(DNAprefix(List('a,'t),List('a,'t)) === true)
  }

  "DNAprefix(List('a,'c,'g,'t),List('a,'g,'c,'t,'d))" should "be false" in{
    assert(DNAprefix(List('a,'c,'g,'t),List('a,'g,'c,'t,'d)) === false)
  }

  "DNAprefix(List('a,'a, 'c,'t),List('a,'a,'c,'t,'d))" should "be true" in{
    assert(DNAprefix(List('a,'a,'c,'t),List('a,'a,'c,'t,'d)) === true)
  }

  "DNAprefix(List('a,'a, 'c,'t),List('a,'c,'t,'d))" should "be false" in{
    assert(DNAprefix(List('a,'a,'c,'t),List('a,'c,'t,'d)) === false)
  }

}
