package gairon.k12.k02
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main.{isThreatened, buildBoard, Board, isQueen}

  "Let b be a 3x3 empty board. isThreatened(b)(0)(0)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{false});
    assert(isThreatened(b)(0)(0) == false);
  }

  "Let b be a 3x3 empty board. isThreatened(b)(1)(0)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{false});
    assert(isThreatened(b)(1)(0) == false);
  }

  "Let b be a 3x3 empty board. isThreatened(b)(2)(0)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{false});
    assert(isThreatened(b)(2)(0) == false);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(0)(0)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(0)(0) == true);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(1)(0)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(1)(0) == true);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(0)(1)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(0)(1) == true);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(1)(1)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(1)(1) == true);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(2)(2)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(2)(2) == true);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(2)(1)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(2)(1) == false);
  }

  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isThreatened(b)(1)(2)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isThreatened(b)(1)(2) == false);
  }

  "Let b be a 3x3 board. If we put a queen at (1,1) on b, forall 0<=x<3, 0<=y<3, isThreatened(b)(x)(y)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==1&&y==1});
    for(x <- 0 to 2; y <- 0 to 2) assert(isThreatened(b)(x)(y) == true);
  }


  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isQueen(b)(0)(0)" should "be true" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isQueen(b)(0)(0) == true);
  }


  "Let b be a 3x3 board. If we put a queen at (0,0) on b, isQueen(b)(1)(1)" should "be false" in{
    val b = buildBoard(3)((x:Int)=>(y:Int)=>{x==0&&y==0});
    assert(isQueen(b)(1)(1) == false);
  }
}
