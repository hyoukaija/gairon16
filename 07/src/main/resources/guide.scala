case class State(person:Int,monster:Int,boat:Int,shore:Boolean)
case class Load(person:Int,monster:Int,direction:Boolean)
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
				if(i+j<= b) (Load(i,j,true),State(p-i,m-j,b,s))::change(i)(j+1)
				else if(i<= b)	change(i+1)(0)	
				else Nil
		}
		change(0)(0)
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
/*
def solve:(Int)=>(Int)=>Option[List[Load]]
=
(n)=>(boat)=>
{
	def sta = makeState(n)(false)(boat)

	def move:(Option[List[Load]])=>List[Load,State]=>Option[List[Load]]
		=(lst)=>(lstLS)=>{
			if(isLeagal(sta1) && isLeagal(sta2)) (sta1,sta2) match{
				case (State(p1,m1,b1,s1),State(p2,n2,b2,s2))=>
			}else None
			}
		}
	
}
*/