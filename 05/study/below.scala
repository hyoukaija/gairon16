def op:(Int,Int)=>Boolean
=
(l,r)=>
{l<r}

def below:((Int,Int)=>Boolean,List[Int],Int)=>List[Int]
=
(op,lst,n)=>lst match{
	case Nil=>Nil
	case e::rst=>if(op(e,n))e::below(op,rst,n) else below(op,rst,n)
}