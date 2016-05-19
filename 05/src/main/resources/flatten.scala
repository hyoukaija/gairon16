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
}