abstract class Nat
case class Zero() extends Nat
case class Succ(prev:Nat) extends Nat

