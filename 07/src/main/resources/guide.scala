case class State(person:Int,monster:Int,boat:Int)
case class Load(person:Int,monster:Int,direction:Boolean)
abstract class Option[+X]
case class Some[+X](x:X) extends Option[X]
case object None extends Option[Nothing]

def makeState:(Int)=>(Int)=>State
=
(n)=>(boat)=>{State(n,n,boat)}

def next:(Boolean)=>(State,State)=>List[(Load,State,State)]
=
(boolean)=>(sta1,sta2)=>{
	(sta1,sta2) match{
		case (State(p1,m1,b1),State(p2,m2,b2))=>{
		def change:(Int)=>(Int)=>List[(Load,State,State)]
			=(i)=>(j)=>{
				if(i+j<= b1 && p1-i>=0 && m1-j>=0) {if(boolean){(Load(i,j,boolean),State(p1-i,m1-j,b1),State(p2+i,m2+j,b2))::change(i)(j+1)}
						else (Load(i,j,boolean),State(p1+i,m1+j,b1),State(p2-i,m2-j,b2))::change(i)(j+1)}
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
	case State(p,m,b)=>if(p < m && p!=0) false else true
	}
}

def isFinal:State=>Boolean
=
(sta)=>{
	sta match{
		case State(p,m,b)=>if(p==0 && m==0) true else false
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
def solve:(Int)=>(Int)=>/*List[(Load,State,State)]*/Option[List[Load]]
=
(n)=>(boat)=>
{
	def sta1 = makeState(n)(boat)
	def sta2 = makeState(0)(boat)

	def nextfloor:List[(Load,State,State)]=>List[(Load,State,State)]
		=(lstLS)=>{
			lstLS match{
				case Nil=>Nil
				case (l,s1,s2)::rst=>if(isLeagal(s1)&&isLeagal(s2)) (l,s1,s2)::nextfloor(rst) else nextfloor(rst)
			}
		}


	//nextfloor(next(true)(sta1,sta2))
	
	def oneLine[X]:Option[List[Load]]=>(Boolean)=>List[(Load,State,State)]=>List[(Load,State,State)]=>Option[List[Load]]
		=(op)=>(boolean)=>(lstsup)=>(lstDown)=>{
			lstDown match{
				case Nil=>lstsup match{
					case Nil=>None
					case e::rst=>oneLine(op)(boolean)(rst)(e)
				}
				case (l,s1,s2)::rst=>if(isFinal(s1)) 
				{op match{
						case None=>Some(l::Nil)
						case Some(lstl)=>Some(l::lstl)
					}
				}else {
					op match{
						case None=>oneLine(Some(l::Nil))(!boolean)(rst::lstsup)(nextfloor(next(!boolean)(s1,s2)))
						case Some(lstl)=>oneLine(Some(l::lstl))(!boolean)(rst::lstsup)(nextfloor(next(!boolean)(s1,s2)))
					}
				}
	}
}
	def cir=oneLine(None)(true)(Nil)(nextfloor(next(true)(sta1,sta2)))

	def Last:Option[List[Load]]=>Option[List[Load]]
		=(lst)=>{lst match{
				case None=>None
				case Some(lstL)=>Some(reverse(lstL))
			}
		}
	Last(cir)
	
}




