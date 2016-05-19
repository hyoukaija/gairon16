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
}
}
