package gairon.k03.k01
import org.scalatest._

class SimpleSpec extends FlatSpec{
  "payBack(400)" should "be 1" in{
    assert(Main.payBack(400) == 1)
  }
  "payBack(1400)" should "be 5.75" in{
    assert(Main.payBack(1400) == 5.75)
  }
}
