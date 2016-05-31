package gairon.k14.k01
object Main{
case class State(person:Int,monster:Int,boat:Int,shore:Boolean)
case class Load(person:Int,monster:Int)
abstract class Option[+X]
case class Some[+X](x:X) extends Option[X]
case object None extends Option[Nothing]

def makeState:(Int)=>(Boolean)=>(Int)=>State
=
(n)=>(shore)=>(boat)=>{State(n,n,boat,shore)}

def next:State=>List[(Load,State)]
=
(sta)=>{
	sta match{
		case State(p,m,b,s)=>{def change:(Int)=>(Int)=>List[(Load,State)]
		=(i)=>(j)=>{
				if(i+j<= b && p-i>0 && m-j>0) (Load(i,j),State(p-i,m-j,b,s))::change(i)(j+1)
				else if(i<= b)	change(i+1)(0)	
				else Nil
		}
		change(0)(1)
	}
	}
}

def isLeagal:State=>Boolean
=
(sta)=>{sta match{
	case State(p,m,b,s)=>if(p < m) false else true
	}
}

def isFinal:State=>Boolean
=
(sta)=>{
	sta match{
		case State(p,m,b,s)=>if(p==0 && m==0) true else false
	}
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
def solve:(Int)=>(Int)=>Option[List[Load]]
=
(n)=>(boat)=>
{
	def sta = makeState(n)(false)(boat)

	def nextfloor:List[(Load,State)]=>List[(Load,State)]
		=(lstLS)=>{
			lstLS match{
				case Nil=>Nil
				case (l,s)::rst=>if(isLeagal(s)) (l,s)::nextfloor(rst) else nextfloor(rst)
			}
		}

	def circulation:Option[List[Load]]=>List[(Load,State)]=>Option[List[Load]]
		=(op)=>(lst)=>{
			lst match{
				case Nil=>None
				case (Load(x,y),State(p,m,b,s))::rst=>op match{
							case None=>if(p==0 && m==0) Some(Load(x,y)::Nil) else circulation(Some(Load(x,y)::Nil))(nextfloor(next(State(p,m,b,s))))
							case Some(lstl)=>if(p==0 && m==0) op else if(nextfloor(next(State(p,m,b,s)))==Nil) circulation(op)(rst)
							else circulation(Some(Load(x,y)::lstl))(nextfloor(next(State(p,m,b,s))))
			}
		}
	}
	def cir=circulation(None)(nextfloor(next(sta)))

	def Last:Option[List[Load]]=>Option[List[Load]]
		=(lst)=>{lst match{
				case None=>None
				case Some(lstL)=>Some(reverse(lstL))
			}
		}
	Last(cir)

/*
	def move:(Option[List[Load]])=>List[Load,State]=>Option[List[Load]]
		=(lst)=>(lstLS)=>{
			if(isLeagal(sta1) && isLeagal(sta2)) (sta1,sta2) match{
				case (State(p1,m1,b1,s1),State(p2,n2,b2,s2))=>
			}else None
			}
		}
*/	
}
}
