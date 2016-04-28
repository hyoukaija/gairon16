abstract class ParentTree
case object Empty extends ParentTree
case class MakeParent(
  children:List[ParentTree],
  name:Symbol, 
  date:Int, 
  eyes:Symbol
) extends ParentTree

:paste //相互再帰函数のためのおまじない．消さないこと．
