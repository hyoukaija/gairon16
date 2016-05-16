case class Plate(name:Symbol,price:Int)

def comp[T]:(T,Int)=>Boolean
=
(l,n)=>
{
	l match{
		case Plate(na,pr)=>if(pr < n) true else false
	}
}

def belowBudget[T]:((T,Int)=>Boolean,List[T],Int)=>List[T]
=
(comp,lst,pt)=>
{
	lst match{
		case Nil=>Nil
		case e::rst=>if(comp(e,pt)) e::belowBudget[T](comp,rst,pt) else belowBudget[T](comp,rst,pt) 
	}
}