package gairon.k08.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  "giftPick(List('Louise,'Jane))" should "be List(List('Jane, 'Louise))" in{
    assert(giftPick(List('Louise,'Jane)) === List(List('Jane, 'Louise)))
  }

  "the length of giftPick(List('Louise,'Jane,'Laura))" should "be 2" in{
    assert(giftPick(List('Louise,'Jane,'Laura)).size === 2)
  }

  "giftPick(List('Louise,'Jane,'Laura))" should "contain List('Jane, 'Laura, 'Louise)" in{
    assert(giftPick(List('Louise,'Jane,'Laura)) contains List('Jane, 'Laura, 'Louise))
  }

  "giftPick(List('Louise,'Jane,'Laura))" should "contain List('Laura, 'Louise, 'Jane)" in{
    assert(giftPick(List('Louise,'Jane,'Laura)) contains List('Laura, 'Louise, 'Jane))
  }

  "the length of giftPick(List('Louise,'Jane,'Laura,'Dana))" should "be 9" in{
    assert(giftPick(List('Louise,'Jane,'Laura,'Dana)).size === 9)
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Jane, 'Laura, 'Dana, 'Louise)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Jane, 'Laura, 'Dana, 'Louise))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Laura, 'Louise, 'Dana, 'Jane)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Laura, 'Louise, 'Dana, 'Jane))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Laura, 'Dana, 'Louise, 'Jane)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Laura, 'Dana, 'Louise, 'Jane))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Laura, 'Dana, 'Jane, 'Louise)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Laura, 'Dana, 'Jane, 'Louise))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Jane, 'Louise, 'Dana, 'Laura)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Jane, 'Louise, 'Dana, 'Laura))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Jane, 'Dana, 'Louise, 'Laura)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Jane, 'Dana, 'Louise, 'Laura))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Dana, 'Louise, 'Jane, 'Laura)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Dana, 'Louise, 'Jane, 'Laura))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Dana, 'Laura, 'Louise, 'Jane)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Dana, 'Laura, 'Louise, 'Jane))
  }

  "giftPick(List('Louise,'Jane,'Laura,'Dana))" should "contain List('Dana, 'Laura, 'Jane, 'Louise)" in{
    assert(giftPick(List('Louise,'Jane,'Laura, 'Dana)) contains List('Dana, 'Laura, 'Jane, 'Louise))
  }
}
