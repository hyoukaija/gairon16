//文割統治法：クイックソート

def lt:Int=>Int=>Boolean = (l)=>(r)=>{l < r}
/*
def flip[X,Y,Z]:(X=>Y=>Z)=>Y=>X=>Z=
(f)=>(r)=>(l)=>
{
	f(l)(r)
}
*/
def filter[X]:((X)=>(X)=>Boolean)=>X=>List[X]=>List[X]
=
(p)=>(h)=>(lst)=>
{
	lst match{
		case Nil=>Nil
		case e::rst=>if(p(e)(h)) e::filter(p)(h)(rst) else filter(p)(h)(rst)
	}
}

def qsort[X]:(X=>X=>Boolean)=>List[X]=>List[X]
=
(q)=>(lst)=>
{
	lst match{
		case Nil=>Nil
		case e::rst=> qsort(q)(filter(q)(e)(rst))++(e::qsort(q)(filter((x:X)=>(y:X)=>q(x)(y)==false)(e)(rst)))
	}
}