package gairon.k11.k03
object Main{
def head[X]:(List[X])=>X
=(lst)=>
{
	lst match{
		case e::rst=>e
	}
}
def end[X]:(List[X])=>List[X]
=(lstdeal)=>
{
	lstdeal match{
		case Nil=>Nil
		case e::rst=>rst
	}
}


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


def reverse[X]:List[X]=>List[X] 
={ 
	def revsub:List[X]=>List[X]=>List[X]
		=(lstL)=>(lstR)=>{
			lstR match{
				case Nil=>lstL
				case e::rst=>revsub(e::lstL)(rst)
		}
	}
	revsub(Nil)
}

def solve:List[List[Double]]=>List[Double]
=(lst)=>
{
	
	def oneLineAnswer:(Double)=>(Double)=>List[Double]=>List[Double]=>List[Double]=>List[Double]
		=(and)=>(n)=>(rans)=>(lstans)=>(lstf)=>
		{
			lstf match{
				case y::Nil=>(y-and)/n::rans
				case x::xs=>oneLineAnswer(x*head(lstans)+and)(n)(rans)(end(lstans))(xs)
			}
		}
	def domany:List[Double]=>List[List[Double]]=>List[Double]
		=(lstans)=>(lstf)=>
		{
			lstf match{
				case Nil=>lstans
				case e::rst=> domany(oneLineAnswer(0)(head(e))(lstans)(lstans)(end(e)))(rst)
			}
		}
	domany(Nil)(reverse(triangular(lst)))
}




















}
