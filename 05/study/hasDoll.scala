def hasDoll:(List[Symbol])=>Boolean
=
(inventory)=>
{
	inventory match{
		case Nil=>false
		case e::lst=>if(e=='doll)true else hasDoll(lst)
}
}

