package gairon.k06.k01
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._
  "add(Zero(),Zero())" should "be Zero()" in{
    assert(add(Zero(),Zero()) === Zero())
  }

  "add(Succ(Zero()),Succ(Zero()))" should "be Succ(Succ(Zero()))" in{
    assert(add(Succ(Zero()),Succ(Zero())) === Succ(Succ(Zero())))
  }

  "add(Succ(Succ(Zero())),Zero())" should "be Succ(Succ(Zero()))" in{
    assert(add(Succ(Succ(Zero())),Zero()) === Succ(Succ(Zero())))
  }

  "add(Zero(),Succ(Succ(Zero())))" should "be Succ(Succ(Zero()))" in{
    assert(add(Zero(),Succ(Succ(Zero()))) === Succ(Succ(Zero())))
  }

  "add(Succ(Succ(Zero())),Succ(Zero()))" should "be Succ(Succ(Zero()))" in{
    assert(add(Succ(Succ(Zero())),Succ(Zero())) === Succ(Succ(Succ(Zero()))))
  }

  "add(Succ(Zero()),Succ(Succ(Zero())))" should "be Succ(Succ(Zero()))" in{
    assert(add(Succ(Zero()),Succ(Succ(Zero()))) === Succ(Succ(Succ(Zero()))))
  }
}
