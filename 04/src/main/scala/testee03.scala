package gairon.k07.k03
object Main{
abstract class BinarySearchTree[+A]
case object Leaf extends BinarySearchTree[Nothing]
case class Branch[+A](
  key:Int,
  data:A,
  left:BinarySearchTree[A],
  right:BinarySearchTree[A]) extends BinarySearchTree[A]

case class Pair(n:Int, s:Symbol)

def insert: (BinarySearchTree[Symbol], Int, Symbol) => BinarySearchTree[Symbol] = (t,i,s) => {
  t match{
    case Leaf => Branch(i,s,Leaf,Leaf)
    case Branch(k,d,l,r) => if(i < k ) Branch(k,d,insert(l,i,s),r) else Branch(k,d,l,insert(r,i,s))
  }
}

def toBST: (List[Pair]) => BinarySearchTree[Symbol] = (lst) => {
  lst match{
    case Nil => Leaf
    case Pair(n,s)::rest => insert(toBST(rest),n,s)
  }
}
}
