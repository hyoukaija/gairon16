<<<<<<< HEAD
package gairon.k10.k02
object Main{
def foldr[X,Y]:((X)=>(Y)=>Y)=>Y=>List[X]=>Y =(f)=>{
	def aid:(Y)=>List[X]=>Y =(n)=>{(lst)=>{
			lst match{
				case Nil=>n
				case e::rst=>f(e)(aid(n)(rst))
			}
		}

	}
	aid
=======
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
>>>>>>> 7580ad2ddd3cdaf8f416d4ea7b41d8f0e29c9238
}
}
