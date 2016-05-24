package gairon.k12.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.{placement, buildBoard}

  "Let b be a 1x1 empty board. placement(1)(b)" should "not be None" in{
    val b = buildBoard(1)((x:Int)=>(y:Int)=>{false});
    assert(placement(1)(b) != None)
  }

  "Let b be a 1x1 empty board. placement(2)(b)" should "be None" in{
    val b = buildBoard(1)((x:Int)=>(y:Int)=>{false});
    assert(placement(2)(b) == None)
  }

  "Let b be a 2x2 empty board. placement(2)(b)" should "be None" in{
    val b = buildBoard(2)((x:Int)=>(y:Int)=>{false});
    assert(placement(2)(b) == None)
  }

  "Let b be a 3x3 empty board. placement(1)(b)" should "not be None" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{false});
    assert(placement(1)(b) != None)
  }

  "Let b be a 3x3 empty board. placement(3)(b)" should "be None" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{false});
    assert(placement(3)(b) == None)
  }

  "Let b be a 4x4 empty board. placement(4)(b)" should "not be None" in{
    val b = buildBoard(4)((x:Int)=>(y:Int)=>{false});
    assert(placement(4)(b) != None)
  }

  "Let b be a 4x4 empty board. placement(5)(b)" should "be None" in{
    val b = buildBoard(4)((x:Int)=>(y:Int)=>{false});
    assert(placement(5)(b) == None)
  }

  "Let b be a 4x4 board and has queens at (0,2) (1,0) (2,3). placement(1)(b)" should "not be None" in{
    val b = buildBoard(4)((x:Int)=>(y:Int)=>{(x==0&&y==2) || (x==1&&y==0) || (x==2&&y==3)});
    assert(placement(1)(b) != None)
  }

  "Let b be a 4x4 board and has queens at (0,1) (1,3) (2,0). placement(1)(b)" should "not be None" in{
    val b = buildBoard(4)((x:Int)=>(y:Int)=>{(x==0&&y==1) || (x==1&&y==3) || (x==2&&y==0)});
    assert(placement(1)(b) != None)
  }
}
