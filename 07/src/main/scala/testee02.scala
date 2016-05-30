package gairon.k11.k02
object Main{
def triangular:List[List[Double]]=>List[List[Double]]
=(lst)=>
{
	def multiple:(Double,Double)=>Double = (x,y)=>{y/x}

	def twoList:(List[Double])=>(List[Double])=>List[Double]
		=(lst1)=>(lst2)=>
		{
			def twoListn:(Double)=>(List[Double])=>(List[Double])=>List[Double]
				=(n)=>(lst1)=>(lst2)=>
				{
					(lst1,lst2) match{
						case (Nil,Nil)=>Nil
						case (a::rst1,b::rst2)=>(b-n*a)::twoListn(n)(rst1)(rst2)
						case _=>Nil
					}
				}

			(lst1,lst2) match{
				case (Nil,Nil)=>Nil
				case (a::rst1,b::rst2)=>twoListn(multiple(a,b))(rst1)(rst2)
				case _=>Nil
			}
		}
	def head:(List[List[Double]])=>List[Double]
		=(lst)=>
		{
			lst match{
				case Nil=>Nil
				case e::rst=>e
			}
		}

	def sub:(List[Double])=>List[List[Double]]=>List[List[Double]]
		=(heade)=>(lstdeal)=>
		{
			lstdeal match{
				case Nil=>Nil
				case e::rst=>twoList(heade)(e)::sub(heade)(rst)
			}
		}

	
	def end:(List[List[Double]])=>List[List[Double]]
		=(lstdeal)=>
		{
			lstdeal match{
				case Nil=>Nil
				case e::rst=>rst
			}
		}

	def cycle:(List[List[Double]])=>List[List[Double]]
		=(lstcycle)=>
		{
			lstcycle match{
				case Nil=>Nil
				case e::rst=>if(head(sub(e)(rst))!=Nil) head(sub(e)(rst))::cycle(sub(e)(rst)) else cycle(sub(e)(rst))
			}
		}
	head(lst)::cycle(lst)
}
}
