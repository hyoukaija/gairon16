case class State(person:Int,monster:Int,boat:Int,shore:Boolean)
case class Load(person:Int,monster:Int)
abstract class Option[+X]
case class Some[+X](x:X) extends Option[X]
case class None extends Option[X]

def makeState:(Int)=>(Boolean)=>(Int)=>State
=
(n)=>(shore)=>(boat)=>{State(n,n,boat,shore)}

def next:State=>List[Load]

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

def solve:(Int)=>(Int)=>Option[List[Load]]
=
(n)=>(boat)=>
{
	def sta = makeState(n)(false)(boat)

	
}
