<<<<<<< HEAD
def flatten[X]:(List[List[X]])=>List[X] =
(lst)=>
{
	lst match{
		case Nil=>Nil
		case e::rst=>def thing:(List[X])=>List[X] =(lst1)=>{lst1 match{
			case Nil=>flatten[X](rst)
			case e::rst1=>e::thing(rst1)
		}
	}
	thing(e)
	}
=======


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
>>>>>>> 7580ad2ddd3cdaf8f416d4ea7b41d8f0e29c9238
}