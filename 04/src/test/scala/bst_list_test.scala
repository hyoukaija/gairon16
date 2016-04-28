package gairon.k07.k03
import org.scalatest.FlatSpec
class SimpleTest extends FlatSpec{
  import Main._

  def tFold[A,B](f: (Int,A,B,B) => B, v:B, bst: BinarySearchTree[A]):B = {
    bst match{
      case Leaf => v
      case Branch(k,d,l,r) => f(k, d, tFold(f,v,l), tFold(f,v,r))
    }
  }

  def isBST(bst: BinarySearchTree[Symbol]):Boolean = {
    bst match{
      case Leaf => true
      case Branch(k,d,l,r) => {
        tFold((x:Int, y:Symbol, rl:Boolean, rr:Boolean)=>{ x < k }, true, l) &&
        tFold((x:Int, y:Symbol, rl:Boolean, rr:Boolean)=>{ k <= x }, true, r) &&
        isBST(l) && isBST(r)
      }
    }
  }

  def toList(bst: BinarySearchTree[Symbol]):List[Pair] = {
    bst match{
      case Leaf => Nil
      case Branch(k,d,l,r) => Pair(k,d) :: (toList(l) ++ toList(r))
    }
  }

  def containsAll[A](x:List[A], y:List[A]):Boolean = {
    x.forall((p:A)=>{y.contains(p)})
  }

  "toBST(List(Pair(1,'s)))" should "be Branch(1,'s,Leaf,Leaf)" in {
    assert(toBST(List(Pair(1,'s))) === Branch(1,'s,Leaf,Leaf))
  }

  "toBST(List(Pair(1,'s), Pair(2,'s)))" should "be a binary search tree" in {
    val bst = toBST(List(Pair(1,'s), Pair(2,'s)))
    assert(isBST(bst) === true)
  }

  "toBST(List(Pair(1,'s), Pair(2,'s)))" should "contain all elements of List(Pair(1,'s), Pair(2,'s))" in {
    val lst = List(Pair(1,'s), Pair(2,'s))
    val blst = toList(toBST(lst))
    assert(containsAll(lst,blst) === true)
  }

  "toBST(List(Pair(1,'s), Pair(2,'s)))" should "contain only elements of List(Pair(1,'s), Pair(2,'s))" in {
    val lst = List(Pair(1,'s), Pair(2,'s))
    val blst = toList(toBST(lst))
    println(toBST(lst));
    assert(containsAll(blst,lst) === true)
    assert(blst.length === lst.length)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s)))" should "be a binary search tree" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s))
    assert(isBST(toBST(lst)) === true)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s)))" should "contain all elements of List(Pair(1,'s), Pair(2,'s))" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s))
    val blst = toList(toBST(lst))
    assert(containsAll(lst,blst) === true)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s)))" should "contain only elements of List(Pair(1,'s), Pair(2,'s))" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s))
    val blst = toList(toBST(lst))
    assert(containsAll(blst,lst) === true)
    assert(blst.length === lst.length)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a)))" should "be a binary search tree" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a))
    assert(isBST(toBST(lst)) === true)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a)))" should "contain all elements of List(Pair(1,'s), Pair(2,'s), Pair(0, 'a))" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a))
    val blst = toList(toBST(lst))
    assert(containsAll(lst,blst) === true)
  }

  "toBST(List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a)))" should "contain only elements of List(Pair(1,'s), Pair(2,'s), Pair(0, 'a))" in {
    val lst = List(Pair(5,'s), Pair(12,'s), Pair(1,'s), Pair(0, 'a))
    val blst = toList(toBST(lst))
    assert(containsAll(blst,lst) === true)
    assert(blst.length === lst.length) 
  }  
}
