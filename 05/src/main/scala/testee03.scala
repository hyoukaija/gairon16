package gairon.k09.k01
object Main{


def flatten[X]:(List[List[X]])=>List[X]
=
(lst)=>
{	
	lst match{
		case Nil=>Nil
		case e::rst=>def thing:(List[X])=>List[X] =(lst1)=>
							{lst1 match{ case Nil=>flatten[X](rst)
	                                     case w::rst=>w::thing(rst)
						}}
		thing(e)
		}
}
}
