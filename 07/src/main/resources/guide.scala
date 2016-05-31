case class State(person:Int,monster:Int,boat:Int,shore:Boolean)
case class Load(person:Int,monster:Int,direction:Boolean)
abstract class Option[+X]
case class Some[+X](x:X) extends Option[X]
case object None extends Option[Nothing]

def makeState:(Int)=>(Boolean)=>(Int)=>State
=
(n)=>(shore)=>(boat)=>{State(n,n,boat,shore)}

def next:(Boolean)=>(State,State)=>List[(Load,State,State)]
=
(boolean)=>(sta1,sta2)=>{
	(sta1,sta2) match{
		case (State(p1,m1,b1,s1),State(p2,m2,b2,s2))=>{def change:(Int)=>(Int)=>List[(Load,State,State)]
		=(i)=>(j)=>{
				if(i+j<= b1 && p1-i>=0 && m1-j>=0) {if(boolean){(Load(i,j,boolean),State(p1-i,m1-j,b1,s1),State(p2+i,m2+j,b2,s2))::change(i)(j+1)}
						else (Load(i,j,boolean),State(p1+i,m1+j,b1,s1),State(p2-i,m2-j,b2,s2))::change(i)(j+1)}
				else if(i<= b1)	change(i+1)(0)	
				else Nil
		}
		change(0)(1)
	}
	}
}

def isLeagal:State=>Boolean
=
(sta)=>{sta match{
	case State(p,m,b,s)=>if(p < m && p!=0) false else true
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
def solve:(Int)=>(Int)=>List[(Load,State,State)]//Option[List[Load]]
=
(n)=>(boat)=>
{
	def sta1 = makeState(n)(false)(boat)
	def sta2 = makeState(0)(true)(boat)

	def nextfloor:List[(Load,State,State)]=>List[(Load,State,State)]
		=(lstLS)=>{
			lstLS match{
				case Nil=>Nil
				case (l,s1,s2)::rst=>if(isLeagal(s1)&&isLeagal(s2)) (l,s1,s2)::nextfloor(rst) else nextfloor(rst)
			}
		}
		//nextfloor(next(true)(sta1,sta2))
	def circulation:Option[List[Load]]=>Boolean=>List[(Load,State,State)]=>List[(Load,State,State)]=>Option[List[Load]]
		=(op)=>(boolean)=>(lstrm)=>(lst)=>{
			lst match{
				case Nil=>lstrm match{
					case Nil=>None
					case (Load(x,y,b),s1,s2):rst=>circulation(op)(nextfloor(next(!boolean)(s1,s2)))
				}
				case (Load(x,y,b),State(p1,m1,b1,s1),State(p2,m2,b2,s2))::rst=>op match{
						case None=>if(p1==0 && m1==0) {Some(Load(x,y,b)::Nil)}
							else {
							circulation(Some(Load(x,y,b)::Nil))(!boolean)(nextfloor(next(!boolean)(State(p1,m1,b1,s1),State(p2,m2,b2,s2))))}
						case Some(lstl)=>if(p1==0 && m1==0) op else if(nextfloor(next(!boolean)(State(p1,m1,b1,s1),State(p2,m2,b2,s2)))==Nil) circulation(op)(boolean)(rst)
						else circulation(Some(Load(x,y)::lstl))(nextfloor(next(!boolean)(State(p1,m1,b1,s1),State(p2,m2,b2,s2))))
			}
		}
	}
	def cir=circulation(None)(true)(nextfloor(next(true)(sta1,sta2)))

	def Last:Option[List[Load]]=>Option[List[Load]]
		=(lst)=>{lst match{
				case None=>None
				case Some(lstL)=>Some(reverse(lstL))
			}
		}
	Last(cir)
}




